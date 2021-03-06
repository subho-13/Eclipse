package weightedgraph;

import model.State;

public class WeightedGraphState implements State<WeightedGraphState> {
    int node;
    int weight;

    WeightedGraphState parent;

    public WeightedGraphState(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedGraphState state) {
        if (this.node == state.node) {
            return 0;
        }

        if (this.weight < state.weight) {
            return -1;
        }

        return 1;
    }

    public int getNode() {
        return this.node;
    }

    @Override
    public WeightedGraphState getParent() {
        return this.parent;
    }

    @Override
    public void setParent(WeightedGraphState parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + this.node;
    }
}
