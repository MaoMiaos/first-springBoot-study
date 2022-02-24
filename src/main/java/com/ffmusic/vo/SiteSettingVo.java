package com.ffmusic.vo;

import com.ffmusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {

    private String bucket;

    private String region;

    private Storage storage;
}
