package solution_1472;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    List<String> list;
    int pos;

    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
    }

    public void visit(String url) {
        pos++;
        if (pos != list.size()) {
            list.subList(pos, list.size()).clear();
        }
        list.add(url);
    }

    public String back(int steps) {
        pos = Math.max(0, pos - steps);
        return list.get(pos);
    }

    public String forward(int steps) {
        pos = Math.min(list.size() - 1, pos + steps);
        return list.get(pos);
    }
}
