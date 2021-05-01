package model;

import java.util.List;

public interface Model<T extends State<T>> {

	public T getGoalState();

	public T getInitialState();

	public List<T> getNextStates(T state);

	public void setSolution(List<T> solutions);
}
