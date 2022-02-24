package com.ffmusic.controller;


import com.ffmusic.mapper.SiteSettingMapper;
import com.ffmusic.service.SettingService;
import com.ffmusic.vo.SiteSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/settings")
public class SettingController {

    private SettingService settingService;

    private SiteSettingMapper settingMapper;

    @GetMapping("/site")
    public SiteSettingVo getSiteSetting() {
        return settingMapper.toVo(settingService.getSiteSetting());
    }

    @Autowired
    public void setSettingService(SettingService settingService) {
        this.settingService = settingService;
    }

    @Autowired
    public void setSettingMapper(SiteSettingMapper settingMapper) {
        this.settingMapper = settingMapper;
    }
}