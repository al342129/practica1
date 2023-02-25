package csv;

import table.Row;
import table.Table;
import table.TableWithLabels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSV {
    Table table;
    TableWithLabels tableWithLabels;
    List<String> headers = new ArrayList<>();
    public List<Row> rows = new ArrayList<Row>();

    Map<String, Integer> labelsToIndex;


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
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] headersLinea = br.readLine().split(",");
            for (String header : headersLinea){
                headers.add(header);
                
                }

            while (br.readLine() != null) {
                String[] rowLinea = br.readLine().split(",");
                List<Double> data = new ArrayList<>();
                for (int i = 0; i < rowLinea.length - 1; i++) // paramos en la penultima columna.
                    data.add(Double.parseDouble(rowLinea[i]));
              //rows esta mal
                rows.add(new Row(data));
                String key = rowLinea[rowLinea.length - 1];
                // si no contiene la clave en el mapa, la añade
                if (!labelsToIndex.containsKey(key)) labelsToIndex.put(key, labelsToIndex.size()); //mapa.size() lo ultizamos como contador.desde el cero hasta n
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //falta añadir las cabeceras
        return tableWithLabels;
    }


}
