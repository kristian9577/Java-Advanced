import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rowsColws = scan.nextLine().split(" ");
        int rows = Integer.parseInt(rowsColws[0]);
        int cols = Integer.parseInt(rowsColws[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] rowData = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = rowData;
        }
        int needle = Integer.parseInt(scan.nextLine());
        boolean isFound = false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == needle) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
