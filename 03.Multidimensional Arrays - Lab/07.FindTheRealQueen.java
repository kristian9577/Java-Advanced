import java.util.Scanner;

public class FindTheRealQueen {
    private static int SIZE = 8;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] cheesBoard = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                cheesBoard[i][j] = line[j].charAt(0);
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cheesBoard[i][j] == 'q') {
                    if (isValidQueen(cheesBoard, i, j)) {
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

    }

    private static boolean isValidQueen(char[][] board, int row, int col) {
        return isQueenColumnValid(board, col) &&
                isQueenRowValid(board, row) &&
                isQueenFirstValid(board, row, col) &&
                isQueenSecondValid(board, row, col);
    }

    private static boolean isQueenColumnValid(char[][] board, int col) {
        int queenCount = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isQueenRowValid(char[][] board, int row) {
        int queenCount = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isQueenFirstValid(char[][] board, int row, int col) {
        int queenCount = 0;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i] == 'q') {
                queenCount++;
            }
        }
        for (int i = 1; row + i < SIZE && col + i < SIZE; i++) {
            if (board[row + i][col + i] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 0;
    }

    private static boolean isQueenSecondValid(char[][] board, int row, int col) {
        int queenCount = 0;
        for (int i = 1; row - i >= 0 && col + i < SIZE; i++) {
            if (board[row - i][col + i] == 'q') {
                queenCount++;
            }
        }
        for (int i = 1; row + i < SIZE && col - i >= 0; i++) {
            if (board[row + i][col - i] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 0;
    }
}
