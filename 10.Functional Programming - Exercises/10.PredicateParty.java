import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {

    private static final String END_COMMAND = "Party!";
    private static final BiPredicate<String, String> removeStartsWithPredicate = (name, start) -> !name.startsWith(start);

    private static final BiPredicate<String, String> doubleStartsWithPredicate = String::startsWith;

    private static final BiPredicate<String, String> removeEndsWithPredicate = (name, end) -> !name.endsWith(end);

    private static final BiPredicate<String, String> doubleEndsWithPredicate = String::endsWith;

    private static final BiPredicate<String, Integer> removeLengthPredicate = (name, length) -> name.length() != length;

    private static final BiPredicate<String, Integer> doubleLengthPredicate = (name, length) -> name.length() == length;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = Arrays.stream(bufferedReader.readLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        String line;

        while (!END_COMMAND.equals(line = bufferedReader.readLine())) {
            String[] commands = line.split("\\s+");

            switch (commands[0]) {
                case "Remove":
                    guests = remove(new String[]{commands[1], commands[2]}, guests);
                    break;
                case "Double":
                    guests = constraint(new String[]{commands[1], commands[2]}, guests);
                    break;
                default:
                    break;
            }
        }

        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        Collections.sort(guests);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < guests.size(); i++) {
            output.append(guests.get(i)).append(", ");
        }
        output.replace(output.length() - 2, output.length(), " are going to the party!");
        System.out.println(output.toString());
    }

    private static List<String> remove(String[] commands, List<String> collection) {
        if (commands[0].equals("StartsWith")) {
            String start = commands[1];
            return collection.stream()
                    .filter(name -> removeStartsWithPredicate.test(name, start))
                    .collect(Collectors.toList());
        } else if (commands[0].equals("EndsWith")) {
            String end = commands[1];
            return collection.stream()
                    .filter(name -> removeEndsWithPredicate.test(name, end))
                    .collect(Collectors.toList());

        } else if (commands[0].equals("Length")) {
            Integer length = Integer.parseInt(commands[1]);
            return collection.stream()
                    .filter(name -> removeLengthPredicate.test(name, length))
                    .collect(Collectors.toList());
        }
        return collection;
    }

    private static List<String> constraint(String[] commands, List<String> collection) {
        if (commands[0].equals("StartsWith")) {
            String start = commands[1];
            List<String> guestsMatchingCriteria = collection.stream()
                    .filter(name -> doubleStartsWithPredicate.test(name, start))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                collection.add(collection.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }
        } else if (commands[0].equals("EndsWith")) {
            String end = commands[1];
            List<String> guestsMatchingCriteria = collection.stream()
                    .filter(name -> doubleEndsWithPredicate.test(name, end))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                collection.add(collection.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }

        } else if (commands[0].equals("Length")) {
            Integer length = Integer.parseInt(commands[1]);
            List<String> guestsMatchingCriteria = collection.stream()
                    .filter(name -> doubleLengthPredicate.test(name, length))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                collection.add(collection.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }
        }
        return collection;
    }

}