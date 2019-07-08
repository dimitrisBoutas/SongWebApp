/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.controllers;

import com.boutas.songwebapp.entities.Song;
import com.boutas.songwebapp.services.SongService;
import com.boutas.songwebapp.utilities.LyricsApiCallTool;
import com.boutas.songwebapp.utilities.ReadTagsTool;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dimitris-pc
 */
@Controller
public class AppController {

    @Autowired
    private SongService songService;
    
    @Autowired 
    private LyricsApiCallTool lacTool;
    
    @Autowired
    private ReadTagsTool rtTool;

    @PostMapping("/upload")
    public String uploadSong(ModelMap modelmap, @RequestParam(value = "songfile") MultipartFile file) {
        Song song = new Song();

        try {
            song.setMp3filename(file.getOriginalFilename());
            song.setMp3(file.getBytes());
            rtTool.getMP3Info(file, song);
            song.setLyrics(lacTool.getLyricsFromApi(song.getArtist(), song.getTitle()));
            
            songService.insertSong(song);
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/allsongs";
    }

    @GetMapping("/allsongs")
    public String getAllSongsGoToMain(ModelMap modelmap) {
        modelmap.put("list", songService.getAllSongs());
        return "main";
    }

    @GetMapping("/download/{id}")
    public @ResponseBody byte[] downloadSong(@PathVariable("id") int id, HttpServletResponse response) {
        Song song = songService.getSongById(id);
        response.setContentType("audio/mp3");
        return song.getMp3();
    }
    
    @GetMapping("/getLyrics/{id}")
    public String getLyrics(@PathVariable("id") int id, ModelMap modelmap){
        modelmap.put("song",songService.getSongById(id));
        return "lyrics";
    }
}
