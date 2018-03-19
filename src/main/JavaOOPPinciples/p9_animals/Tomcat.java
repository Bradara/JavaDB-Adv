package p9_animals;

public class Tomcat extends Cat {
    public Tomcat(String name, String age) {
        super(name, age, "male");
    }

    @Override
    public String produceSound(){
        return "Give me one million b***h";
    }
}
