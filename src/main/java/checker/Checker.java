package checker;

import java.util.List;
import result.DuplicateResult;

public interface Checker {
    List<DuplicateResult> check();
}
