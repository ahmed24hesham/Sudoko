package checker;

import result.DuplicateResult;
import java.util.*;

public class RowChecker implements Checker {

    private final int[][] board;

    public RowChecker(int[][] board) {
        this.board = board;
    }

    @Override
    public List<DuplicateResult> check() {

        List<DuplicateResult> results = new ArrayList<>();

        for (int row = 0; row < 9; row++) {

            int[] freq = new int[10];
            int[] fullRow = new int[9];

            for (int col = 0; col < 9; col++) {
                int value = board[row][col];
                fullRow[col] = value;
                freq[value]++;
            }

            for (int num = 1; num <= 9; num++) {
                if (freq[num] > 1) {
                    results.add(new DuplicateResult("ROW", row + 1, num, fullRow));
                }
            }
        }

        return results;
    }
    public List<DuplicateResult> checkSingle(int row) {
        List<DuplicateResult> results = new ArrayList<>();
        checkOne(row, results);
        return results;
    }

    private void checkOne(int row, List<DuplicateResult> results) {
        boolean[] seen = new boolean[10];
        int[] fullRow = new int[10];
        for (int col = 0; col < 9; col++) {
            int val = board[row][col];
            fullRow[col] = val;
            if (seen[val]) {
                results.add(new DuplicateResult("ROW", row+1, val,fullRow));
            }
            seen[val] = true;
        }
    }
}
