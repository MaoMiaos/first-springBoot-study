package com.ffmusic.service;

import com.ffmusic.dto.FileDto;
import com.ffmusic.dto.FileUploadDto;
import com.ffmusic.dto.FileUploadRequest;
import com.ffmusic.enums.FileStatus;
import com.ffmusic.enums.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class FileServiceTest {

    private FileService fileService;

    @Test
    void initUpload() throws Exception {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("MP3");
        fileUploadRequest.setKey("423904721390471234901273");
        fileUploadRequest.setSize(30 * 1024L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    void initUploadMaxSize() throws Exception {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("MP3");
        fileUploadRequest.setKey("423904721390471234901273");
        fileUploadRequest.setSize(30 * 102400L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    void finishUpload() throws Exception {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("MP3");
        fileUploadRequest.setKey("423904721390471234901273");
        fileUploadRequest.setSize(30 * 1024L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        FileDto finishFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishFile.getStatus());
    }

    @Test
    void getDefaultStorage() {
        Storage storage = fileService.getDefaultStorage();
        Assertions.assertEquals(Storage.COS, storage);
    }


    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}