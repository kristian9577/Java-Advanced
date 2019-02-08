package carInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split(" ");
            String make = data[0];
            Car car;
            if (data.length == 1) {
                car = new Car(make);
            } else {
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                car = new Car(make, model, horsePower);
            }
            System.out.println(car.getInfo());
        }
    }
}
