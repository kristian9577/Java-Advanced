import java.util.Arrays;
import java.util.Scanner;

public class FilltheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String type = tokens[1];

        int[][] matrix = new int[n][n];

        if (type.equals("A")) {
            fillMatrixWithFirstType(matrix);
        } else {
            fillMatrixWithSecondType(matrix);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void fillMatrixWithSecondType(int[][] matrix) {
        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = value++;
                }
            } else {
                for (int row = matrix.length-1; row >= 0; row--) {
                    matrix[row][col] = value++;
                }
            }
        }
    }

    private static void fillMatrixWithFirstType(int[][] matrix) {
        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = value++;
            }
        }
    }
}
