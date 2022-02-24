package com.ffmusic.entity;

import com.ffmusic.enums.FileStatus;
import com.ffmusic.enums.FileType;
import com.ffmusic.enums.Storage;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class File extends AbstractEntity {

    private String name;

    @Column(name = "file_key")
    private String key;

    private String ext;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Enumerated(EnumType.STRING)
    private Storage storage;

    @Enumerated(EnumType.STRING)
    private FileStatus status = FileStatus.UPLOADING;
    private Double size;
}
