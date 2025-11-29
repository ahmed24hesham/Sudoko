
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;

public class BoxThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;

    public BoxThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
    }

    @Override
    public void run() {
        Checker boxChecker = CheckerFactory.createChecker("box", board);
        for (DuplicateResult result : boxChecker.check()) {
            collector.collect(result);
        }
    }
}
