import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rowsColws = scan.nextLine().split(", ");
        int rows = Integer.parseInt(rowsColws[0]);
        int cols = Integer.parseInt(rowsColws[1]);

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            sum += Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
