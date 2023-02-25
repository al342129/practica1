package table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    Map<String,Integer> labelsToIndex;


    public TableWithLabels(List<String> headers, List<RowWithLabel> rows) {
        super(headers,new ArrayList<Row>(rows));
        labelsToIndex = new HashMap<>();
    }

    public RowWithLabel getRowAt(int rowNumber){
        return(RowWithLabel) rows.get(rowNumber);
    }
}
