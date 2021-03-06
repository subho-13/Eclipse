package algo;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import construct.Construct;
import model.Model;
import model.State;

public class DFS {
	public static <T extends State<T>> void solve(Model<T> model) {
		final Set<T> exploredStates = new TreeSet<>();
		final Stack<T> newStates = new Stack<T>();

		final T initialState = model.getInitialState();
		final T goalState = model.getGoalState();

		newStates.add(initialState);

		while (!newStates.isEmpty()) {
			final T tmpState = newStates.pop();

			if (tmpState.compareTo(goalState) == 0) {
				model.setSolution(Construct.solution(tmpState));
				return;
			}

			exploredStates.add(tmpState);

			final List<T> nextStates = model.getNextStates(tmpState);

			for (final T state : nextStates) {
				if (exploredStates.contains(state) == false) {
					state.setParent(tmpState);
					newStates.push(state);
				}
			}
		}
	}
}
