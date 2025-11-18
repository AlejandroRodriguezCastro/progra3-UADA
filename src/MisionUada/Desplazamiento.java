package MisionUada;

import java.util.List;

public class Desplazamiento {
    private Estacion origen;
    private Estacion destino;
    private float tiempoBase;
    private List<Movimiento> movimientosPermitidos;

    public Desplazamiento(Estacion origen, Estacion destino, float tiempoBase, List<Movimiento> movimientosPermitidos) {
        this.origen = origen;
        this.destino = destino;
        this.tiempoBase = tiempoBase;
        this.movimientosPermitidos = movimientosPermitidos;
    }

    public Estacion getOrigen() { return origen; }
    public Estacion getDestino() { return destino; }
    public float getTiempoBase() { return tiempoBase; }
    public List<Movimiento> getMovimientosPermitidos() { return movimientosPermitidos; }
}
