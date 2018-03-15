package p7_mankind;

public abstract class Human implements Workable, Teachable{

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        if (firstName.charAt(0)>90 || firstName.charAt(0)<65)
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");

        if (firstName.length()<4)
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");


        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.charAt(0)>90 || lastName.charAt(0)<65)
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");

        if (lastName.length()<3)
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");


        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return  this.lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                "Last Name: %s\n", this.firstName, this.lastName);
    }
}
