package ch04.soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (int i = 0; i < tracks.size(); i++) {
            playTrack(i);
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("-Track: " + tracks.get(trackNumber));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
