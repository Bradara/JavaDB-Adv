import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15_url_parser {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String protokol;
        String subInput;
        String server;
        String resource;

        int indexOfDoubleSlash = input.indexOf("//");

        if (indexOfDoubleSlash ==-1){
            protokol = "";
            subInput = input;
        }
        else {
            subInput = input.substring(indexOfDoubleSlash+2);
            protokol = input.substring(0, indexOfDoubleSlash-1);
        }

        int indexOfSlash = subInput.indexOf("/");

        if (indexOfSlash ==-1){
            server = subInput;
            resource = "";
        } else {
            server = subInput.substring(0, indexOfSlash);
            resource = subInput.substring(indexOfSlash+1);
        }


        System.out.printf("[protocol] = \"%s\"%n", protokol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"", resource);
    }
}
