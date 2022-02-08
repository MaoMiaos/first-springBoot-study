package com.ffmusic.service;

import com.ffmusic.dto.MusicCreateRequest;
import com.ffmusic.dto.MusicDto;
import com.ffmusic.dto.MusicUpdateRequest;

import java.util.List;

public interface MusicService {

    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id,MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void close(String id);

}
