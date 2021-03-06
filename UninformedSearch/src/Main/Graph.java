package Main;

import java.io.FileNotFoundException;

import algo.BFS;
import algo.BIBFS;
import algo.DFS;
import algo.IDDFS;
import graph.GraphModel;

public class Graph {
    public static void main(String[] args) throws FileNotFoundException {
        GraphModel graphModel = new GraphModel("graph1.txt", 1, 3);
        BFS.solve(graphModel);
        graphModel.getSolution();

        DFS.solve(graphModel);
        graphModel.getSolution();

        BIBFS.solve(graphModel);
        graphModel.getSolution();

        graphModel = new GraphModel("graph2.txt", 1, 14);
        IDDFS.solve(graphModel);
        graphModel.getSolution();
    }
}
