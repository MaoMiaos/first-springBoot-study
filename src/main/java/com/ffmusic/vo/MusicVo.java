package com.ffmusic.vo;

import com.ffmusic.entity.File;
import com.ffmusic.enums.MusicStatus;
import lombok.Data;

@Data
public class MusicVo extends BaseVo {

    private String name;

    private MusicStatus status;

    private String description;

    private File file;
}
