package checker;

import result.DuplicateResult;
import java.util.HashSet;

public class RowChecker implements Checker {

    @Override
    public DuplicateResult validate(int[][] board) {
        DuplicateResult result = new DuplicateResult();

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
                result.add("ROW " + (row + 1) + " duplicates: " + dup);
            }
        }

        return result;
    }
}
