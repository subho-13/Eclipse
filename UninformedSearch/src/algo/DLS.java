package algo;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import construct.Construct;
import model.Model;
import model.State;

public class DLS {
    public static <T extends State<T>> boolean solve(Model<T> model, int depth) {
        final Set<T> exploredStates = new TreeSet<>();
        final Stack<T> newStates = new Stack<T>();

        final T initialState = model.getInitialState();
        final T goalState = model.getGoalState();

        newStates.add(initialState);

        int d = 0;
        while (!newStates.isEmpty() && d <= depth) {
            final T tmpState = newStates.pop();

            if (tmpState.compareTo(goalState) == 0) {
                model.setSolution(Construct.solution(tmpState));
                return true;
            }

            exploredStates.add(tmpState);

            final List<T> nextStates = model.getNextStates(tmpState);

            for (final T state : nextStates) {
                if (exploredStates.contains(state) == false) {
                    state.setParent(tmpState);
                    newStates.push(state);
                }
            }

            // System.out.println(newStates);

            d++;
        }

        model.setSolution(null);
        return false;
    }
}
