
package threads;

import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;
import utils.ResultCollector;

import java.util.List;

public class BoxThread extends Thread {
    private final int[][] board;
    private final ResultCollector collector;
    private final int index;

    public BoxThread(int[][] board, ResultCollector collector) {
        this.board = board;
        this.collector = collector;
        this.index = -1;
    }
    public BoxThread(int[][] board, ResultCollector collector, int index) {
        this.board = board;
        this.collector = collector;
        this.index = index;
    }

    @Override
    public void run() {
        Checker boxChecker = CheckerFactory.createChecker("box", board);

        List<DuplicateResult> results;

        if (index == -1) {
            // Check all 9 boxes
            results = boxChecker.check();
        } else {
            // Check only a single box
            results = boxChecker.checkSingle(index);
        }

        for (DuplicateResult result : results) {
            collector.collect(result);
        }
    }

}
