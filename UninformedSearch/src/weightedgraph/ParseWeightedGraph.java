package weightedgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParseWeightedGraph {
    public static Map<Integer, List<int[]>> from(String filename) throws FileNotFoundException {
        final File file = new File(filename);
        final Scanner scanner = new Scanner(file);

        final Map<Integer, List<int[]>> graph = new HashMap<>();

        while (scanner.hasNextLine()) {
            final String[] ints = scanner.nextLine().split(" ");
            final int from = Integer.parseInt(ints[0]);
            final int to = Integer.parseInt(ints[1]);
            final int weight = Integer.parseInt(ints[2]);
            final int[] arr = new int[2];
            arr[0] = to;
            arr[1] = weight;

            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<int[]>());
            }

            graph.get(from).add(arr);
        }

        scanner.close();

        return graph;
    }
}
