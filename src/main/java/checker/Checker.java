package checker;

import java.util.List;
import result.DuplicateResult;


public interface Checker {

    /**
     * Checks the board for duplicates and returns
     * a list of DuplicateResult objects.
     *
     * If the list is empty, this checker found no errors.
     */
    List<DuplicateResult> check();
}

