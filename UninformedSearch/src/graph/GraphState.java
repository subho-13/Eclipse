package graph;

import model.State;

public class GraphState implements State<GraphState> {
	int node;
	GraphState parent;

	public GraphState(int node) {
		this.node = node;
	}

	@Override
	public int compareTo(GraphState graphState) {
		if (this.node < graphState.node) {
			return -1;
		}

		if (this.node > graphState.node) {
			return -1;
		}

		return 0;
	}

	public int getNode() {
		return this.node;
	}

	@Override
	public GraphState getParent() {
		return this.parent;
	}

	@Override
	public void setParent(GraphState parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "" + this.node;
	}
}
