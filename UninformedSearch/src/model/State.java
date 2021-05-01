package model;

public interface State<T extends State<T>> extends Comparable<T> {
    public T getParent();

    public void setParent(T tmpState);
}
