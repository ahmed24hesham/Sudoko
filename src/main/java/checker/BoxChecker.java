package checker;

import result.DuplicateResult;
import java.util.HashSet;
import java.util.List;

public class BoxChecker implements Checker {

    private final int[][] board;

    public BoxChecker(int[][] board) {
        this.board = board;
    }

    @Override
    public List<DuplicateResult> check() {

        List<DuplicateResult> results = new ArrayList<>();

        for (int box = 0; box < 9; box++) {

            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> dup = new HashSet<>();

            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;

            for (int r = startRow; r < startRow + 3; r++) {
                for (int c = startCol; c < startCol + 3; c++) {
                    int value = board[r][c];
                    if (!seen.add(value)) {
                        dup.add(value);
                    }
                }
            }

            if (!dup.isEmpty()) {
                results.add(new DuplicateResult(
                        "BOX " + (box + 1),
                        dup
                ));
            }
        }

        return results;
    }
}


@Override
    public List<DuplicateResult> check() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
