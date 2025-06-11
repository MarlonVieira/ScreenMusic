package br.com.alura.ScreenMusic.main;

import br.com.alura.ScreenMusic.model.Artist;
import br.com.alura.ScreenMusic.model.ArtistType;
import br.com.alura.ScreenMusic.model.Musics;
import br.com.alura.ScreenMusic.repository.ArtistRepository;
import com.sun.source.tree.WhileLoopTree;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class mainScreenMusic {
    private final ArtistRepository repository;
    private Scanner scan = new Scanner(System.in);

    public mainScreenMusic(ArtistRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option != 0) {
            var menu = """
                    *** ScreenMusic ***
                    
                    1 - Register artists
                    2 - Register musics
                    3 - List musics
                    4 - Search musics by artist
                    5 - Search data about artist
                    
                    0 - Leave""";

            System.out.println(menu);
            option = scan.nextInt();

            scan.nextLine();

            switch (option) {
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listMusic();
                    break;
                case 4:
                    searchMusicByArtist();
                    break;
                case 5:
                    searchArtistData();
                    break;
                case 0:
                    System.out.println("Closing the application!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void registerMusic() {
        System.out.println("Register a music of which artist?");
        var name = scan.nextLine();
        Optional<Artist> artistOptional = repository.findByNameContainingIgnoreCase(name);
        if (artistOptional.isPresent()) {
            System.out.println("Enter the song title: ");
            var title = scan.nextLine();
            Musics musics = new Musics(title);
            musics.setArtist(artistOptional.get());
            artistOptional.get().getMusics().add(musics);
            repository.save(artistOptional.get());
        } else {
            System.out.println("Artist not found!");
        }
    }

    private void listMusic() {
        List<Artist> artistList = repository.findAll();
        artistList.forEach(System.out::println);
    }

    private void searchMusicByArtist() {
    }

    private void searchArtistData() {
    }

    private void registerArtists() {
        var registerNewOne = "S";
        while (registerNewOne.equals("S")) {
            System.out.println("Enter the name of this artist: ");
            var name = scan.nextLine();
            System.out.println("Enter the type of this artist: (solo, duo or band)");
            var type = scan.nextLine();
            ArtistType artistType = ArtistType.valueOf(type.toUpperCase());
            Artist artist = new Artist(name, artistType);
            repository.save(artist);
            System.out.println("Do you want to register a new Artist?");
            registerNewOne = scan.nextLine();
        }
    }
}
