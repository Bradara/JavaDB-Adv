package p4_number_in_reversed_order;

public class DecimalNumber {
    private float number;

    public DecimalNumber(float number) {
        this.number = number;
    }

    public String printReversed() {
        if (this.number % 1 > 0)
            return new StringBuilder(String.valueOf(this.number)).reverse().toString();
        else
            return new StringBuilder(String.format("%.0f", this.number)).reverse().toString();
    }
}
