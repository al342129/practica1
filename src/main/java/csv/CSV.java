package csv;

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
    List<Double> data = new ArrayList<>();

    Map<String,Integer> labelsToIndex;


    Table readTable(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] headersLinea = br.readLine().split(",");
            for (String header : headersLinea)
                headers.add(header);

            while (br.readLine() != null) {
                String[] rowLinea = br.readLine().split(",");
                for (String r : rowLinea)
                    data.add(Double.parseDouble(r));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }


    TableWithLabels readTableWithLabels(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] headersLinea = br.readLine().split(",");
            for (String header : headersLinea)
                headers.add(header);

            while (br.readLine() != null) {
                String[] rowLinea = br.readLine().split(",");
                for (int i=0; i<rowLinea.length-1; i++)
                    data.add(Double.parseDouble(rowLinea[i]));
               labelsToIndex.put(rowLinea[rowLinea.length-1], contador);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableWithLabels;
    }


}
