public class Paciente implements Comparable<Paciente> {
    public final String id;
    public final String apellido;
    public final int prioridad;

    public Paciente(String id, String apellido, int prioridad) {
        this.id = id;
        this.apellido = apellido;
        this.prioridad = prioridad;
    }

    public static Paciente fromCsv(String linea) {
        String[] p = linea.split(";");
        return new Paciente(p[0].trim(), p[1].trim(), Integer.parseInt(p[2].trim()));
    }

    // CORRECCIÓN CLAVE: Ordenar por APELLIDO para probar estabilidad
    @Override
    public int compareTo(Paciente o) {
        return this.apellido.compareTo(o.apellido);
    }

    @Override
    public String toString() {
        return id + " " + apellido;
    }
}