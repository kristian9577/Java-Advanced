import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheMatrix {

    public static char[][] matrix;
    public static char color;
    public static char tobeReplaced;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
        color = reader.readLine().charAt(0);
        int[] indexes = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = indexes[0];
        int startCol = indexes[1];

        tobeReplaced = matrix[startRow][startCol];

        paintMatrix(startRow, startCol);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void paintMatrix(int r, int c) {
        if (!isInBounds(r, c) || matrix[r][c] == color || matrix[r][c] != tobeReplaced) {
            return;
        }
        matrix[r][c] = color;
        paintMatrix(r + 1, c);
        paintMatrix(r, c + 1);
        paintMatrix(r - 1, c);
        paintMatrix(r, c - 1);
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
