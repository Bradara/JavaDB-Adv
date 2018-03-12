package p11_radio_station.Exception;

public class InvalidSongException extends  RuntimeException{
    public InvalidSongException() {
        super("Invalid song.");
    }

    public InvalidSongException(String message) {
        super(message);
    }
}
