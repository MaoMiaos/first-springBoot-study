package com.ffmusic.service.Impl;

import com.ffmusic.dto.PlaylistDto;
import com.ffmusic.entity.Playlist;
import com.ffmusic.exception.BizException;
import com.ffmusic.exception.ExceptionType;
import com.ffmusic.mapper.PlaylistMapper;
import com.ffmusic.repository.PlaylistRepository;
import com.ffmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository playlistRepository;

    private PlaylistMapper playlistMapper;

    @Override
    public PlaylistDto get(String id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (!playlist.isPresent()) {
            throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
        }
        return playlistMapper.toDto(playlist.get());
    }
    @Autowired
    public void setPlaylistRepository(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }
    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }
}
