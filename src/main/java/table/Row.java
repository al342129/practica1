package table;

import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Double> data;

    public Row() {
        this.data = new ArrayList<>();
    }

    public List<Double> getData() {
        return data;
    }

}
