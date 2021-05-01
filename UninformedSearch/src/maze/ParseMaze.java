package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// > Represents entry to maze
// x Represents exit to maze
// 0 Represents free cell
// + Represents boundary
// Starting and ending of a line represents natural boundary

public class ParseMaze {
	public static List<List<MazeCell>> get(String filename) throws FileNotFoundException {
		final List<List<MazeCell>> maze = new ArrayList<List<MazeCell>>();

		final File file = new File(filename);
		final Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			final List<MazeCell> newRow = new ArrayList<MazeCell>();
			newRow.add(MazeCell.BOUNDARY);

			final String line = scanner.nextLine();

			for (final char c : line.toCharArray()) {
				switch (c) {
				case '>': {
					newRow.add(MazeCell.ENTRY);
					break;
				}

				case 'x': {
					newRow.add(MazeCell.EXIT);
					break;
				}

				case '0': {
					newRow.add(MazeCell.FREE);
					break;
				}

				case '+': {
					newRow.add(MazeCell.BOUNDARY);
					break;
				}
				}
			}

			newRow.add(MazeCell.BOUNDARY);
			maze.add(newRow);
		}

		scanner.close();

		return maze;
	}
}
