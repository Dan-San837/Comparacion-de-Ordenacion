public class SelectionSort {
    public static void sort(Comparable[] a, SortStats s) {
        long start = System.nanoTime();
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                s.comparisons++;
                // Usamos compareTo
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                Comparable tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
                s.swaps++;
            }
        }
        s.timeNs = System.nanoTime() - start;
    }
}