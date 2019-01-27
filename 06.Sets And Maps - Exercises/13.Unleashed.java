import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            Pattern srabskoPattern = Pattern.compile("([\\w\\s]+)\\s@([a-zA-z\\s]+)\\s(\\d+)\\s(\\d+)");
            Matcher srabskoMatcher = srabskoPattern.matcher(input);

            if (srabskoMatcher.find()) {
                String venue = srabskoMatcher.group(2);
                String singer = srabskoMatcher.group(1);
                int ticketPrice = Integer.parseInt(srabskoMatcher.group(3));
                int ticketCount = Integer.parseInt(srabskoMatcher.group(4));


                concerts.putIfAbsent(venue, new LinkedHashMap<>());
                concerts.get(venue).putIfAbsent(singer, 0);

                int earned = ticketCount * ticketPrice;
                int totalEarned = concerts.get(venue).get(singer) + earned;

                concerts.get(venue).put(singer, totalEarned);
            }

            input = reader.readLine();
        }

        concerts.forEach((ket, value) -> {
            System.out.println(ket);
            value.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("#  %s -> %s", e.getKey(), e.getValue()));
                    });
        });
    }
}