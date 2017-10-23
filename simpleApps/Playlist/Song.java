package com.Kamil;

/**
 * Created by szerlag on 2017-10-22.
 */
public class Song {
    private String artist;
    private String title;

    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return
                "Artist: "  + artist + '\'' +
                "Title: " + title ;
    }
}
