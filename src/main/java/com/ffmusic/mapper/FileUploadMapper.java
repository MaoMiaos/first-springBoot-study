package com.ffmusic.mapper;

import com.ffmusic.dto.FileDto;
import com.ffmusic.dto.FileUploadDto;
import com.ffmusic.entity.File;
import com.ffmusic.vo.FileUploadVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FileUploadMapper {
    FileDto toDto(File file);

    FileUploadVo toVo(FileUploadDto fileUploadDto);

}
