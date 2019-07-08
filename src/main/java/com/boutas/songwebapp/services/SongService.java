/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.services;

import com.boutas.songwebapp.entities.Song;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author smavros
 */
@Service
public interface SongService {
    
    public List<Song> getAllSongs();
    
    public List<Song> getSongsByTitle(String title);
    
    public List<Song> getSongsByArtist(String artist);
    
    public Song getSongById(int id);
    
    public boolean insertSong(Song song);
    
    public boolean deleteSong(int id);
    
    public void updateSong(Song song);
    
    
}