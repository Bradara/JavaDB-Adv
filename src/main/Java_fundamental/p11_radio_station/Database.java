package p11_radio_station;

import p11_radio_station.Exception.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Songs> songs = new ArrayList<>();

    public Database() {
        this.songs = new ArrayList<>();
    }

    public void addSongs(String input) throws InvalidSongException {
               Songs s = new Songs(input);
               songs.add(s);
               System.out.println("Song added.");
    }

    public void printResult() {
        System.out.printf("Songs added: %d%n", songs.size());
        if (songs.size() != 0) {
            long playlistLength = songs.stream().map(Songs::getTimeLength).reduce((a, b) -> a + b).get();
            System.out.printf("Playlist length: %dh %dm %ds%n", playlistLength / 3600, playlistLength / 60 % 60,
                    playlistLength % 60);
        } else{
            System.out.println("Playlist length: 0h 0m 0s");
        }
    }
}
