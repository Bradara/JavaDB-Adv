package p3_ferrari;

public class Ferrari implements DriveCar {

    private String driverName;

    Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBrakes() {
        return ("Brakes!");
    }

    @Override
    public String pushGas() {
        return ("Zadu6avam sA!");
    }

    public String getDriverName() {
        return driverName;
    }
}
