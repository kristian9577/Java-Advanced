import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> users = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] arguments = input.split(": ");
            String name = arguments[0].replace(":", "");
            String[] cards = arguments[1].split(", ");

            for (int i = 0; i < cards.length; i++) {
                users.putIfAbsent(name, new LinkedHashMap<>());
                users.get(name).putIfAbsent(cards[i], 0);
                int value = 0;

                switch (cards[i].substring(0, cards[i].length() - 1)) {
                    case "J":
                        value = 11;
                        break;
                    case "Q":
                        value = 12;
                        break;
                    case "K":
                        value = 13;
                        break;
                    case "A":
                        value = 14;
                        break;
                    default:
                        value = (Integer.parseInt(cards[i].substring(0, cards[i].length() - 1)));
                }

                switch (cards[i].substring(cards[i].length() - 1, cards[i].length())) {
                    case "C":
                        value *= 1;
                        break;
                    case "H":
                        value *= 3;
                        break;
                    case "S":
                        value *= 4;
                        break;
                    case "D":
                        value *= 2;
                        break;
                }
                users.get(name).put(cards[i], value);
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            System.out.printf(user.getKey() + ": ");
            int sum = 0;
            for (int x : user.getValue().values()) {
                sum += x;
            }
            System.out.println(sum);
        }

    }
}