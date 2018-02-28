import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14_mail_censor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mailFrom = br.readLine();
        String mailTo = addAsterix(mailFrom);

        String text = br.readLine();

        text = text.replace(mailFrom, mailTo);

        System.out.println(text);
    }

    private static String addAsterix(String mailFrom) {
        StringBuilder sb = new StringBuilder();
        int indexOfAt = mailFrom.indexOf("@");

        for (int i = 0; i < indexOfAt; i++) {
            sb.append("*");
        }

        return sb.toString() + mailFrom.substring(indexOfAt);

    }
}
