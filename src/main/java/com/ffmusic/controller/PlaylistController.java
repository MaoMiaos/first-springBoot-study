package com.ffmusic.controller;

import com.ffmusic.mapper.PlaylistMapper;
import com.ffmusic.service.PlaylistService;
import com.ffmusic.vo.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;
    @GetMapping("/{id}")
    public PlaylistVo get(@PathVariable String id){
        return playlistMapper.toVo(playlistService.get(id)) ;
    }
    @Autowired
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @Autowired
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }
}
