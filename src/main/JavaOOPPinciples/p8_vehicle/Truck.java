package p8_vehicle;

public class Truck extends Vehicle {
    public Truck(double fuel, double literPerKm) {
        super(fuel, literPerKm + 1.6);
    }

    @Override
    public void refuel(double liters){
        super.refuel(liters * 0.95);
    }
}
