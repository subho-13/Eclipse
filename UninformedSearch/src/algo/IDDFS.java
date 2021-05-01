package algo;

import model.Model;
import model.State;

public class IDDFS {
    public static <T extends State<T>> void solve(Model<T> model) {
        int depth = 0;
        while (DLS.solve(model, depth) == false) {
            depth++;
        }
    }
}
