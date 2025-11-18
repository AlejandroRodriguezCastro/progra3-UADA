package MisionUada;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // PASO 1: Crear las estaciones
        Estacion estacion1 = new Estacion("Aula 603", 603, false);
        Estacion estacion2 = new Estacion("Aula 101", 101, true);
        Estacion estacion3 = new Estacion("Aula 202", 202, true);
        Estacion estacion4 = new Estacion("Biblioteca", 4, false);
        Estacion estacion5 = new Estacion("Cafetería", 5, false);
        Estacion estacion6 = new Estacion("Aula 303", 303, true);
        Estacion estacion7 = new Estacion("Laboratorio", 7, false);
        Estacion estacion8 = new Estacion("Aula 404", 404, true);
        Estacion estacion9 = new Estacion("Aula 105", 105, true);
        Estacion estacion10 = new Estacion("Gimnasio", 10, false);
        Estacion estacion11 = new Estacion("Aula 501", 501, true);
        Estacion estacion12 = new Estacion("Centro de Cómputo", 12, false);
        Estacion estacion13 = new Estacion("Aula 602", 602, true);
        Estacion estacion14 = new Estacion("Enfermería", 14, false);
        Estacion estacion15 = new Estacion("Aula 703", 703, true);

        // PASO 2: Crear los desplazamientos
        List<Movimiento> mov1 = Arrays.asList(Movimiento.CAMINAR, Movimiento.SALTAR);
        List<Movimiento> mov2 = Arrays.asList(Movimiento.CAMINAR, Movimiento.PATAS_PARA_ARRIBA);
        List<Movimiento> mov3 = Arrays.asList(Movimiento.SALTAR, Movimiento.PATAS_PARA_ARRIBA);

        List<Desplazamiento> desplazamientos = Arrays.asList(
                new Desplazamiento(estacion1, estacion2, 60.0f, mov1),
                new Desplazamiento(estacion1, estacion4, 80.0f, mov1),
                new Desplazamiento(estacion1, estacion7, 120.0f, mov2),
                new Desplazamiento(estacion2, estacion3, 150.0f, mov2),
                new Desplazamiento(estacion2, estacion6, 180.0f, mov1),
                new Desplazamiento(estacion2, estacion9, 90.0f, mov3),
                new Desplazamiento(estacion3, estacion4, 120.0f, mov1),
                new Desplazamiento(estacion3, estacion11, 200.0f, mov2),
                new Desplazamiento(estacion3, estacion15, 104.0f, mov3),
                new Desplazamiento(estacion4, estacion5, 80.0f, mov1),
                new Desplazamiento(estacion4, estacion12, 100.0f, mov2),
                new Desplazamiento(estacion4, estacion14, 90.0f, mov1),
                new Desplazamiento(estacion5, estacion6, 100.0f, mov2),
                new Desplazamiento(estacion5, estacion10, 101.0f, mov1),
                new Desplazamiento(estacion6, estacion7, 90.0f, mov1),
                new Desplazamiento(estacion6, estacion8, 104.0f, mov3),
                new Desplazamiento(estacion6, estacion13, 101.0f, mov1),
                new Desplazamiento(estacion7, estacion12, 70.0f, mov1),
                new Desplazamiento(estacion8, estacion9, 101.0f, mov2),
                new Desplazamiento(estacion8, estacion1, 106.0f, mov1),
                new Desplazamiento(estacion9, estacion2, 90.0f, mov1),
                new Desplazamiento(estacion10, estacion5, 110.0f, mov2),
                new Desplazamiento(estacion10, estacion1, 130.0f, mov1),
                new Desplazamiento(estacion10, estacion14, 102.0f, mov3),
                new Desplazamiento(estacion11, estacion3, 200.0f, mov2),
                new Desplazamiento(estacion11, estacion6, 150.0f, mov1),
                new Desplazamiento(estacion11, estacion13, 170.0f, mov2),
                new Desplazamiento(estacion12, estacion4, 100.0f, mov2),
                new Desplazamiento(estacion12, estacion1, 1010.0f, mov1),
                new Desplazamiento(estacion13, estacion8, 120.0f, mov1),
                new Desplazamiento(estacion13, estacion11, 500.0f, mov3),
                new Desplazamiento(estacion14, estacion4, 200.0f, mov1),
                new Desplazamiento(estacion14, estacion10, 120.0f, mov3),
                new Desplazamiento(estacion15, estacion3, 140.0f, mov3),
                new Desplazamiento(estacion15, estacion11, 106.0f, mov1)
        );

        List<Estacion> lugaresObligatorios = Arrays.asList(
                estacion2, estacion4, estacion7, estacion8, estacion9, estacion10, estacion12, estacion14
        );

        BacktrackingSolver solver = new BacktrackingSolver();

        long tiempoInicio = System.nanoTime();

        List<Decision> mejorRuta = solver.encontrarRecorridoUADA(
                estacion1, 100.0f, lugaresObligatorios, desplazamientos
        );

        long tiempoFin = System.nanoTime();
        long tiempoEjecucion = tiempoFin - tiempoInicio;

        System.out.println("=== MEJOR RUTA ENCONTRADA ===");
        if (mejorRuta.isEmpty()) {
            System.out.println("No se encontró ruta válida");
        } else {
            float tiempoTotal = 0;
            float bateriaFinal = 0;

            for (int i = 0; i < mejorRuta.size(); i++) {
                Decision decision = mejorRuta.get(i);
                tiempoTotal = decision.getTiempo();
                bateriaFinal = decision.getBateria();

                System.out.println("Paso " + (i + 1) + ":");
                System.out.println("  De: " + decision.getOrigen().getNombre());
                System.out.println("  A: " + decision.getDestino().getNombre());
                System.out.println("  Movimiento: " + decision.getMovimiento());
                System.out.println("  Batería restante: " + decision.getBateria());
                System.out.println("  Tiempo acumulado: " + decision.getTiempo());
            }

            System.out.println("\n=== RESUMEN ===");
            System.out.println("Tiempo total de ruta: " + tiempoTotal);
            System.out.println("Batería final: " + bateriaFinal);
            System.out.println("Tiempo de ejecución: " + (tiempoEjecucion / 1_000_000.0) + " ms");
        }
    }
}
