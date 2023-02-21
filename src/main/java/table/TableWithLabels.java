package table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    Map<String,Integer> labelsToIndex;


    public TableWithLabels(List<String> headers) {
        super(headers);
        labelsToIndex = new HashMap<>();
    }

    public RowWithLabel getRowAt(int rowNumber){
        return(RowWithLabel) data.get(rowNumber);
    }
}
