package p9_animals;

public class Cat extends Animal {
    public Cat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "MiauMiau";
    }
}
