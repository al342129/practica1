package table;

import java.util.List;
import java.util.Map;

public class RowWithLabel extends Row {
    int numberClass;

    public RowWithLabel(List<Double> data, int numberClass) {
        super(data);
        this.numberClass = numberClass;
    }

    public int getNumberClass() {
        return numberClass;
    }


}
