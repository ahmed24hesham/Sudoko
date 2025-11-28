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
}
