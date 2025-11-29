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
import utils.*;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            verifications.runSelfTest();
            return;
        }

        if (args.length != 2) {
            System.out.println("Usage: java checker.Main <csv_file> <mode>");
            System.out.println("Modes: 0 (sequential), 3 (3 threads), 27 (27 threads)");
            return;
        }

        verifications.runSingleTest(args[0], Integer.parseInt(args[1]));
    }
}