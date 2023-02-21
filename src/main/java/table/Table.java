package table;

import java.util.List;

public class Table {

    List<String> headers;
    List<Row> data;

    public Table(List<String> headers) {
        this.headers = headers;
        this.data = data;
    }

    public Row getRowAt(int rowNumber) {
        return data.get(rowNumber);
    }

}
