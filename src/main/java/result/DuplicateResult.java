// في result/DuplicateResult.java
package result;

import java.util.ArrayList;
import java.util.List;

public class DuplicateResult {
    private final String type;     // ROW, COL, BOX
    private final int index;       // 1–9
    private final int duplicate;   // The repeated number (ex: 1)
    private final int[] values;    // Full row/col/box content

    public DuplicateResult(String type, int index, int duplicate, int[] values) {
        this.type = type;
        this.index = index;
        this.duplicate = duplicate;
        this.values = values;
    }

    @Override
    public String toString() {
        // نجمع كل المواقع اللي فيها الرقم المكرر
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (values[i] == duplicate) {
                // المواقع تبدأ من 1
                positions.add(i + 1);
            }
        }

        return type + " " + index + ", #" + duplicate + ", " + positions;
    }
}