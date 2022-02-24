package com.ffmusic.controller;

import com.ffmusic.dto.FileUploadRequest;
import com.ffmusic.mapper.FileMapper;
import com.ffmusic.mapper.FileUploadMapper;
import com.ffmusic.service.FileService;
import com.ffmusic.vo.FileUploadVo;
import com.ffmusic.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/files")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class FileController {

    private FileService service;

    private FileUploadMapper fileUploadMapper;

    private FileMapper fileMapper;

    @PostMapping("/upload_init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) throws Exception {
        return fileUploadMapper.toVo(service.initUpload(fileUploadRequest));
    }

    @PostMapping("/{id}/upload_finish")
    public FileVo finishUpload(@PathVariable String id) {
        return fileMapper.toVo(service.finishUpload(id));
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.service = fileService;
    }

    @Autowired
    public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }

    @Autowired
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }
}


