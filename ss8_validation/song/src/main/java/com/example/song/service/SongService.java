package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
   ISongRepository repository;

    @Override
    public List<Song> findAll() {
        return repository.findAllSong();
    }

    @Override
    public void addSong(Song song) {
        repository.save(song);
    }

    @Override
    public Song findById(int id) {
        return repository.findSongById(id);
    }

    @Override
    public void update(Song song) {
        repository.update(song.getId(), song.getName(), song.getSinger(), song.getMusicType());
    }
}
