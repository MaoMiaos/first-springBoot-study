package com.ffmusic.vo;

import lombok.Data;

@Data
public class FileUploadVo {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String FileId;


    private Long startTime;

    private Long expiredTime;
}
