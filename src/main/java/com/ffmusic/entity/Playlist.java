package com.ffmusic.entity;

import com.ffmusic.enums.PlayListStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Playlist extends AbstractEntity{
    private String name;

    @OneToOne
    private File cover;

    private String description;
    @OneToOne
    private User creator;

    @Enumerated(EnumType.STRING)
    private PlayListStatus status;

    @ManyToMany
    @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private List<Music> musicList;
}
