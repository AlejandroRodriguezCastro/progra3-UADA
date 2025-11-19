package MisionUada;

import java.util.*;

public class BacktrackingSolver {

    public List<Decision> encontrarRecorridoUADA(
            Estacion estacionOrigen,
            float bateriaInicial,
            List<Estacion> lugaresObligatorios,
            List<Desplazamiento> desplazamientos) {

        Set<Estacion> visitados = new HashSet<>();
        visitados.add(estacionOrigen);

        List<Estacion> obligatoriosActual = copiaEstaciones(lugaresObligatorios);
        if (obligatoriosActual.contains(estacionOrigen)) {
            obligatoriosActual.remove(estacionOrigen);
        }

        List<Decision> rutaActual = new ArrayList<>();
        float[] mejorTiempo = {Float.POSITIVE_INFINITY};
        List<Decision> mejorRuta = new ArrayList<>();

        mejorRuta = backtracking(
                estacionOrigen,
                estacionOrigen,
                bateriaInicial,
                0,
                visitados,
                rutaActual,
                obligatoriosActual,
                mejorTiempo,
                mejorRuta,
                desplazamientos);

        return mejorRuta;
    }

    private List<Decision> backtracking(
            Estacion estacionActual,
            Estacion estacionOrigen,
            float bateriaActual,
            float tiempoActual,
            Set<Estacion> visitados,
            List<Decision> rutaActual,
            List<Estacion> obligatoriosActual,
            float[] mejorTiempo,
            List<Decision> mejorRuta,
            List<Desplazamiento> desplazamientos) {

        // Limitar profundidad para evitar StackOverflow
        if (rutaActual.size() > 50) {
            return mejorRuta;
        }

        // Condición de éxito
        if (estacionActual.equals(estacionOrigen) && obligatoriosActual.isEmpty() && !rutaActual.isEmpty()) {
            if (tiempoActual < mejorTiempo[0]) {
                mejorTiempo[0] = tiempoActual;
                mejorRuta = copiaDecisiones(rutaActual);
            }
            return mejorRuta;
        }

        for (Desplazamiento d : desplazamientos) {
            if (d.getOrigen().equals(estacionActual)) {
                Estacion destino = d.getDestino();

                // Evitar revisitar estaciones excepto el punto de partida
                if (visitados.contains(destino) && !destino.equals(estacionOrigen)) {
                    continue;
                }

                for (Movimiento mov : d.getMovimientosPermitidos()) {
                    float tiempoMovimiento = calcularTiempo(d.getTiempoBase(), mov);
                    float nuevoTiempo = tiempoActual + tiempoMovimiento;

                    // Poda: si ya superamos el mejor tiempo, no explorar
                    if (nuevoTiempo >= mejorTiempo[0]) {
                        continue;
                    }

                    float consumo = calcularConsumo(d.getTiempoBase(), mov);
                    float nuevaBateria = bateriaActual - consumo;

                    if (nuevaBateria <= 0) {
                        continue;
                    }

                    Estacion elementoRemovido = null;
                    int indiceRemovido = -1;

                    if (obligatoriosActual.contains(destino)) {
                        indiceRemovido = obligatoriosActual.indexOf(destino);
                        elementoRemovido = obligatoriosActual.remove(indiceRemovido);
                    }

                    if (destino.esAula()) {
                        float recarga = calcularRecarga(destino);
                        nuevaBateria += recarga;
                        // Limitar batería a máximo 100
                        if (nuevaBateria > 100) {
                            nuevaBateria = 100;
                        }
                    }

                    Decision decision = new Decision(estacionActual, destino, mov, nuevaBateria, nuevoTiempo);
                    rutaActual.add(decision);

                    Set<Estacion> nuevosVisitados = new HashSet<>(visitados);
                    nuevosVisitados.add(destino);

                    mejorRuta = backtracking(
                            destino,
                            estacionOrigen,
                            nuevaBateria,
                            nuevoTiempo,
                            nuevosVisitados,
                            rutaActual,
                            obligatoriosActual,
                            mejorTiempo,
                            mejorRuta,
                            desplazamientos);

                    if (elementoRemovido != null) {
                        obligatoriosActual.add(indiceRemovido, elementoRemovido);
                    }

                    rutaActual.remove(rutaActual.size() - 1);
                }
            }
        }

        return mejorRuta;
    }

    private List<Decision> copiaDecisiones(List<Decision> lista) {
        return new ArrayList<>(lista);
    }

    private List<Estacion> copiaEstaciones(List<Estacion> lista) {
        return new ArrayList<>(lista);
    }

    private float calcularRecarga(Estacion aula) {
        int numero = aula.getIdentificadorNumerico();
        int suma = 0;

        while (numero > 0) {
            int digito = numero % 10;
            suma += digito;
            numero /= 10;
        }

        return suma / 5.0f;
    }

    private float calcularTiempo(float tiempoBase, Movimiento movimiento) {
        switch (movimiento) {
            case CAMINAR:
                return tiempoBase;
            case SALTAR:
                return tiempoBase / 2;
            case PATAS_PARA_ARRIBA:
                return tiempoBase * 2;
            default:
                return tiempoBase;
        }
    }

    private float calcularConsumo(float tiempoBase, Movimiento movimiento) {
        float consumoCaminar = tiempoBase / 60;

        switch (movimiento) {
            case CAMINAR:
                return consumoCaminar;
            case SALTAR:
                return consumoCaminar * 2.2f;
            case PATAS_PARA_ARRIBA:
                return consumoCaminar * 0.45f;
            default:
                return consumoCaminar;
        }
    }
}
