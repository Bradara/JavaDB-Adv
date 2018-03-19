package p8_vehicle;

public abstract class Vehicle {

    private double fuel;
    private double literPerKm;

    public Vehicle(double fuel, double literPerKm) {
        this.fuel = fuel;
        this.literPerKm = literPerKm;
    }

    public void refuel(double liters){
        this.fuel += liters;
    }

    public void drive(double distance){
        if (distance * this.literPerKm > this.fuel) {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }else{
            this.fuel -= distance * this.literPerKm;
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(),
                    String.format((distance%1 == 0? "%.0f": "%s"), distance));
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
