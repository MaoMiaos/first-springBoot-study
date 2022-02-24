package com.ffmusic.vo;

import com.ffmusic.enums.FileStatus;
import com.ffmusic.enums.FileType;
import lombok.Data;

@Data
public class FileVo extends BaseVo {
    private String name;

    private Long size;
    private String key;

    private String ext;

    private FileType type;


    private FileStatus status;


}
