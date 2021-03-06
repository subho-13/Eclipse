package puzzle8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParsePuzzle8 {
    public static int[][][] from(String filename) throws FileNotFoundException {
        final int arr[][][] = new int[2][3][3];

        final File file = new File(filename);
        final Scanner scanner = new Scanner(file);

        int i = 0;

        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String[] ints = line.split(" ");

            int count = 0;
            for (final String tmp : ints) {
                arr[i][count / 3][count % 3] = Integer.parseInt(tmp);
                count++;
            }
            i++;
        }

        scanner.close();
        return arr;
    }
}
