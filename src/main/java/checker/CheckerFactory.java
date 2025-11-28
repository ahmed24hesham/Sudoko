package checker;

public class CheckerFactory {

    public static Checker createChecker(String type) {
        return switch (type.toLowerCase()) {
            case "row" -> new RowChecker();
            case "col" -> new ColumnChecker();
            case "box" -> new BoxChecker();
            default -> throw new IllegalArgumentException("Unknown checker type: " + type);
        };
    }
}