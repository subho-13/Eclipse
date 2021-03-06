package algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import construct.Construct;
import model.Model;
import model.State;

public class BIBFS {
    public static <T extends State<T>> void solve(Model<T> model) {
        int breadth = 0;
        while (solveIBFS(model, breadth) == false) {
            breadth++;
        }
    }

    private static <T extends State<T>> boolean solveIBFS(Model<T> model, int breadth) {
        final Set<T> exploredStates = new TreeSet<T>();
        final Queue<T> newStates = new LinkedList<T>();

        final T initialState = model.getInitialState();
        final T goalState = model.getGoalState();
        T tmpGoalState = goalState;

        newStates.add(initialState);

        while (!newStates.isEmpty()) {
            final T tmpState = newStates.remove();

            if (tmpState.compareTo(tmpGoalState) == 0) {
                tmpGoalState.setParent(tmpState.getParent());
                model.setSolution(Construct.solution(goalState));
                return true;
            }

            exploredStates.add(tmpState);

            final List<T> nextStates = model.getNextStates(tmpState);

            int b = 0;
            for (final T state : nextStates) {
                if (b > breadth) {
                    break;
                }
                b++;
                if (exploredStates.contains(state) == false) {
                    state.setParent(tmpState);
                    newStates.add(state);
                }
            }

            final T newGoalState = model.getNextStates(goalState).get(0);
            tmpGoalState.setParent(newGoalState);
            tmpGoalState = newGoalState;
        }

        return false;
    }
}
