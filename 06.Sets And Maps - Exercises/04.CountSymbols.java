import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Character, Integer> chars = new TreeMap<>();

        char[] input = reader.readLine().toCharArray();
        for (char ch : input) {
            chars.putIfAbsent(ch, 0);
            int updateCount = chars.get(ch) + 1;
            chars.put(ch, updateCount);
        }
        chars.forEach((ch, count) -> System.out.println(String.format("%c: %d time/s", ch, count)));

    }
}
