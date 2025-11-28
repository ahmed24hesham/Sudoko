package utils;

import result.DuplicateResult;
import java.util.ArrayList;
import java.util.List;

public class ResultCollector {

    private final List<DuplicateResult> results = new ArrayList<>();

    public synchronized void collect(DuplicateResult result) {
        results.add(result);
    }

    public List<DuplicateResult> getResults() {
        return results;
    }
}
