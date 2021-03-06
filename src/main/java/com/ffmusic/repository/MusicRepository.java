package com.ffmusic.repository;

import com.ffmusic.entity.Music;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, String> {
    Optional<Music> findById(@NotNull String id);
}
