package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        String input = reader.readLine();

        while (!input.equals("END")) {
            if (input.contains("Push")) {
                Arrays.stream(input.split("([, ]+)")).skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(stack::push);
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            input = reader.readLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
