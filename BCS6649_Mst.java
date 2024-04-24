import java.util.HashSet;

public class BCS6649_Mst {
    public static int isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] subs = new HashSet[3][3];

        for (int i = 0; i < 9; ++i) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                subs[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cell = board[i][j];
                if (cell == '.') continue;
                if (rows[i].contains(cell)) return 1;
                if (cols[j].contains(cell)) return 2;
                if (subs[i / 3][j / 3].contains(cell)) return 3;
                rows[i].add(cell);
                cols[j].add(cell);
                subs[i / 3][j / 3].add(cell);
            }
        }

        return 0; // Valid Sudoku
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '9', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };

        int validity = isValidSudoku(board);
        if (validity == 0)
            System.out.println("The given Sudoku puzzle is a correct solution.");
        else {
            if (validity == 1)
                System.out.println("The given Sudoku puzzle is NOT a correct solution. Duplicate in the same row.");
            else if (validity == 2)
                System.out.println("The given Sudoku puzzle is NOT a correct solution. Duplicate in the same column.");
            else if (validity == 3)
                System.out.println("The given Sudoku puzzle is NOT a correct solution. Duplicate in the same subgrid.");
        }
    }
}
