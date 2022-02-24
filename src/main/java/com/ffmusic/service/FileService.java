package com.ffmusic.service;

import com.ffmusic.dto.FileDto;
import com.ffmusic.dto.FileUploadDto;
import com.ffmusic.dto.FileUploadRequest;
import com.ffmusic.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();
}
