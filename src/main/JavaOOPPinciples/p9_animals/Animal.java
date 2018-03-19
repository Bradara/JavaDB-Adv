package p9_animals;

public class Animal{
    private final String MALE_GENDER = "Male";
    private final String FEMALE_GENDER = "Female";

    private String name;
    private int age;
    private String gender;

    public Animal() {
    }

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Invalid input!");

        this.name = name;
    }

    private void setAge(String age) {
        if (!isInt(age)||Integer.parseInt(age)< 0 )
            throw new IllegalArgumentException("Invalid input!");

        this.age = Integer.parseInt(age);
    }

    private void setGender(String gender) {
        if (!gender.equalsIgnoreCase(MALE_GENDER) && !gender.equalsIgnoreCase(FEMALE_GENDER))
            throw new IllegalArgumentException("Invalid input!");

        this.gender = gender;
    }

    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s%n%s", this.getClass().getSimpleName(),
                this.name, this.age, this.gender, this.produceSound());
    }

    private boolean isInt(String age){
        return age.matches("^\\d+$");

    }
}
