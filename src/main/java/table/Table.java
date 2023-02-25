package table;

import java.util.List;

public class Table {

    List<String> headers;
    List<Row> rows;

    public Table(List<String> headers, List<Row> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public Row getRowAt(int rowNumber) {
        return rows.get(rowNumber);
    }
    public int getNumRows(){
        return rows.size()+1; // 1 es de la cabecera
    }
    public int getNumColumns(){
        return headers.size();
    }

    public List<Row> getRows() {
        return rows;
    }
}
