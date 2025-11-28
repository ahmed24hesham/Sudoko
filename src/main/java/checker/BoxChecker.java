package checker;

import result.DuplicateResult;
import java.util.HashSet;
import java.util.List;

public class BoxChecker implements Checker {

    public DuplicateResult validate(int[][] board) {
        DuplicateResult result = new DuplicateResult();
        int boxIndex = 1;

        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {

                HashSet<Integer> seen = new HashSet<>();
                HashSet<Integer> dup = new HashSet<>();

                for (int r = br * 3; r < br * 3 + 3; r++) {
                    for (int c = bc * 3; c < bc * 3 + 3; c++) {
                        int value = board[r][c];
                        if (!seen.add(value))
                            dup.add(value);
                    }
                }

                if (!dup.isEmpty()) {
                    result.add("BOX " + boxIndex + " duplicates: " + dup);
                }

                boxIndex++;
            }
        }

        return result;
    }

    @Override
    public List<DuplicateResult> check() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}