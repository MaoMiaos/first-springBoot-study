package com.ffmusic.mapper;

import com.ffmusic.dto.SiteSettingDto;
import com.ffmusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
