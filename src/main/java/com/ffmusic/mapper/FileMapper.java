package com.ffmusic.mapper;

import com.ffmusic.dto.FileDto;
import com.ffmusic.dto.FileUploadRequest;
import com.ffmusic.entity.File;
import com.ffmusic.vo.FileVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FileMapper {

    FileDto toDto(File file);

    FileVo toVo(FileDto fileDto);

    File createEntity(FileUploadRequest fileUploadRequest);
}
