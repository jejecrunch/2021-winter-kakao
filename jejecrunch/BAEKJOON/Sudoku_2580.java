import java.util.*;
import java.io.*;

public class Sudoku_2580 {
    public static int[][] map = new int[9][9];
    public static int count = 0;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    private static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        int ROW = (row / 3) * 3;
        int COL = (col / 3) * 3;

        for (int i = ROW; i < ROW + 3; i++) {
            for (int j = COL; j < COL + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
