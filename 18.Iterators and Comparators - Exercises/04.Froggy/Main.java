package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] stones = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : lake) {
            stringBuilder.append(integer).append(", ");
        }
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.lastIndexOf(", ")));
    }
}
