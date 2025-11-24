// Usamos esta clase tanto para "citas_100" como para "citas_casi_ordenadas"
// ya que tienen la misma estructura.
public class Cita implements Comparable<Cita> {
    public final String id;
    public final String apellido;
    public final String fechaHora;

    public Cita(String id, String apellido, String fechaHora) {
        this.id = id;
        this.apellido = apellido;
        this.fechaHora = fechaHora;
    }

    public static Cita fromCsv(String linea) {
        String[] p = linea.split(";");
        // p[0]=id, p[1]=apellido, p[2]=fechaHora
        return new Cita(p[0].trim(), p[1].trim(), p[2].trim());
    }

    // CORRECCIÓN CLAVE: Ordenar por FECHA, no por hash
    @Override
    public int compareTo(Cita o) {
        // Como es formato ISO 8601 (YYYY-MM-DD...), el orden alfabético es cronológico.
        return this.fechaHora.compareTo(o.fechaHora);
    }

    @Override
    public String toString() {
        return id + " (" + fechaHora + ")";
    }
}