package p5_border_control;

public class Person implements Citizen, Birthable{
    private String name;
    private String age;
    private String id;
    private String birthday;

    Person(String name, String age, String id, String birthday){
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
