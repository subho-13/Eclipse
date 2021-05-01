package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Model;

public class GraphModel implements Model<GraphState> {
	Map<Integer, List<Integer>> graph;
	GraphState goalState;
	GraphState initialState;
	List<GraphState> solutionList;

	public GraphModel(String filename, int initialNode, int goalNode) throws FileNotFoundException {
		this.graph = ParseGraph.from(filename);
		this.initialState = new GraphState(initialNode);
		this.goalState = new GraphState(goalNode);
	}

	@Override
	public GraphState getGoalState() {
		return this.goalState;
	}

	@Override
	public GraphState getInitialState() {
		return this.initialState;
	}

	@Override
	public List<GraphState> getNextStates(GraphState state) {
		final List<GraphState> graphStates = new ArrayList<GraphState>();
		final List<Integer> nodeList = this.graph.get(state.getNode());
		if (nodeList != null) {
			for (final int node : nodeList) {
				graphStates.add(new GraphState(node));
			}
		}

		return graphStates;
	}

	public void getSolution() {
		System.out.println(this.solutionList);
	}

	@Override
	public void setSolution(List<GraphState> solutions) {
		this.solutionList = solutions;
	}

}
