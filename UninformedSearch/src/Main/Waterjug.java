package Main;

import algo.DFS;
import waterjug.WaterjugModel;

public class Waterjug {
    public static void main(String[] args) {
        final WaterjugModel waterjugModel = new WaterjugModel(4, 3, 2, 0);
        DFS.solve(waterjugModel);
        waterjugModel.printSolution();
    }
}
