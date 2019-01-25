import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rotateData = scan.nextLine().split("[()+]");

        int rotateAngle = Integer.parseInt(rotateData[1]) % 360;

        ArrayList<String> inputStrings = new ArrayList<>();

        String line = scan.nextLine();

        int maxLength = line.length();

        while (!line.equals("END")) {
            inputStrings.add(line);
            line = scan.nextLine();
            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }
        char[][] matrix = new char[inputStrings.size()][maxLength];

        for (int r = 0; r < inputStrings.size(); r++) {
            for (int c = 0; c < maxLength; c++) {
                if (c > inputStrings.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputStrings.get(r).charAt(c);
                }
            }
        }

        if (rotateAngle == 90) {
            for (int c = 0; c < maxLength; c++) {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        } else if (rotateAngle == 180) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                for (int c = maxLength - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 270) {
            for (int c = maxLength - 1; c >= 0; c--) {
                for (int r = 0; r < matrix.length; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < maxLength; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }

        }

    }
}
