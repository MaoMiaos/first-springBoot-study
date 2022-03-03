package com.ffmusic.mapper;

import com.ffmusic.dto.PlaylistDto;
import com.ffmusic.entity.Playlist;
import com.ffmusic.vo.PlaylistVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
