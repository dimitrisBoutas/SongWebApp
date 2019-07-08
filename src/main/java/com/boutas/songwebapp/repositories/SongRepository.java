/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.repositories;

import com.boutas.songwebapp.entities.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dimitris-pc
 */
@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
    
    public List<Song> findByTitle(String title);
    public List<Song> findByArtist(String artist);
    public List<Song> findByAlbum(String Album);
}
