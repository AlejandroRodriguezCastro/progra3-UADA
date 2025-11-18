package MisionUada;

public class Estacion {
    private String nombre;
    private int identificadorNumerico;
    private boolean esAula;

    public Estacion(String nombre, int identificadorNumerico, boolean esAula) {
        this.nombre = nombre;
        this.identificadorNumerico = identificadorNumerico;
        this.esAula = esAula;
    }

    public String getNombre() { return nombre; }
    public int getIdentificadorNumerico() { return identificadorNumerico; }
    public boolean esAula() { return esAula; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estacion estacion = (Estacion) o;
        return nombre.equals(estacion.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
