import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcelFunctions {  // solution with Arrays

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowCount = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            matrix[i] = reader.readLine().split(", ");
        }

        String[] commandArgs = reader.readLine().split(" ");

        switch (commandArgs[0]) {
            case "hide":
                hideColumnAndPrint(matrix, commandArgs[1]);
                break;
            case "sort":
                sortByColumnAndPrint(matrix, commandArgs[1]);
                break;
            case "filter":
                filterByColumnAndPrint(matrix, commandArgs[1], commandArgs[2]);
                break;

        }
    }

    private static void filterByColumnAndPrint(String[][] matrix, String filterColumn, String filterValue) {
        int filterColumnIndex = getColumnIndexByName(matrix[0], filterColumn);

        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][filterColumnIndex].equals(filterValue)) {
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void sortByColumnAndPrint(String[][] matrix, String sortColumnName) {
        int sortColumnIndex = getColumnIndexByName(matrix[0], sortColumnName);

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 1; i < matrix.length - 1 - j; i++) {
                if (matrix[i][sortColumnIndex].compareTo(matrix[i + 1][sortColumnIndex]) > 0) {
                    String[] temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    private static void hideColumnAndPrint(String[][] matrix, String hiddenColumn) {
        int hiddenColumnIndex = getColumnIndexByName(matrix[0], hiddenColumn);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == hiddenColumnIndex) {
                    continue;
                }
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    if (!(j == matrix[i].length - 2 && hiddenColumnIndex == j + 1))
                        System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    private static int getColumnIndexByName(String[] matrix, String hiddenColumn) {
        int hiddenColumnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(hiddenColumn)) {
                hiddenColumnIndex = i;
                break;
            }
        }
        return hiddenColumnIndex;
    }
}
