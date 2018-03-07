import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountWorkingDays {
    private static List<LocalDate> holidays = new ArrayList<LocalDate>(Arrays.asList(LocalDate.of(2004, 1, 1), LocalDate.of(2004, 3, 3), LocalDate.of(2004, 5, 1), LocalDate.of(2004, 5, 6), LocalDate.of(2004, 5, 24), LocalDate.of(2004, 9, 6), LocalDate.of(2004, 9, 22), LocalDate.of(2004, 11, 1), LocalDate.of(2004, 12, 24), LocalDate.of(2004, 12, 25), LocalDate.of(2004, 12, 26)));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(br.readLine(), datePattern);
        LocalDate endDate = LocalDate.parse(br.readLine(), datePattern);
        LocalDate curDate;
        int count = 0;
        long dateDiff = ChronoUnit.DAYS.between(startDate, endDate);

        if (dateDiff < 0){
            dateDiff = Math.abs(dateDiff);
            curDate = endDate;
        } else {
            curDate = startDate;
        }

        for (int i = 0; i <= dateDiff; i++) {
            if (i != 0)
                curDate = curDate.plusDays(1);

            DayOfWeek dayOfWeek = curDate.getDayOfWeek();

            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY ||
                    checkForHoliday(curDate))
                continue;

            count++;
        }

        System.out.println(count);


    }

    private static boolean checkForHoliday(LocalDate curDate) {
        LocalDate temp = LocalDate.of(2004, curDate.getMonth(), curDate.getDayOfMonth());

        return holidays.contains(temp);
    }
}
