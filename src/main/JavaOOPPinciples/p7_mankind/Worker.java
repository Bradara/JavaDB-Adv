package p7_mankind;

public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, String ws, String wh) {
        super(firstName, lastName);
        this.setWeekSalary(ws);
        this.setWorkHoursPerDay(wh);
    }

    public void setWeekSalary(String input) {
        double n = Double.parseDouble(input);
        if (n<10)
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");

        this.weekSalary = n;
    }

    public void setWorkHoursPerDay(String input) {
        double n = Double.parseDouble(input);

        if (n<1 || n> 12)
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");

        this.workHoursPerDay = n;
    }

    @Override
    public double getWeekSalary() {
        return this.weekSalary;
    }

    @Override
    public double getHoursPerDay() {
        return this.workHoursPerDay;
    }

    @Override
    public double getmoneyPerHour() {
        return this.weekSalary/(this.workHoursPerDay *7);
    }

    @Override
    public String getFacultyNumber() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Week Salary: %.2f\n" +
                "Hours per day: %.2f\n" +
                "Salary per hour: %.2f", this.weekSalary, this.workHoursPerDay, this.getmoneyPerHour());
    }
}
