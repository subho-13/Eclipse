package maze;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DrawMaze {
    public static void set(String filename, List<List<MazeCell>> maze) throws IOException {
        final FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write("\n\n");

        for (final List<MazeCell> row : maze) {
            row.remove(0);
            row.remove(row.size() - 1);
            for (final MazeCell cell : row) {
                switch (cell) {
                case ENTRY: {
                    fileWriter.write('>');
                    break;
                }

                case EXIT: {
                    fileWriter.write('x');
                    break;
                }

                case PATH: {
                    fileWriter.write('.');
                    break;
                }

                case FREE: {
                    fileWriter.write('0');
                    break;
                }

                case BOUNDARY: {
                    fileWriter.write('+');
                    break;
                }
                }
                fileWriter.write(' ');
            }

            fileWriter.write('\n');
        }

        fileWriter.close();
    }

}
