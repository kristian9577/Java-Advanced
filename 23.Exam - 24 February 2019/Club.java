import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Club {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());
        String[] hallsAndPeople = reader.readLine().split(" ");
        ArrayDeque<String> halls = new ArrayDeque<>();
        List<Integer> currentHallReservation = new ArrayList<>();


        for (int i = hallsAndPeople.length - 1; i >= 0; i--) {
            String current = hallsAndPeople[i];
            if (Character.isDigit(current.charAt(0))) {
                if (halls.isEmpty()) {
                    continue;
                }
                int currentReservation = Integer.parseInt(current);

                if (currentReservation > capacity) {
                    continue;
                }

                int sum = currentHallReservation.stream().mapToInt(x -> x).sum();
                if (sum + currentReservation <= capacity) {
                    currentHallReservation.add(currentReservation);
                } else {
                    printHall(halls.poll(), currentHallReservation);
                    currentHallReservation.clear();
                    i++;
                }
            } else {
                halls.offer(current);
            }
        }

    }

    private static void printHall(String poll, List<Integer> currentHallReservation) {
        System.out.print(poll);
        System.out.print(" -> ");
        System.out.println(String.join(", ",
                currentHallReservation
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())));
    }
}
