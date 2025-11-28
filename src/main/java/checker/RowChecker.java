package checker;

import result.DuplicateResult;
import java.util.HashSet;
import java.util.List;

public class RowChecker implements Checker {

    private final int[][] board;

    public RowChecker(int[][] board) {
        this.board = board;
    }

    @Override
    public List<DuplicateResult> check() {
        List<DuplicateResult> results = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> dup = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                int value = board[row][col];
                if (!seen.add(value)) {
                    dup.add(value);
                }
            }

            if (!dup.isEmpty()) {
                results.add(new DuplicateResult(
                        "ROW " + (row + 1),
                        dup
                ));
            }
        }

        return results;
    }
}
