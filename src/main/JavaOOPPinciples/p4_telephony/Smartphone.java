package p4_telephony;

public class Smartphone implements Callable, Browsable{

    public Smartphone() {
    }

    @Override
    public void browse(String input) {
    //    if (input.length() > 0) {
            String[] sites = input.split("\\s+");

            for (String site : sites) {
                if (site.matches(".*\\d+.*"))
                    System.out.println("Invalid URL!");
                else
                    System.out.println("Browsing: " + site + "!");
            }
      //  }
    }

    @Override
    public void call(String input) {
     //   if (input.length() > 0) {
            String[] phoneNumbers = input.split("\\s+");

            for (String phoneNumber : phoneNumbers) {
                if (phoneNumber.matches("^\\d+$"))
                System.out.println("Calling... " + phoneNumber);
                else
                    System.out.println("Invalid number!");
            }
      //  }
    }
}
