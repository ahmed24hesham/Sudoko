package result;

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
        StringBuilder sb = new StringBuilder();

        sb.append(type)
                .append(" ")
                .append(index)
                .append(", #")
                .append(duplicate)
                .append(", [");

        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
