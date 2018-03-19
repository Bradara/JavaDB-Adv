package p9_animals;

public class Frog extends Animal {
    public Frog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return ("Frogggg");
    }
}