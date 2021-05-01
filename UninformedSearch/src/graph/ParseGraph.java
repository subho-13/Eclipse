package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParseGraph {
	public static Map<Integer, List<Integer>> from(String filename) throws FileNotFoundException {
		final Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		final File file = new File(filename);
		final Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();

			final List<String> ints = new ArrayList<String>(Arrays.asList(line.split(" ")));

			final int from = Integer.parseInt(ints.remove(0));

			if (!graph.containsKey(from)) {
				graph.put(from, new ArrayList<Integer>());
			}

			for (final String tmp : ints) {
				final int to = Integer.parseInt(tmp);
				graph.get(from).add(to);
			}
		}

		scanner.close();
		return graph;
	}
}
