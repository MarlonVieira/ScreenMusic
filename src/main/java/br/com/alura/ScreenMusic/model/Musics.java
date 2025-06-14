package br.com.alura.ScreenMusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Musics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Artist artist;

    public Musics() {
    }

    public Musics(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return  "title: '" + title + '\'' +
                ", artist: " + artist.getName();
    }
}
