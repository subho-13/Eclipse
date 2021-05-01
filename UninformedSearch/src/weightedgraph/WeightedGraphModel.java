package weightedgraph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Model;

public class WeightedGraphModel implements Model<WeightedGraphState> {
    Map<Integer, List<int[]>> graph;
    WeightedGraphState goalState;
    WeightedGraphState initialState;
    List<WeightedGraphState> solutionList;

    public WeightedGraphModel(String filename, int initialNode, int goalState)
                    throws FileNotFoundException {
        this.graph = ParseWeightedGraph.from(filename);
        this.initialState = new WeightedGraphState(initialNode, 0);
        this.goalState = new WeightedGraphState(goalState, 0);
    }

    @Override
    public WeightedGraphState getGoalState() {
        return this.goalState;
    }

    @Override
    public WeightedGraphState getInitialState() {
        return this.initialState;
    }

    @Override
    public List<WeightedGraphState> getNextStates(WeightedGraphState state) {
        final List<WeightedGraphState> weightedGraphStates = new ArrayList<>();

        final List<int[]> nodes = this.graph.get(state.getNode());

        for (final int[] node : nodes) {
            weightedGraphStates.add(new WeightedGraphState(node[0], node[1]));
        }

        return weightedGraphStates;
    }

    public void getSolution() {
        System.out.println(this.solutionList);
    }

    @Override
    public void setSolution(List<WeightedGraphState> solutions) {
        this.solutionList = solutions;
    }

}
