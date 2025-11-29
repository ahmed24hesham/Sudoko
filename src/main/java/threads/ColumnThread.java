
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;

public class ColumnThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;

    public ColumnThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        Checker colChecker = CheckerFactory.createChecker("col", board);
        for (DuplicateResult result : colChecker.check()) {
            collector.collect(result);
        }
    }
}
