package p2_advertisement_message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class main {
    static class Message {
        private String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        private String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        private String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        private String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public String getMessage(){
            return getPhrases() + " " + getEvents() + " " + getAuthor() + " - " + getCities() + ".";
        }

        private String getCities() {

            Random rnd = new Random();
            int len = cities.length;
            int randomIndex = rnd.nextInt(len);
            return cities[randomIndex];
        }

        private String getAuthor() {

            Random rnd = new Random();
            int len = author.length;
            int randomIndex = rnd.nextInt(len);
            return author[randomIndex];
        }

        private String getEvents() {

            Random rnd = new Random();
            int len = events.length;
            int randomIndex = rnd.nextInt(len);
            return events[randomIndex];
        }

        private String getPhrases() {
            Random rnd = new Random();
            int len = phrases.length;
            int randomIndex = rnd.nextInt(len);
            return phrases[randomIndex];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Message m = new Message();

        while (n-- > 0)
            System.out.println(m.getMessage());

    }
}
