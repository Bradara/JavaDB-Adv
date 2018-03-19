package p9_animals;

import p8_vehicle.Car;

public class Kitten extends Cat {
    public Kitten(String name, String age) {
        super(name, age, "female");
    }

    @Override
    public String produceSound(){
        return "Miau";
    }
}
