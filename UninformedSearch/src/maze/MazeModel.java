package maze;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Model;

public class MazeModel implements Model<MazeState> {
	private final List<List<MazeCell>> maze;
	private MazeState initialState;
	private MazeState goalState;
	private List<MazeState> solutionList;

	public MazeModel(String filename) throws FileNotFoundException {
		this.maze = ParseMaze.get(filename);
		this.setInitialState();
		this.setGoalState();
	}

	private MazeState actionMoveDown(int row, int col) {
		if (row != this.maze.size() - 1 && this.maze.get(row + 1).get(col) != MazeCell.BOUNDARY) {
			return new MazeState(row + 1, col);
		}

		return null;
	}

	private MazeState actionMoveLeft(int row, int col) {
		if (this.maze.get(row).get(col - 1) != MazeCell.BOUNDARY) {
			return new MazeState(row, col - 1);
		}

		return null;
	}

	private MazeState actionMoveRight(int row, int col) {
		if (this.maze.get(row).get(col + 1) != MazeCell.BOUNDARY) {
			return new MazeState(row, col + 1);
		}

		return null;
	}

	private MazeState actionMoveUp(int row, int col) {
		if (row != 0 && this.maze.get(row - 1).get(col) != MazeCell.BOUNDARY) {
			return new MazeState(row - 1, col);
		}

		return null;
	}

	public void drawSolution(String filename) throws IOException {
		this.solutionList.remove(0);
		this.solutionList.remove(this.solutionList.size() - 1);

		for (final MazeState state : this.solutionList) {
			final int row = state.getRow();
			final int col = state.getCol();
			this.maze.get(row).set(col, MazeCell.PATH);
		}

		DrawMaze.set(filename, this.maze);
	}

	@Override
	public MazeState getGoalState() {
		return this.goalState;
	}

	@Override
	public MazeState getInitialState() {
		return this.initialState;
	}

	@Override
	public List<MazeState> getNextStates(MazeState state) {
		final int row = state.getRow();
		final int col = state.getCol();
		final List<MazeState> mazeStates = new ArrayList<MazeState>();

		MazeState mazeState;

		mazeState = this.actionMoveUp(row, col);
		if (mazeState != null) {
			mazeStates.add(mazeState);
		}

		mazeState = this.actionMoveDown(row, col);
		if (mazeState != null) {
			mazeStates.add(mazeState);
		}

		mazeState = this.actionMoveLeft(row, col);
		if (mazeState != null) {
			mazeStates.add(mazeState);
		}

		mazeState = this.actionMoveRight(row, col);
		if (mazeState != null) {
			mazeStates.add(mazeState);
		}

		return mazeStates;
	}

	private void setGoalState() {
		for (int row = 0; row < this.maze.size(); row++) {
			for (int col = 0; col < this.maze.get(row).size(); col++) {
				if (this.maze.get(row).get(col) == MazeCell.EXIT) {
					this.goalState = new MazeState(row, col);
					return;
				}
			}
		}
	}

	private void setInitialState() {
		for (int row = 0; row < this.maze.size(); row++) {
			for (int col = 0; col < this.maze.get(row).size(); col++) {
				if (this.maze.get(row).get(col) == MazeCell.ENTRY) {
					this.initialState = new MazeState(row, col);
					return;
				}
			}
		}
	}

	@Override
	public void setSolution(List<MazeState> solutionList) {
		this.solutionList = solutionList;

	}

}
