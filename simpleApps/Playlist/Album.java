package com.Kamil;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by szerlag on 2017-10-22.
 */
public class Album {
    private String albumName;
    private String artistName;
    private ArrayList<Song> albumList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.albumList = new ArrayList<Song>();
    }

    public boolean addSong(String title, String artist) {
        if (findSong(title) == null) {
            this.albumList.add(new Song(artist, title));
            return true;
        } else {
            System.out.println("Piosenka nie moze zostac dodana");
            return false;

        }

    }

    private Song findSong(String title) {
        for (Song checkedSong : this.albumList) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;

    }

    public boolean addtoPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.albumList.size())) {
            playlist.add(albumList.get(index));// i dont understand
            return true;
        }
        System.out.println("Ten album nie posiada sciezki ");
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song" + title + "is not in this album");
        return false;
    }

}
