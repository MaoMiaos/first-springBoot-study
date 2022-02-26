package com.ffmusic.service.Impl;

import com.ffmusic.dto.FileDto;
import com.ffmusic.dto.FileUploadDto;
import com.ffmusic.dto.FileUploadRequest;
import com.ffmusic.entity.File;
import com.ffmusic.enums.FileStatus;
import com.ffmusic.enums.Storage;
import com.ffmusic.exception.BizException;
import com.ffmusic.exception.ExceptionType;
import com.ffmusic.mapper.FileMapper;
import com.ffmusic.repository.FileRepository;
import com.ffmusic.service.FileService;
import com.ffmusic.service.StorageService;
import com.ffmusic.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class FileServiceImpl extends BaseService implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper fileMapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
        // 创建File实体
        File file = fileMapper.createEntity(fileUploadRequest);
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        file.setCreatedBy(getCurrentUserEntity());
        file.setUpdatedBy(getCurrentUserEntity());
        File savedFile = repository.save(file);
        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(savedFile.getKey());
        fileUploadDto.setFileId(savedFile.getId());
        return fileUploadDto;
    }

    @Override
    public FileDto finishUpload(String id) {
        Optional<File> fileOptional = repository.findById(id);
        if (!fileOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }
        //只有上传者才能给更新finish；权限判断
        File file = fileOptional.get();
        if(file.getCreatedBy() != getCurrentUserEntity()){
            throw new BizException(ExceptionType.FILE_NOT_PERMISSION);
        }
        // Todo: 验证远程文件是否存在

        file.setStatus(FileStatus.UPLOADED);
        return fileMapper.toDto(repository.save(file));
    }

    // Todo: 后台设置当前Storage
    public Storage getDefaultStorage() {
        return Storage.COS;
    }


    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper( FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }
}