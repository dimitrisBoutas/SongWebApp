/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boutas.songwebapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dimitris-pc
 */
@Entity
@Table(name = "songs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s")
    , @NamedQuery(name = "Song.findById", query = "SELECT s FROM Song s WHERE s.id = :id")
    , @NamedQuery(name = "Song.findByTitle", query = "SELECT s FROM Song s WHERE s.title = :title")
    , @NamedQuery(name = "Song.findByArtist", query = "SELECT s FROM Song s WHERE s.artist = :artist")
    , @NamedQuery(name = "Song.findByAlbum", query = "SELECT s FROM Song s WHERE s.album = :album")
    , @NamedQuery(name = "Song.findByReleaseYear", query = "SELECT s FROM Song s WHERE s.releaseYear = :releaseYear")
    , @NamedQuery(name = "Song.findByMp3filename", query = "SELECT s FROM Song s WHERE s.mp3filename = :mp3filename")})
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "artist")
    private String artist;
    @Size(max = 45)
    @Column(name = "album")
    private String album;
    @Lob
    @Column(name = "mp3")
    private byte[] mp3;
    @Lob
    @Size(max = 65535)
    @Column(name = "lyrics")
    private String lyrics;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "mp3filename")
    private String mp3filename;

    public Song() {
    }

    public Song(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public byte[] getMp3() {
        return mp3;
    }

    public void setMp3(byte[] mp3) {
        this.mp3 = mp3;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public String getMp3filename() {
        return mp3filename;
    }

    public void setMp3filename(String mp3filename) {
        this.mp3filename = mp3filename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boutas.songwebapp.entities.Song[ id=" + id + " ]";
    }
    
}
