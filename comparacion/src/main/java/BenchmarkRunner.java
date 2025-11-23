import java.util.*;

public class BenchmarkRunner {

    // Ahora recibe Comparable[] para soportar objetos
    public static SortStats ejecutarConRepeticiones(Comparable[] base, String algoritmo) {
        List<Long> tiempos = new ArrayList<>();
        SortStats acumulado = new SortStats();

        // Ejecutamos 10 veces para sacar un promedio/mediana
        for (int r = 0; r < 10; r++) {
            Comparable[] copia = base.clone(); // Clonamos los objetos
            SortStats s = new SortStats();

            switch (algoritmo) {
                case "bubble" -> BubbleSort.sort(copia, s);
                case "insertion" -> InsertionSort.sort(copia, s);
                case "selection" -> SelectionSort.sort(copia, s);
            }

            // Descartamos las 3 primeras corridas (calentamiento de la JVM)
            if (r >= 3) {
                tiempos.add(s.timeNs);
                acumulado.comparisons += s.comparisons;
                acumulado.swaps += s.swaps;
            }
        }

        tiempos.sort(Long::compare);
        // Mediana de tiempo
        acumulado.timeNs = tiempos.get(tiempos.size() / 2);

        // Promedio de swaps/comparaciones (dividir por 7 corridas válidas)
        acumulado.comparisons /= 7;
        acumulado.swaps /= 7;

        return acumulado;
    }
}