package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }
        String line = reader.readLine();

        while (!line.equals("End")) {
            String[] tokens = line.split(" ");
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);
            Car car = cars.get(model);
            car.drive(distance);

            line = reader.readLine();
        }
        cars.values().forEach(System.out::println);
    }
}
