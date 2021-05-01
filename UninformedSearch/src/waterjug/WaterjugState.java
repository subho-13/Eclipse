package waterjug;

import model.State;

public class WaterjugState implements State<WaterjugState> {
	private final int jug1;
	private final int jug2;
	private WaterjugState parent;

	public WaterjugState(int jug1, int jug2) {
		this.jug1 = jug1;
		this.jug2 = jug2;
	}

	@Override
	public int compareTo(WaterjugState waterjugState) {
		if (this.jug1 < waterjugState.jug1) {
			return -1;
		}

		if (this.jug1 > waterjugState.jug1) {
			return 1;
		}

		if (this.jug2 < waterjugState.jug2) {
			return -1;
		}

		if (this.jug2 > waterjugState.jug2) {
			return 1;
		}

		return 0;
	}

	public int getJug1() {
		return this.jug1;
	}

	public int getJug2() {
		return this.jug2;
	}

	@Override
	public WaterjugState getParent() {
		return this.parent;
	}

	@Override
	public void setParent(WaterjugState parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "(" + this.jug1 + " , " + this.jug2 + ")";
	}

}
