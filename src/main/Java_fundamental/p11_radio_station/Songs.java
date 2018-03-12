package p11_radio_station;

import p11_radio_station.Exception.*;

public class Songs {
    private String artist;
    private String songName;
    private int minutes;
    private int seconds;

    public Songs(String input) throws InvalidSongException {
        this.setParams(input);
    }

    private void setParams(String input) throws InvalidSongException {
        String[] params = input.split(";");

        if (params.length != 3)
            throw new InvalidSongException();

        this.setArtist(params[0]);
        this.setSongName(params[1]);
        setLength(params[2]);
    }

    private void setLength(String input) throws InvalidSongLengthException {
        int min, sec;
        try {
            String[] params = input.split(":");
            min = Integer.parseInt(params[0]);
            sec = Integer.parseInt(params[1]);
        } catch (Exception e) {
            throw new InvalidSongLengthException();
        }

        this.setMinutes(min);
        this.setSeconds(sec);
    }


    private void setArtist(String artist) throws InvalidArtistNameException {

        if (artist.length() < 3 || artist.length() > 20)
            throw new InvalidArtistNameException();

        this.artist = artist;

    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 20)
            throw new InvalidSongNameException();

        this.songName = songName;
    }

    private void setMinutes(int minutes) throws InvalidSongMinutesException {
        if (minutes < 0 || minutes > 14)
            throw new InvalidSongMinutesException();

        this.minutes = minutes;
    }

    private void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59)
            throw new InvalidSongSecondsException();

        this.seconds = seconds;
    }

    public long getTimeLength() {
        return this.minutes * 60 + this.seconds;
    }
}
