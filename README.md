
# Comparación de Algoritmos de Ordenamiento

Este proyecto implementa y compara el rendimiento de tres algoritmos de ordenamiento (Burbuja, Selección e Inserción) utilizando datasets generados con características específicas para analizar su comportamiento en diferentes escenarios.

## 📋Descripción del Proyecto
El objetivo principal es medir empíricamente el tiempo de ejecución (en nanosegundos), el número de comparaciones y los intercambios (swaps) realizados por cada algoritmo al ordenar listas (datasets) de objetos complejos (Citas, Pacientes, Inventario).

## Algoritmos Implementados
    1. Bubble Sort (Burbuja): compara pares vecinos y los intercambia si están mal; repite pasadas hasta dejar todo ordenado.
    2. Selection Sort (Selección): busca el mínimo en la parte no ordenada y lo coloca al frente en cada iteración.
    3. Insertion Sort (Inserción): toma cada elemento y lo desplaza hacia atrás hasta insertarlo donde mantiene el orden correcto.
Todas las implementaciones son genéricas, trabajando con ```Comparable[]``` para soportar cualquier tipo de objeto.

## 📂 Estructura del Proyecto

```bash
Comparacion/
├── src/main/java
│   ├── Main.java              # Punto de entrada. Ejecuta las pruebas.
│   ├── BenchmarkRunner.java   # Ejecuta cada algoritmo con repeticiones para mayor precisión.
│   ├── CSVLoader.java         # Carga los archivos CSV desde raíz, src o resources.
│   ├── SortStats.java         # Clase para guardar métricas (tiempo, swaps, comparaciones).
│   ├── BubbleSort.java        # Implementación de Burbuja.
│   ├── SelectionSort.java     # Implementación de Selección.
│   ├── InsertionSort.java     # Implementación de Inserción.
│   ├── Cita.java              # Modelo de datos para citas (comparable por Fecha).
│   ├── Paciente.java          # Modelo de datos para pacientes (comparable por Apellido).
│   └── Inventario.java        # Modelo de datos para inventario (comparable por Stock).
│
├── citas_100.csv              # Dataset 1: Aleatorio
├── citas_100_casi_ordenadas.csv # Dataset 2: Casi ordenado
├── pacientes_500.csv          # Dataset 3: Duplicados
└── inventario_500_inverso.csv # Dataset 4: Orden inverso
```

## 📊 Datasets Utilizados
Los archivos CSV fueron generados usando una semilla fija (42) para garantizar reproducibilidad.

1. citas_100.csv (Caso Promedio):
    - 100 registros con fechas y horas aleatorias.
    - Objetivo: Medir rendimiento en datos desordenados típicos.

2. citas_100_casi_ordenadas.csv (Mejor Caso para Inserción):
    - 100 registros ordenados cronológicamente con un 5% de perturbación (swaps).
    - Objetivo: Demostrar la eficiencia O(n) de Inserción en datos casi ordenados.

3. pacientes_500.csv (Prueba de Estabilidad):
    - 500 registros con alta repetición de apellidos.
    - Objetivo: Verificar cómo manejan los algoritmos elementos con claves iguales.

4. inventario_500_inverso.csv (Peor Caso):
    - 500 registros ordenados estrictamente de mayor a menor (Stock 500 a 1).
    - Objetivo: Evidenciar el peor caso O(n²) de Burbuja e Inserción.

## 🚀 Instrucciones de Ejecución
**Requisitos Previos**

- Java JDK: Versión 8 o superior (recomendado JDK 17 o 21).
- IDE: IntelliJ IDEA, Eclipse o Visual Studio Code (con Extension Pack for Java).

**Pasos para Ejecutar**

    1. Clona o descarga este repositorio.
    2. Asegúrate de que los 4 archivos .csv estén en la carpeta raíz del proyecto (al mismo nivel que la carpeta src).
    3. Abre el proyecto en tu IDE.
    4. Ejecuta el archivo src/Main.java.

**Salida Esperada**

El programa imprimirá en consola una tabla comparativa para cada dataset:

<img width="486" height="148" alt="Captura de pantalla 2025-11-23 153112" src="https://github.com/user-attachments/assets/a0ba7656-0b88-4fb9-b24e-b6bdf0143b1b" />



## 👤 Autores
**Estudiantes**: Daniel Saavedra, Emilio Galvez

**Asignatura**: Estructura de Datos

**Fecha**: Noviembre 2024
