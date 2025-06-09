package br.com.alura.ScreenMusic.main;

import java.util.Scanner;

public class mainScreenMusic {
    private Scanner scan = new Scanner(System.in);

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
    }

    private void listMusic() {
    }

    private void searchMusicByArtist() {
    }

    private void searchArtistData() {
    }
    private void registerArtists() {
    }
}
