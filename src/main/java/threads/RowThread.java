
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;

public class RowThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;

    public RowThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        Checker rowChecker = CheckerFactory.createChecker("row", board);
        for (DuplicateResult result : rowChecker.check()) {
            collector.collect(result);
        }
    }
}