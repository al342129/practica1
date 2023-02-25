package csv;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import table.Table;
import table.TableWithLabels;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    private CSV csv ;
    private String nombreFichero;

    Table table;
    TableWithLabels tableWithLabels;


//    Map<String, Integer> labelsToIndex = new HashMap<>();
    @BeforeEach
    void init() throws IOException {
        csv = new CSV();


        nombreFichero = "/Users/wadiebouanfar/Documents/GitHub/practica1/csvFich/irisSin.csv";
        table = csv.readTable(nombreFichero);


    }


    @Test
    @DisplayName("Test de numero de filas")
    void testNumberOfRows(){
        System.out.println("Comprobando numero de filas con el metodo getNumRows()\n");
        assertEquals(9,(csv.table.getNumRows()));

    }

    @Test
    @DisplayName("Test de numero de columnas")
    void testNumberOfCols(){
        System.out.println("Comprobando numero de columnas con el metodo getNumColumns()\n");
        assertEquals(4,csv.table.getNumColumns());
        System.out.println("Comprobando numero de columnas con headers.size()\n");
        assertEquals(4,csv.headers.size());


    }

    @Test
    @DisplayName("Test de nombre de las etiquetas de las cabeceras")
    void testNameOfFlags() throws IOException {
        nombreFichero = "/Users/wadiebouanfar/Documents/GitHub/practica1/csvFich/iris.csv";
        tableWithLabels = csv.readTableWithLabels(nombreFichero);
        System.out.println(tableWithLabels.getRowAt(0));

    }



}