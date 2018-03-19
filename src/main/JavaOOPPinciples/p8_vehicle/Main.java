package p8_vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = br.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String[] truckInfo = br.readLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            String[] command = br.readLine().split("\\s+");

            if ("Drive".equalsIgnoreCase(command[0])){
                if ("Car".equalsIgnoreCase(command[1]))
                    car.drive(Double.parseDouble(command[2]));

                if ("Truck".equalsIgnoreCase(command[1]))
                    truck.drive(Double.parseDouble(command[2]));
            }

            if ("Refuel".equalsIgnoreCase(command[0])){
                if ("Car".equalsIgnoreCase(command[1]))
                    car.refuel(Double.parseDouble(command[2]));

                if ("Truck".equalsIgnoreCase(command[1]))
                    truck.refuel(Double.parseDouble(command[2]));
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
