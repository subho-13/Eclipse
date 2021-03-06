package Main;

import java.io.IOException;

import algo.BFS;
import maze.MazeModel;

public class Maze {
    public static void main(String[] args) throws IOException {
        final MazeModel mazeModel = new MazeModel("maze1.txt");
        BFS.solve(mazeModel);
        mazeModel.drawSolution("maze1res.txt");
    }

}
