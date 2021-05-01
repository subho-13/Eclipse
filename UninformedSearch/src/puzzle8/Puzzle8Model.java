package puzzle8;

import java.io.FileNotFoundException;
import java.util.List;

import model.Model;

public class Puzzle8Model implements Model<Puzzle8State> {
    Puzzle8State goalState;
    Puzzle8State initialState;
    List<Puzzle8State> solutionList;

    public Puzzle8Model(String filename) throws FileNotFoundException {
        final int arrs[][][] = ParsePuzzle8.from(filename);
        this.initialState = new Puzzle8State(arrs[0]);
        this.goalState = new Puzzle8State(arrs[1]);
    }

    @Override
    public Puzzle8State getGoalState() {
        return this.goalState;
    }

    @Override
    public Puzzle8State getInitialState() {
        return this.initialState;
    }

    @Override
    public List<Puzzle8State> getNextStates(Puzzle8State state) {
        return state.getNextStates();
    }

    public void getSolution() {
        System.out.println(this.solutionList);
    }

    @Override
    public void setSolution(List<Puzzle8State> solutions) {
        this.solutionList = solutions;
    }

}
