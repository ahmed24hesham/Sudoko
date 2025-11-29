
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;
import java.util.List;

public class RowThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;
    private int index;
    public RowThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
        this.index = -1;
    }
    public RowThread(int[][] board, ResultCollector collector, int index) {
        this.board = board;
        this.collector = collector;
        this.index = index;   // check a single row
    }

    @Override
    public void run() {
        Checker rowChecker = CheckerFactory.createChecker("row", board);

        List<DuplicateResult> results;

        if (index == -1) {
            // Check all 9 rows
            results = rowChecker.check();
        } else {
            // Check only a single row
            results = rowChecker.checkSingle(index);
        }

        for (DuplicateResult result : results) {
            collector.collect(result);
        }
    }

}