// في checker/Main.java
package checker;

import board.CsvLoader;
import result.DuplicateResult;
import threads.RowThread;
import threads.ColumnThread;
import threads.BoxThread;
import utils.ResultCollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String[] TEST_FILES = {
            "valid.csv", "all_ones.csv", "row_error.csv",
            "col_error.csv", "box_error.csv", "mixed_errors.csv"
    };

    public static void main(String[] args) {

        if (args.length == 0) {
            runSelfTest();
            return;
        }

        if (args.length != 2) {
            System.out.println("Usage: java checker.Main <csv_file> <mode>");
            System.out.println("Modes: 0 (sequential), 3 (3 threads), 27 (27 threads)");
            return;
        }

        runSingleTest(args[0], Integer.parseInt(args[1]));
    }

    private static void runSelfTest() {
        System.out.println("==== SUDOKU CHECKER SELF-TEST ====\n");
        int mode = getModeFromUser();
        System.out.println();

        for (String file : TEST_FILES) {
            runSingleTest(file, mode);
        }
    }

    private static int getModeFromUser() {
        Scanner scanner = new Scanner(System.in);
        int mode;

        while (true) {
            System.out.println("Choose mode for self-test:");
            System.out.println("0 - Sequential");
            System.out.println("3 - 3 Threads");
            System.out.println("27 - 27 Threads");
            System.out.print("Enter mode (0, 3, or 27): ");

            try {
                mode = scanner.nextInt();
                if (mode == 0 || mode == 3 || mode == 27) {
                    break;
                } else {
                    System.out.println("Invalid mode! Please enter 0, 3, or 27.\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.\n");
                scanner.next(); // clear invalid input
            }
        }

        return mode;
    }

    private static void runSingleTest(String csvFile, int mode) {
        System.out.println("-----------------------------------------");
        System.out.println("TESTING FILE: " + csvFile + " | MODE: " + mode);
        System.out.println("-----------------------------------------");

        try {
            int[][] board = CsvLoader.loadSudokuCSV(csvFile);
            List<DuplicateResult> errors = verifyBoard(board, mode);
            printResults(errors);

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "\n");
        }
    }

    private static List<DuplicateResult> verifyBoard(int[][] board, int mode) {
        switch (mode) {
            case 0: return verifySequential(board);
            case 3: return verifyThreeThreads(board);
            case 27: return verifyTwentySevenThreads(board);
            default:
                System.out.println("Invalid mode. Using sequential.");
                return verifySequential(board);
        }
    }

    private static List<DuplicateResult> verifySequential(int[][] board) {
        List<DuplicateResult> errors = new ArrayList<>();

        Checker rowChecker = CheckerFactory.createChecker("row", board);
        Checker colChecker = CheckerFactory.createChecker("col", board);
        Checker boxChecker = CheckerFactory.createChecker("box", board);

        errors.addAll(rowChecker.check());
        errors.addAll(colChecker.check());
        errors.addAll(boxChecker.check());

        return errors;
    }

    private static List<DuplicateResult> verifyThreeThreads(int[][] board) {
        ResultCollector collector = new ResultCollector();

        Thread rowThread = new RowThread(board, collector);
        Thread colThread = new ColumnThread(board, collector);
        Thread boxThread = new BoxThread(board, collector);

        rowThread.start();
        colThread.start();
        boxThread.start();

        try {
            rowThread.join();
            colThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return collector.getResults();
    }

    private static List<DuplicateResult> verifyTwentySevenThreads(int[][] board) {
        System.out.println("Mode 27 not implemented yet. Using sequential.");
        return verifySequential(board);
    }

    private static void printResults(List<DuplicateResult> errors) {
        if (errors.isEmpty()) {
            System.out.println("RESULT: VALID\n");
        } else {
            System.out.println("RESULT: INVALID");
            for (DuplicateResult err : errors) {
                System.out.println(err);
            }
            System.out.println();
        }
    }
}