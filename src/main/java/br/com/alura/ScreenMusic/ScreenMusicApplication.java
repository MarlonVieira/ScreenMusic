package br.com.alura.ScreenMusic;

import br.com.alura.ScreenMusic.main.mainScreenMusic;
import br.com.alura.ScreenMusic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainScreenMusic mScreenMusic = new mainScreenMusic(repository);
		mScreenMusic.showMenu();
	}
}
