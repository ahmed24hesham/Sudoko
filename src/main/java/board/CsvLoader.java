package board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvLoader {


    public static int[][] loadSudokuCSV(String path) throws IOException {

        int[][] board = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(path)))  {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 9) {

                String[] values = line.split(",");

                if (values.length != 9) {
                    throw new IOException("Invalid CSV format: each row must contain 9 numbers.");
                }

                for (int col = 0; col < 9; col++) {
                    board[row][col] = Integer.parseInt(values[col].trim());
                }

                row++;
            }

            if (row != 9) {
                throw new IOException("Invalid CSV format: file must contain exactly 9 lines.");
            }
        }

        return board;
    }
}