package checker;

import result.DuplicateResult;
import java.util.HashSet;
import java.util.List;

public class RowChecker implements Checker {

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

    @Override
    public List<DuplicateResult> check() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
