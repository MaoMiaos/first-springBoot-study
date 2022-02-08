package com.ffmusic.mapper;

import com.ffmusic.dto.MusicCreateRequest;
import com.ffmusic.dto.MusicDto;
import com.ffmusic.dto.MusicUpdateRequest;
import com.ffmusic.entity.Music;
import com.ffmusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MusicMapper {
    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
