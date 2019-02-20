import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];

        int maxLength = 0;
        int maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int bestLength = 1;
            int index = -1;

            int element = sequence[i];

            for (int j = 0; j < i; j++) {
                if (sequence[j] < element && bestLength < length[j] + 1) {
                    bestLength = length[j] + 1;
                    index = j;
                }
            }
            length[i] = bestLength;
            prev[i] = index;

            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }
        int[] result = new int[maxLength];
        int index = maxLength - 1;
        while (maxIndex != -1) {
            result[index--] = sequence[maxIndex];
            maxIndex = prev[maxIndex];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
