package edu.frcc.csc1061j.PlaylistManager;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class PlaylistManager {
    private MyDoubleLinkedList<Song> playlist;
    private Random random;

    public PlaylistManager() {
        playlist = new MyDoubleLinkedList<>();
        random = new Random();
    }

    public void addSong(Song song) {
        playlist.add(song);
        System.out.println("Added: " + song);
    }

    public boolean removeSong(Song song) {
        boolean removed = playlist.remove(song);
        if (removed) {
            System.out.println("Removed: " + song);
        }
        return removed;
    }

    public int countSongs() {
        return playlist.size();
    }

    public void play() {
        System.out.println("Playing playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void shuffle() {
        int n = playlist.size();
        if (n <= 1) {
            System.out.println("Playlist only has 1 song.");
            return;
        }
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                Song temp = playlist.get(i);
                playlist.set(i, playlist.get(j));
                playlist.set(j, temp);
            }
        }
        System.out.println("Playlist shuffled.");
    }

    public void reverse() {
        playlist.reverse();
        System.out.println("Playlist reversed.");
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Song song : playlist) {
                writer.println(song.getTitle() + "|" + song.getArtist());
            }
            System.out.println("Playlist saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving" + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            playlist.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("---", 2);
                if (parts.length == 2) {
                    Song song = new Song(parts[0], parts[1]);
                    playlist.add(song);
                }
            }
            System.out.println("Playlist loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading playlist: " + e.getMessage());
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to the Playlist Manager!");
        System.out.println("Commands:");
        System.out.println("1 - Add a song");
        System.out.println("2 - Remove a song");
        System.out.println("3 - Count songs");
        System.out.println("4 - Play playlist");
        System.out.println("5 - Shuffle playlist");
        System.out.println("6 - Reverse playlist");
        System.out.println("7 - Save playlist to file");
        System.out.println("8 - Load playlist from file");
        System.out.println("9 - Quit");

        while (!quit) {
            System.out.print("Enter command number: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine().trim();
                    addSong(new Song(title, artist));
                    break;
                case "2":
                    System.out.print("Enter song to remove: ");
                    String remTitle = scanner.nextLine().trim();
                    System.out.print("Enter artist name: ");
                    String remArtist = scanner.nextLine().trim();
                    removeSong(new Song(remTitle, remArtist));
                    break;
                case "3":
                    System.out.println("Number of songs: " + countSongs());
                    break;
                case "4":
                    play();
                    break;
                case "5":
                    shuffle();
                    break;
                case "6":
                    reverse();
                    break;
                case "7":
                    System.out.print("Enter file to save to: ");
                    String saveFile = scanner.nextLine().trim();
                    saveToFile(saveFile);
                    break;
                case "8":
                    System.out.print("Enter file to load from: ");
                    String loadFile = scanner.nextLine().trim();
                    loadFromFile(loadFile);
                    break;
                case "9":
                    quit = true;
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("Invalid number only 1-9 work");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();
        manager.menu();
    }
}
