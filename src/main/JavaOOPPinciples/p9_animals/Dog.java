package p9_animals;

public class Dog extends Animal{
    public Dog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
       return "BauBau";
    }
}
