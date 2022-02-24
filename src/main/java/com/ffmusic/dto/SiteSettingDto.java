package com.ffmusic.dto;

import com.ffmusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {

    private String bucket;

    private String region;

    private Storage storage;
}
