package algo;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import construct.Construct;
import model.Model;
import model.State;

public class GBFS {
    public static <T extends State<T>> void solve(Model<T> model) {
        final Set<T> exploredStates = new TreeSet<T>();
        final PriorityQueue<T> newStates = new PriorityQueue<T>();

        final T initialState = model.getInitialState();
        final T goalState = model.getGoalState();

        newStates.add(initialState);

        while (!newStates.isEmpty()) {
            final T tmpState = newStates.remove();

            if (tmpState.compareTo(goalState) == 0) {
                model.setSolution(Construct.solution(tmpState));
                return;
            }

            exploredStates.add(tmpState);

            final List<T> nextStates = model.getNextStates(tmpState);

            for (final T state : nextStates) {
                if (!exploredStates.contains(state)) {
                    state.setParent(tmpState);
                    newStates.add(state);
                }
            }
        }
    }
}
