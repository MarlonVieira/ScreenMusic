package br.com.alura.ScreenMusic.repository;

import br.com.alura.ScreenMusic.model.Artist;
import br.com.alura.ScreenMusic.model.Musics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

//    @Query("select a from artists a WHERE a.name ILIKE %:name%")
    Optional<Artist> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:artist%")
    List<Musics> searchMusicByArtist(String artist);
}
