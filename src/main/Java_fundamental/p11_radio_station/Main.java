package p11_radio_station;


import p11_radio_station.Exception.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Database d = new Database();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            try {
                d.addSongs(br.readLine());
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            d.printResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
