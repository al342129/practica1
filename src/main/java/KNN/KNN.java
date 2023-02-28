package KNN;

import table.RowWithLabel;
import table.Table;
import table.TableWithLabels;

import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class KNN {
    TableWithLabels table;

    // guarda la tabla para usarla en la funcion estimate.
    public void train(TableWithLabels data) {
        table = data;


    }

    // estima : compara el ejemplar con los ejemplares dados del metodo train.
    public Integer estimate(List<Double> data) {
        double dMin = 999999999;
        double d = 0;
        int pos = 0;
        for (int i = 0; i < table.getNumRows(); i++) {
            d = distancia(data, table.getRowAt(i).getData());
            if (dMin < d) {
                dMin = d;
                pos = i;
            }

        }
        return table.getRowAt(pos).getNumberClass();
    }


    public double distancia(List<Double> z, List<Double> x) {
        int dimensiones = table.headers.size() - 1;

        double distanciaPunto = 0.0;

        for (int i = 1; i < dimensiones; i++)
            distanciaPunto += pow(z.get(i) - x.get(i), 2);

        return sqrt(distanciaPunto);
    }

}
