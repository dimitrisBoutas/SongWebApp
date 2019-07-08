/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.services;

import com.boutas.songwebapp.entities.Song;
import com.boutas.songwebapp.repositories.SongRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dimitris-pc
 */
@Component
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;
    
    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> getSongsByTitle(String title) {
        return songRepository.findByTitle(title);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        return songRepository.findByArtist(artist);
    }

    @Override
    public Song getSongById(int id) {
        return songRepository.getOne(id);
    }
    
    @Transactional
    @Override
    public boolean insertSong(Song song) {
        songRepository.save(song);
        return true;
//        TODO : find a way .save(S s) return boolean instead of S
    }
    
    @Transactional
    @Override
    public boolean deleteSong(int id) {
        songRepository.deleteById(id);
        return true;
//        TODO : find a way .deleteById(int id) return boolean instead of void
    }
    
    @Transactional
    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
    
}
