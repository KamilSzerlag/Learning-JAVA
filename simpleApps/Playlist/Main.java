package com.Kamil;

import java.util.*;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("KODZING", "VNM");
        album.addSong("Ona tanczy jak szalona", "VNM");
        album.addSong("Blalala", "VNM");
        album.addSong("Onanda", "VNM");
        album.addSong("psdkpadka", "VNM");
        album.addSong("sldmald", "VNM");
        album.addSong("Indaida", "VNM");
        albums.add(album);
        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Ona tanczy jak szalona", playlist);
        albums.get(0).addToPlaylist("Blalala", playlist);
        albums.get(0).addToPlaylist("sldmald", playlist);
        albums.get(0).addToPlaylist("Ona tanczy jak szalona", playlist);
        albums.get(0).addtoPlayList(2, playlist);
        printMenu();
        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing" + listIterator.next().toString());
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();

                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the endo fo the plailist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying" + listIterator.previous().toString());
                            forward = false;
                        }
                        else {
                            System.out.println("We are at the start of the list");

                        }

                    }
                    else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying" + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }

                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Availabe actons:\npress");
        System.out.println("0- to quit\n" + "1- to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to play replay song\n"+
                "4 - to play list songs in playlist\n"+
                "5 - to available actoions\n");

    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(("======================="));

    }
}
