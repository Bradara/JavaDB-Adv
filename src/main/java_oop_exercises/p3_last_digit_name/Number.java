package p3_last_digit_name;

public class Number {
    private final static String[] NUMBER_AS_STRING = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine"};
    private int number;

    public Number(int number) {
        this.number = number;
    }

    String lastDigit(){
        return NUMBER_AS_STRING[this.number%10];
    }
}
