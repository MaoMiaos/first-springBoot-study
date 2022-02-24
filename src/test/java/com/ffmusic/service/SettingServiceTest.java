package com.ffmusic.service;

import com.ffmusic.dto.SiteSettingDto;
import com.ffmusic.enums.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SettingServiceTest {


    private SettingService settingService;

    @Test
    void getSiteSetting() {
        SiteSettingDto siteSettingDto = settingService.getSiteSetting();
        Assertions.assertNotNull(
                siteSettingDto.getBucket()
        );
        Assertions.assertNotNull(
                siteSettingDto.getRegion()
        );
        Assertions.assertInstanceOf(Storage.class, siteSettingDto.getStorage());
    }


    @Autowired
    public void setSettingService(SettingService settingService) {
        this.settingService = settingService;
    }
}