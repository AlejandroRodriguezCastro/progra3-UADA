package MisionUada;

public class Decision {
    private Estacion origen;
    private Estacion destino;
    private Movimiento movimiento;
    private float bateria;
    private float tiempo;

    public Decision(Estacion origen, Estacion destino, Movimiento movimiento, float bateria, float tiempo) {
        this.origen = origen;
        this.destino = destino;
        this.movimiento = movimiento;
        this.bateria = bateria;
        this.tiempo = tiempo;
    }

    public Estacion getOrigen() { return origen; }
    public Estacion getDestino() { return destino; }
    public Movimiento getMovimiento() { return movimiento; }
    public float getBateria() { return bateria; }
    public float getTiempo() { return tiempo; }
}
