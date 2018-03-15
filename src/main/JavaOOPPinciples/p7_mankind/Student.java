package p7_mankind;

public class Student extends Human{

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public void setFacultyNumber(String input) {
        if (input.length() > 10 || input.length() < 5)
            throw new IllegalArgumentException("Invalid faculty number!");

        this.facultyNumber = input;
    }

    @Override
    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    @Override
    public double getWeekSalary() {
        return 0;
    }

    @Override
    public double getHoursPerDay() {
        return 0;
    }

    @Override
    public double getmoneyPerHour() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Faculty number: %s", this.facultyNumber);
    }
}
