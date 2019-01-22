import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] rowData = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = rowData;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[n - 1 - i][i] + " ");
        }
        System.out.println();
    }
}
