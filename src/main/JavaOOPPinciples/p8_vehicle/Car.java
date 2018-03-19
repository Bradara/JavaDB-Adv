package p8_vehicle;

public class Car extends Vehicle {
    public Car(double fuel, double literPerKm) {
        super(fuel, (literPerKm + 0.9));
    }
}
