package table;

import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Double> data;

    public Row(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }
    public int getNumColumns() {
        return data.size();
    }

}
