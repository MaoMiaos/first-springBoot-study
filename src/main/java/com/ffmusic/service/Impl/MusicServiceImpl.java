package com.ffmusic.service.Impl;

import com.ffmusic.dto.MusicCreateRequest;
import com.ffmusic.dto.MusicDto;
import com.ffmusic.dto.MusicUpdateRequest;
import com.ffmusic.entity.Music;
import com.ffmusic.enums.MusicStatus;
import com.ffmusic.exception.BizException;
import com.ffmusic.exception.ExceptionType;
import com.ffmusic.mapper.MusicMapper;
import com.ffmusic.repository.MusicRepository;
import com.ffmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    MusicMapper musicMapper;

    MusicRepository musicRepository;

    @Override
    public MusicDto create(MusicCreateRequest musicCreateRequest) {
        Music music = musicMapper.createEntity(musicCreateRequest);
        music.setStatus(MusicStatus.DRAFT);
        return musicMapper.toDto(musicRepository.save(music));
    }

    private Music getMusic(String id){
        Optional<Music> musicOptional = musicRepository.findById(id);
        if(!musicOptional.isPresent()){
            throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
        }
        return musicOptional.get();
    }

    @Override
    public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
        Music exitMusic = getMusic(id);
        Music music = musicMapper.updateEntity(exitMusic,musicUpdateRequest);
        return musicMapper.toDto(musicRepository.save(music));
    }


    @Override
    public List<MusicDto> list() {
        return musicRepository.findAll().stream().map(musicMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void publish(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.PUBLISHED);
        musicRepository.save(music);
    }

    @Override
    public void close(String id) {
        Music music  =getMusic(id);
        music.setStatus(MusicStatus.CLOSED);
        musicRepository.save(music);
    }

    @Autowired
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }


    @Autowired
    public void setMusicRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }
}
