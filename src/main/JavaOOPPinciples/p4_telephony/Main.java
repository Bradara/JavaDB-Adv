package p4_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Smartphone smartphone = new Smartphone();
        String phones = br.readLine();
        String sites = br.readLine();

        smartphone.call(phones);
        smartphone.browse(sites);
    }
}
