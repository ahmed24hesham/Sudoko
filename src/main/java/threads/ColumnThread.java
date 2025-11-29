
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;

import java.util.List;

public class ColumnThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;
    private int index;
    public ColumnThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
        this.index = -1;
    }

    public ColumnThread(int[][] board, ResultCollector collector, int index) {
        this.board = board;
        this.collector = collector;
        this.index = index;
    }


    @Override
    public void run() {
        Checker colChecker = CheckerFactory.createChecker("col", board);

        List<DuplicateResult> results;

        if (index == -1) {
            // Check all 9 columns
            results = colChecker.check();
        } else {
            // Check only a single column
            results = colChecker.checkSingle(index);
        }

        for (DuplicateResult result : results) {
            collector.collect(result);
        }
    }

}
