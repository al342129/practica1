package csv;

import table.Row;
import table.RowWithLabel;
import table.Table;
import table.TableWithLabels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSV {
    Table table;
    TableWithLabels tableWithLabels;
    public List<String> headers = new ArrayList<>();
    public List<Row> rows = new ArrayList<Row>();
    public List<RowWithLabel> rowsWithLabels = new ArrayList<RowWithLabel>();

    Map<String, Integer> labelsToIndex = new HashMap<>();


    Table readTable(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (headers.size() < values.length) {
                for (String header : values) {
                    headers.add(header);
                }
            }else {
                List<Double> data = new ArrayList<>();
                for (String value : values) {
                    data.add(Double.parseDouble(value));
                }
                rows.add(new Row(data));
            }
        }
        reader.close();table = new Table(headers ,rows);
        return table;
    }



    public TableWithLabels readTableWithLabels(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            if (headers.size() < values.length) {
                for (String header : values) {
                    headers.add(header);
                }
            }else {
                List<Double> data = new ArrayList<>();
                for (int i = 0; i < values.length - 1; i++) // paramos en la penultima columna.
                data.add(Double.parseDouble(values[i]));


                String key = values[values.length - 1];
                // si no contiene la clave en el mapa, la añade
                if (!labelsToIndex.containsKey(key)) {
                    labelsToIndex.put(key, labelsToIndex.size());
                }
                rowsWithLabels.add(new RowWithLabel(data,labelsToIndex.get(key)));
            }
        }
        reader.close();
        tableWithLabels = new TableWithLabels(headers,rowsWithLabels,labelsToIndex);
        return tableWithLabels;

    }


}
