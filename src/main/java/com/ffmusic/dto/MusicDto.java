package com.ffmusic.dto;

import com.ffmusic.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

@Data
public class MusicDto {

    private String id;

    private String name;

    private MusicStatus status;

    private String description;

    private FileDto file;
    private Date createdTime;

    private Date updatedTime;

    @Override
    public String toString() {
        return "MusicDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
