public class BubbleSort {
    // Recibe Comparable[] en lugar de int[]
    public static void sort(Comparable[] a, SortStats s) {
        long start = System.nanoTime();
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                s.comparisons++;
                // Usamos compareTo > 0 en lugar de >
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Comparable tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    s.swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        s.timeNs = System.nanoTime() - start;
    }
}