package p11_radio_station.Exception;

public class InvalidSongLengthException extends InvalidSongException{

    public InvalidSongLengthException() {
        super("Invalid song length.");
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
