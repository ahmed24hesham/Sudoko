import board.CsvLoader;
import checker.Checker;
import checker.CheckerFactory;
import result.DuplicateResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // CSV test files stored in your project root folder
    private static final String[] TEST_FILES = {
            "valid.csv",
            "all_ones.csv",
            "row_error.csv",
            "col_error.csv",
            "box_error.csv",
            "mixed_errors.csv"
    };

    public static void main(String[] args) {

        System.out.println("==== SUDOKU CHECKER SELF-TEST ====\n");

        for (String file : TEST_FILES) {
            runTest(file);
        }
    }



    private static void runTest(String csvFile) {

        System.out.println("-----------------------------------------");
        System.out.println("TESTING FILE: " + csvFile);
        System.out.println("-----------------------------------------");

        try {

            // 1) Load board from CSV
            int[][] board = CsvLoader.loadSudokuCSV(csvFile);

            // 2) Create checkers using your factory
            Checker rowChecker = CheckerFactory.createChecker("row", board);
            Checker colChecker = CheckerFactory.createChecker("column", board);
            Checker boxChecker = CheckerFactory.createChecker("box", board);

            // 3) Collect all errors
            List<DuplicateResult> errors = new ArrayList<>();
            errors.addAll(rowChecker.check());
            errors.addAll(colChecker.check());
            errors.addAll(boxChecker.check());

            // 4) Print results
            if (errors.isEmpty()) {
                System.out.println("RESULT: VALID\n");
            } else {
                System.out.println("RESULT: INVALID");
                for (DuplicateResult err : errors) {
                    System.out.println(err);
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("ERROR reading file: " + csvFile);
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
