import java.util.Arrays;
import java.util.Scanner;

public class IntersectionTwoMatrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] first = new char[rows][cols];
        char[][] second = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                first[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                second[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first[i][j] == second[i][j]) {
                    System.out.print(first[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
