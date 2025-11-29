package main;// checker/main.Main.java

import utils.*;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            verifications.runSelfTest();
            return;
        }

        if (args.length != 2) {
            System.out.println("Usage: java main.Main <csv_file> <mode>");
            System.out.println("Modes: 0 (sequential), 3 (3 threads), 27 (27 threads)");
            return;
        }

        verifications.runSingleTest(args[0], Integer.parseInt(args[1]));
    }
}