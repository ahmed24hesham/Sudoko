package checker;

import result.DuplicateResult;
import java.util.*;

public class BoxChecker implements Checker {

    private final int[][] board;

    public BoxChecker(int[][] board) {
        this.board = board;
    }

    @Override
    public List<DuplicateResult> check() {

        List<DuplicateResult> results = new ArrayList<>();

        for (int box = 0; box < 9; box++) {

            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;

            int[] freq = new int[10];
            int[] fullBox = new int[9];
            int idx = 0;

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    int value = board[startRow + r][startCol + c];
                    fullBox[idx++] = value;
                    freq[value]++;
                }
            }

            for (int num = 1; num <= 9; num++) {
                if (freq[num] > 1) {
                    results.add(new DuplicateResult("BOX", box + 1, num, fullBox));
                }
            }
        }

        return results;
    }
    public List<DuplicateResult> checkSingle(int box) {
        List<DuplicateResult> results = new ArrayList<>();
        checkOneBox(box, results);
        return results;
    }
    private void checkOneBox(int box, List<DuplicateResult> results) {
        boolean[] seen = new boolean[10];
        int[] fullBox = new int[10];

        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;

        int index = 0;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int val = board[startRow + r][startCol + c];
                fullBox[index] = val;
                index++;

                if (seen[val]) {
                    results.add(new DuplicateResult("BOX", box + 1, val, fullBox));
                }

                seen[val] = true;
            }
        }
    }

}
