import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO BENCHMARK ===");
        probarCitas();
        probarCitasCasiOrdenadas();
        probarPacientes();
        probarInventario();
    }

    // ---------------------------------------------------------
    // 1. Citas normales (citas_100.csv)
    // ---------------------------------------------------------
    private static void probarCitas() {
        System.out.println("\n=== Citas (Aleatorio) ===");
        List<String> lineas = CSVLoader.cargarLineas("citas_100.csv");
        if (!lineas.isEmpty()) lineas.remove(0); // quitar encabezado

        // Convertimos a Objetos Cita reales
        Cita[] arreglo = lineas.stream()
                .map(Cita::fromCsv)
                .toArray(Cita[]::new);

        correrTabla(arreglo);
    }

    // ---------------------------------------------------------
    // 2. Citas casi ordenadas (citas_100_casi_ordenadas.csv)
    // ---------------------------------------------------------
    private static void probarCitasCasiOrdenadas() {
        System.out.println("\n=== Citas (Casi Ordenadas) ===");
        List<String> lineas = CSVLoader.cargarLineas("citas_100_casi_ordenadas.csv");
        if (!lineas.isEmpty()) lineas.remove(0);

        // Reutilizamos la clase Cita (misma estructura)
        Cita[] arreglo = lineas.stream()
                .map(Cita::fromCsv)
                .toArray(Cita[]::new);

        correrTabla(arreglo);
    }

    // ---------------------------------------------------------
    // 3. Pacientes (pacientes_500.csv)
    // ---------------------------------------------------------
    private static void probarPacientes() {
        System.out.println("\n=== Pacientes (Duplicados/Estabilidad) ===");
        List<String> lineas = CSVLoader.cargarLineas("pacientes_500.csv");
        if (!lineas.isEmpty()) lineas.remove(0);

        Paciente[] arreglo = lineas.stream()
                .map(Paciente::fromCsv)
                .toArray(Paciente[]::new);

        correrTabla(arreglo);
    }

    // ---------------------------------------------------------
    // 4. Inventario inverso (inventario_500_inverso.csv)
    // ---------------------------------------------------------
    private static void probarInventario() {
        System.out.println("\n=== Inventario (Inverso) ===");
        List<String> lineas = CSVLoader.cargarLineas("inventario_500_inverso.csv");
        if (!lineas.isEmpty()) lineas.remove(0);

        Inventario[] arreglo = lineas.stream()
                .map(Inventario::fromCsv)
                .toArray(Inventario[]::new);

        correrTabla(arreglo);
    }

    // ---------------------------------------------------------
    // Tabla de comparación genérica
    // ---------------------------------------------------------
    private static void correrTabla(Comparable[] base) {
        System.out.println("Algoritmo   Comparisons   Swaps   Mediana(ns)");

        SortStats s1 = BenchmarkRunner.ejecutarConRepeticiones(base, "insertion");
        SortStats s2 = BenchmarkRunner.ejecutarConRepeticiones(base, "selection");
        SortStats s3 = BenchmarkRunner.ejecutarConRepeticiones(base, "bubble");

        System.out.printf("Insertion   %10d   %7d   %12d\n", s1.comparisons, s1.swaps, s1.timeNs);
        System.out.printf("Selection   %10d   %7d   %12d\n", s2.comparisons, s2.swaps, s2.timeNs);
        System.out.printf("Bubble      %10d   %7d   %12d\n", s3.comparisons, s3.swaps, s3.timeNs);
    }
}