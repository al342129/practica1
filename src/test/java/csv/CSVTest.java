package csv;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import table.Table;
import table.TableWithLabels;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    private CSV csv ,csvW;
    private String nombreFichero;

    Table table;
    TableWithLabels tableWithLabels;

    private List<Double> characteristics;


    //    Map<String, Integer> labelsToIndex = new HashMap<>();
    @BeforeEach
    void init() throws IOException {
        csv = new CSV();
        csvW = new CSV();

        nombreFichero ="/Users/wadiebouanfar/Documents/GitHub/practica1/csvFich/iris.csv";
        tableWithLabels = csvW.readTableWithLabels(nombreFichero);

        nombreFichero  = "/Users/wadiebouanfar/Documents/GitHub/practica1/csvFich/irisSin.csv";
        table = csv.readTable(nombreFichero);
        characteristics  = new ArrayList<>();
        characteristics.add(5.1);
        characteristics.add(3.5);
        characteristics.add(1.4);
        characteristics.add(0.2);



    }


    @Test
    @DisplayName("Test de numero de filas")
    void testNumberOfRows() {
        System.out.println("Comprobando numero de filas con el metodo getNumRows()\n");
        assertEquals(9, (csv.table.getNumRows()));

    }

    @Test
    @DisplayName("Test de numero de columnas")
    void testNumberOfCols() {
        System.out.println("Comprobando numero de columnas con el metodo getNumColumns()\n");
        assertEquals(4, csv.table.getNumColumns());
        System.out.println("Comprobando numero de columnas con headers.size()\n");
        assertEquals(4, csv.headers.size());


    }

    @Test
    @DisplayName("Test de nombre de las etiquetas de las cabeceras")
    void testNameOfFlags() throws IOException {
        System.out.println("Comprobando el metodo getRowAt().getNumberClass()");

        //Iris-setosa es 0 y ..1...2

        assertEquals(0, csvW.tableWithLabels.getRowAt(1).getNumberClass());

    }
    @Test
    @DisplayName("Test de Datos ")
    void testNumAsigned(){
        System.out.println("Comprobando el metodo getRowAt().getData()");
        assertEquals(characteristics,csvW.tableWithLabels.getRowAt(0).getData());

    }



}