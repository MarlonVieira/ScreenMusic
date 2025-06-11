package br.com.alura.ScreenMusic.repository;

import br.com.alura.ScreenMusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

//    @Query("select a from artists a WHERE a.name ILIKE %:name%")
    Optional<Artist> findByNameContainingIgnoreCase(String name);
}
