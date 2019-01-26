import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        HashSet<String> parkingLot = new HashSet<>();

        while (!"END".equals(line = reader.readLine())) {
            String[] parts = line.split(", ");
            if (parts[0].equals("IN")) {
                parkingLot.add(parts[1]);
            } else {
                parkingLot.remove(parts[1]);
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String car : parkingLot) {
            System.out.println(car);
        }
    }
}
