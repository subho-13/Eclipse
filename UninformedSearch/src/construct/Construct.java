package construct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.State;

public class Construct {
	public static <T extends State<T>> List<T> solution(T goalState) {
		final List<T> list = new ArrayList<T>();

		T tmpState = goalState;

		while (tmpState != null) {
			list.add(tmpState);
			tmpState = tmpState.getParent();
		}
		Collections.reverse(list);

		return list;
	}
}
