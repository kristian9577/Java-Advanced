import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] room = new char[n][];

        int[] samPos = new int[2];
        int[] nikolaPos = new int[2];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            room[i] = line.toCharArray();

            if (line.contains("N")) {
                nikolaPos[0] = i;
                nikolaPos[1] = line.indexOf("N");
            } else if (line.contains("S")) {
                samPos[0] = i;
                samPos[1] = line.indexOf("S");
            }
        }
        String command = reader.readLine();

        for (int i = 0; i < command.length(); i++) {
            moveEnemies(room);
            boolean samIsDead = isSamDead(room, samPos);
            if (samIsDead) {
                room[samPos[0]][samPos[1]] = 'X';
                System.out.println(String.format("Sam died at %d, %d", samPos[0], samPos[1]));
                break;
            } else {
                moveSam(room, samPos, command.charAt(i));
            }
            if (nikolaPos[0] == samPos[0]) {
                System.out.println("Nikoladze killed!");
                room[nikolaPos[0]][nikolaPos[1]] = 'X';
                break;
            }
        }
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveSam(char[][] room, int[] samPos, char direction) {
        if (direction == 'U') {
            room[samPos[0]--][samPos[1]] = '.';
            room[samPos[0]][samPos[1]] = 'S';
        } else if (direction == 'D') {
            room[samPos[0]++][samPos[1]] = '.';
            room[samPos[0]][samPos[1]] = 'S';
        } else if (direction == 'L') {
            room[samPos[0]][samPos[1]--] = '.';
            room[samPos[0]][samPos[1]] = 'S';
        } else if (direction == 'R') {
            room[samPos[0]][samPos[1]++] = '.';
            room[samPos[0]][samPos[1]] = 'S';
        }

    }

    private static boolean isSamDead(char[][] room, int[] samPos) {
        for (int i = 0; i < samPos[1]; i++) {
            if (room[samPos[0]][i] == 'b') {
                return true;
            }
        }
        for (int i = samPos[1] + 1; i < room[samPos[0]].length; i++) {
            if (room[samPos[0]][i] == 'd') {
                return true;
            }
        }
        return false;
    }

    private static void moveEnemies(char[][] room) {
        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                if (room[r][c] == 'b') {
                    if (c == room[r].length - 1) {
                        room[r][c] = 'd';
                    } else {
                        room[r][c] = '.';
                        room[r][c + 1] = 'b';
                        break;
                    }
                } else if (room[r][c] == 'd') {
                    if (c == 0) {
                        room[r][c] = 'b';
                    } else {
                        room[r][c] = '.';
                        room[r][c - 1] = 'd';
                        break;
                    }
                }
            }
        }
    }
}
