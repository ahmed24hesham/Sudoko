package result;

import java.util.ArrayList;
import java.util.List;


import java.util.Set;

public class DuplicateResult {

    private final String location;
    private final Set<Integer> duplicates;

    public DuplicateResult(String location, Set<Integer> duplicates) {
        this.location = location;
        this.duplicates = duplicates;
    }

    @Override
    public String toString() {
        return location + " duplicates: " + duplicates;
    }
}
