package com.ffmusic.dto;

import com.ffmusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistDto {

    private String id;

    private String name;

    private FileDto cover;

    private String description;
    private UserDto creator;

    private PlayListStatus status;

   private List<MusicDto> musicList;

   private Date createdTime;

   private Date updatedTime;

}
