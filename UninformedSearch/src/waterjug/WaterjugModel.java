package waterjug;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class WaterjugModel implements Model<WaterjugState> {
	private final WaterjugState goalState;
	private final WaterjugState initialState;
	private final int jug1cap;
	private final int jug2cap;
	private List<WaterjugState> solutionList;

	public WaterjugModel(int jug1cap, int jug2cap, int jug1final, int jug2final) {
		this.jug1cap = jug1cap;
		this.jug2cap = jug2cap;
		this.initialState = new WaterjugState(0, 0);
		this.goalState = new WaterjugState(jug1final, jug2final);
	}

	private WaterjugState actionEmptyJug1(int jug1, int jug2) {
		return new WaterjugState(0, jug2);
	}

	private WaterjugState actionEmptyJug2(int jug1, int jug2) {
		return new WaterjugState(jug1, 0);
	}

	private WaterjugState actionFillJug1(int jug1, int jug2) {
		return new WaterjugState(this.jug1cap, jug2);
	}

	private WaterjugState actionFillJug2(int jug1, int jug2) {
		return new WaterjugState(jug1, this.jug2cap);
	}

	private WaterjugState actionPourJug1to2(int jug1, int jug2) {
		final int d = Math.min(jug1, this.jug2cap - jug2);
		return new WaterjugState(jug1 - d, jug2 + d);
	}

	private WaterjugState actionPourJug2to1(int jug1, int jug2) {
		final int d = Math.min(this.jug1cap - jug1, jug2);
		return new WaterjugState(jug1 + d, jug2 - d);
	}

	@Override
	public WaterjugState getGoalState() {
		return this.goalState;
	}

	@Override
	public WaterjugState getInitialState() {
		return this.initialState;
	}

	@Override
	public List<WaterjugState> getNextStates(WaterjugState waterjugState) {
		final int jug1 = waterjugState.getJug1();
		final int jug2 = waterjugState.getJug2();
		final List<WaterjugState> waterjugStates = new ArrayList<WaterjugState>();

		waterjugStates.add(this.actionEmptyJug1(jug1, jug2));
		waterjugStates.add(this.actionEmptyJug2(jug1, jug2));
		waterjugStates.add(this.actionFillJug1(jug1, jug2));
		waterjugStates.add(this.actionFillJug2(jug1, jug2));
		waterjugStates.add(this.actionPourJug1to2(jug1, jug2));
		waterjugStates.add(this.actionPourJug2to1(jug1, jug2));

		return waterjugStates;
	}

	public void printSolution() {
		System.out.println(this.solutionList);
	}

	@Override
	public void setSolution(List<WaterjugState> solutionList) {
		this.solutionList = solutionList;
	}

}
