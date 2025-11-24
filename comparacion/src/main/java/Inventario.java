public class Inventario implements Comparable<Inventario> {
    public final String id;
    public final String insumo;
    public final int stock;

    public Inventario(String id, String insumo, int stock) {
        this.id = id;
        this.insumo = insumo;
        this.stock = stock;
    }

    public static Inventario fromCsv(String linea) {
        String[] p = linea.split(";");
        return new Inventario(p[0].trim(), p[1].trim(), Integer.parseInt(p[2].trim()));
    }

    // CORRECCIÓN CLAVE: Ordenar por STOCK (numérico)
    @Override
    public int compareTo(Inventario o) {
        return Integer.compare(this.stock, o.stock);
    }

    @Override
    public String toString() {
        return insumo + " [" + stock + "]";
    }
}