/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Dimitris-pc
 */
@Component
public class LyricsApiCallTool {

    @Autowired
    private RestTemplate restTemplate;

    public LyricsApiCallTool() {};
    
    public String getLyricsFromApi(String artist, String song) {
        String result = null;
        String url = "https://api.lyrics.ovh/v1/" + artist + "/" + song;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            JsonNode jsonNode = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                jsonNode = objectMapper.readTree(responseEntity.getBody());
            } catch (IOException ex) {
                Logger.getLogger(LyricsApiCallTool.class.getName()).log(Level.SEVERE, null, ex);
            }

            result = jsonNode.get("lyrics").asText();
            result.replace("/n", "<br>");
        }
        return result;
    }
}
