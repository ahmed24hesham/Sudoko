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

            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> dup = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                int value = board[row][col];
                if (!seen.add(value)) {
                    dup.add(value);
                }
            }

            if (!dup.isEmpty()) {
                DuplicateResult r = new DuplicateResult("COL " + (col + 1),dup);
                results.add(r);
            }
        }

        return results;
    }
}
