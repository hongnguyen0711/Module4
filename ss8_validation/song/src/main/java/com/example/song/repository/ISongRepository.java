package com.example.song.repository;

import com.example.song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    @Query(value = "select * from Song", nativeQuery = true)
    List<Song> findAllSong();

    @Query(value = "select * from Song where id = :id", nativeQuery = true)
    Song findSongById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update Song set name = :name, singer = :singer, music_type = :musicType where id = :id", nativeQuery = true)
    void update(@Param("id")int id,@Param("name") String name,@Param("singer") String singer,@Param("musicType") String musicType);
}
