package Main;

import java.io.FileNotFoundException;

import algo.GBFS;
import weightedgraph.WeightedGraphModel;

public class WeightedGraph {
    public static void main(String[] args) throws FileNotFoundException {
        final WeightedGraphModel weightedGraphModel = new WeightedGraphModel("weightedgraph.txt", 1,
                        7);
        GBFS.solve(weightedGraphModel);
        weightedGraphModel.getSolution();
    }
}
