package checker;

public class CheckerFactory {

    public static Checker createChecker(String type, int[][] board) {

        switch (type.toLowerCase()) {

            case "row":
                return new RowChecker(board);

            case "column":
            case "col":
                return new ColumnChecker(board);

            case "box":
                return new BoxChecker(board);

            default:
                throw new IllegalArgumentException("Unknown checker type: " + type);
        }
    }
}

