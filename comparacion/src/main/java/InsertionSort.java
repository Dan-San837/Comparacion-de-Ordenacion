public class InsertionSort {
    public static void sort(Comparable[] a, SortStats s) {
        long start = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            Comparable key = a[i];
            int j = i - 1;

            // Usamos compareTo > 0
            while (j >= 0) {
                s.comparisons++;
                if (a[j].compareTo(key) > 0) {
                    a[j + 1] = a[j];
                    s.swaps++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }
        s.timeNs = System.nanoTime() - start;
    }
}