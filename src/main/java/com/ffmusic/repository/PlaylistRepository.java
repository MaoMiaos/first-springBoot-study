package com.ffmusic.repository;

import com.ffmusic.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
