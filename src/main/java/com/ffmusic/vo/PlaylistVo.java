package com.ffmusic.vo;

import com.ffmusic.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistVo extends BaseVo{

    private String id;

    private String name;

    private FileVo cover;

    private String description;
    private UserVo creator;

    private PlayListStatus status;

    private List<MusicVo> musicList;

    private Date createdTime;

    private Date updatedTime;
}
