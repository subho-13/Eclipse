package puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.State;

public class Puzzle8State implements State<Puzzle8State> {
    int[][] arr;
    int row;
    int col;

    Puzzle8State parent;

    public Puzzle8State(int[][] arr) {
        this.arr = arr;
    }

    private int[][] clonearr() {
        final int[][] newarr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newarr[i][j] = this.arr[i][j];
            }
        }

        return newarr;
    }

    @Override
    public int compareTo(Puzzle8State puzzle8State) {
        if (Arrays.equals(this.arr, puzzle8State.arr)) {
            return 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.arr[i][j] < puzzle8State.arr[i][j]) {
                    return -1;
                }
            }
        }

        return 1;
    }

    private void getIndexOfZero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.arr[i][j] == 0) {
                    this.row = i;
                    this.col = j;
                }
            }
        }
    }

    public List<Puzzle8State> getNextStates() {
        final List<Puzzle8State> states = new ArrayList<>();
        this.getIndexOfZero();
        int tmprow;
        int tmpcol;

        tmprow = this.row + 1;
        if (tmprow < 3) {
            final int[][] arr1 = this.clonearr();
            arr1[this.row][this.col] = arr1[tmprow][this.col];
            arr1[tmprow][this.col] = 0;
            states.add(new Puzzle8State(arr1));
        }

        tmprow = this.row - 1;
        if (tmprow >= 0) {
            final int[][] arr1 = this.clonearr();
            arr1[this.row][this.col] = arr1[tmprow][this.col];
            arr1[tmprow][this.col] = 0;
            states.add(new Puzzle8State(arr1));
        }

        tmpcol = this.col + 1;
        if (tmpcol < 3) {
            final int[][] arr1 = this.clonearr();
            arr1[this.row][this.col] = arr1[this.row][tmpcol];
            arr1[this.row][tmpcol] = 0;
            states.add(new Puzzle8State(arr1));
        }

        tmpcol = this.col - 1;
        if (tmpcol >= 0) {
            final int[][] arr1 = this.clonearr();
            arr1[this.row][this.col] = arr1[this.row][tmpcol];
            arr1[this.row][tmpcol] = 0;
            states.add(new Puzzle8State(arr1));
        }

        return states;
    }

    @Override
    public Puzzle8State getParent() {
        return this.parent;
    }

    @Override
    public void setParent(Puzzle8State parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        final StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s.append(this.arr[i][j]).append(" ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
