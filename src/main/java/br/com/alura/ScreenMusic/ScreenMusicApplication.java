package br.com.alura.ScreenMusic;

import br.com.alura.ScreenMusic.main.mainScreenMusic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainScreenMusic mScreenMusic = new mainScreenMusic();
		mScreenMusic.showMenu();
	}
}
