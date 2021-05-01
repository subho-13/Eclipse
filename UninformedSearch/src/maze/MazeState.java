package maze;

import model.State;

public class MazeState implements State<MazeState> {
	private final int row;
	private final int col;
	private MazeState parent;

	public MazeState(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(MazeState mazeState) {
		if (mazeState.row < this.row) {
			return -1;
		}
		if (mazeState.row == this.row) {
			if (mazeState.col == this.col) {
				return 0;
			}
			if (mazeState.col < this.col) {
				return -1;
			}

			return 1;
		}

		return 1;
	}

	public int getCol() {
		return this.col;
	}

	@Override
	public MazeState getParent() {
		return this.parent;
	}

	public int getRow() {
		return this.row;
	}

	@Override
	public void setParent(MazeState parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "(" + this.row + ", " + this.col + ")";
	}

}
