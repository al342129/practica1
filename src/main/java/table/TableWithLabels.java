package table;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    public Map<String,Integer> labelsToIndex ;



    public TableWithLabels(List<String> headers, List<RowWithLabel> rows,  Map<String,Integer> labelsToIndex ) {
        super(headers, new ArrayList<>(rows));
        this.labelsToIndex = labelsToIndex;
    }

    public RowWithLabel getRowAt(int rowNumber){
        return(RowWithLabel) super.rows.get(rowNumber);

    }
    public String getLabel(int index){
        for (String key : labelsToIndex.keySet())
            if (labelsToIndex.get(key).equals(index))
                return key;
        return "no tiene clave";
    }


}
