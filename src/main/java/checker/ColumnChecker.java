package checker;

import result.DuplicateResult;
import java.util.*;

public class ColumnChecker implements Checker {

    private final int[][] board;

    public ColumnChecker(int[][] board) {
        this.board = board;
    }

    @Override
    public List<DuplicateResult> check() {

        List<DuplicateResult> results = new ArrayList<>();

        for (int col = 0; col < 9; col++) {

            int[] freq = new int[10];
            int[] fullCol = new int[9];

            for (int row = 0; row < 9; row++) {
                int value = board[row][col];
                fullCol[row] = value;
                freq[value]++;
            }

            for (int num = 1; num <= 9; num++) {
                if (freq[num] > 1) {
                    results.add(new DuplicateResult("COL", col + 1, num, fullCol));
                }
            }
        }

        return results;
    }
    public List<DuplicateResult> checkSingle(int col) {
        List<DuplicateResult> results = new ArrayList<>();
        checkOneColumn(col, results);
        return results;
    }

    private void checkOneColumn(int col, List<DuplicateResult> results) {
        boolean[] seen = new boolean[10];
        int[] fullCol = new int[10];

        for (int row = 0; row < 9; row++) {
            int val = board[row][col];
            fullCol[row] = val;

            if (seen[val]) {
                results.add(new DuplicateResult("COL", col + 1, val, fullCol));
            }

            seen[val] = true;
        }
    }

}
