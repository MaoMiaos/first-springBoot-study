package com.ffmusic.dto;

import com.ffmusic.enums.FileStatus;
import com.ffmusic.enums.FileType;
import com.ffmusic.enums.Storage;
import lombok.Data;

import java.util.Date;

@Data
public class FileDto {
    private String id;

    private String name;

    private Long size;
    private String key;

    private String ext;

    private FileType type;


    private Storage storage;

    private FileStatus status;

    private Date createdTime;

    private Date updatedTime;
}
