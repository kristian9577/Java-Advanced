import java.util.Scanner;

public class Matrixshuffling {
    private static int rows = 0;
    private static int cols = 0;
    private static String[][] matrix = new String[rows][cols];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");//get dimensions
        rows = Integer.parseInt(input[0]);
        cols = Integer.parseInt(input[1]);

        matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(" "); //fill matrix with data
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }
        String command;
        while (!"END".equals(command = scan.nextLine())) {
            String[] elements = command.split(" ");
            if (!command.startsWith("swap") || elements.length != 5) { //check for right command "swap"
                System.out.println("Invalid input!");
                continue;
            }
            int rowOne = Integer.parseInt(elements[1]);
            int colOne = Integer.parseInt(elements[2]);
            int rowTwo = Integer.parseInt(elements[3]);
            int colTwo = Integer.parseInt(elements[4]);

            if (isOutOfRange(rowOne, colOne, rowTwo, colTwo)) { //check for range of coordinate
                System.out.println("Invalid input!");
                continue;
            }
            String temp = matrix[rowOne][colOne];// swap element in matrix
            matrix[rowOne][colOne] = matrix[rowTwo][colTwo];
            matrix[rowTwo][colTwo] = temp;

            System.out.print(getMatrixString());
        }
    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                rowOutput.append(matrix[row][col]).append(" ");
            }
            output.append(rowOutput.toString()
                    .trim())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }

    private static boolean isOutOfRange(int rowOne, int colOne, int rowTwo, int colTwo) {
        if (rowOne < 0 || rowOne >= rows) {
            return true;
        } else if (rowTwo < 0 || rowTwo >= rows) {
            return true;
        } else if (colOne < 0 || colOne >= cols) {
            return true;
        } else if (colTwo < 0 || colTwo >= cols) {
            return true;
        }
        return false;
    }
}
