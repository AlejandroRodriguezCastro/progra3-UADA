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

        // PASO 2: Crear los desplazamientos aleatorios
        List<Movimiento> mov1 = Arrays.asList(Movimiento.CAMINAR, Movimiento.SALTAR);
        List<Movimiento> mov2 = Arrays.asList(Movimiento.CAMINAR, Movimiento.PATAS_PARA_ARRIBA);
        List<Movimiento> mov3 = Arrays.asList(Movimiento.SALTAR, Movimiento.PATAS_PARA_ARRIBA);

        List<Desplazamiento> desplazamientos = Arrays.asList(
                new Desplazamiento(estacion1, estacion2, 10.0f, mov1),
                new Desplazamiento(estacion1, estacion4, 8.0f, mov1),
                new Desplazamiento(estacion1, estacion7, 12.0f, mov2),
                new Desplazamiento(estacion2, estacion3, 15.0f, mov2),
                new Desplazamiento(estacion2, estacion6, 18.0f, mov1),
                new Desplazamiento(estacion2, estacion9, 9.0f, mov3),
                new Desplazamiento(estacion3, estacion4, 12.0f, mov1),
                new Desplazamiento(estacion3, estacion11, 20.0f, mov2),
                new Desplazamiento(estacion4, estacion5, 8.0f, mov1),
                new Desplazamiento(estacion4, estacion12, 10.0f, mov2),
                new Desplazamiento(estacion5, estacion6, 10.0f, mov2),
                new Desplazamiento(estacion5, estacion10, 11.0f, mov1),
                new Desplazamiento(estacion6, estacion7, 9.0f, mov1),
                new Desplazamiento(estacion6, estacion8, 14.0f, mov3),
                new Desplazamiento(estacion7, estacion12, 7.0f, mov1),
                new Desplazamiento(estacion8, estacion9, 11.0f, mov2),
                new Desplazamiento(estacion8, estacion1, 160.0f, mov1),
                new Desplazamiento(estacion9, estacion2, 9.0f, mov1),
                new Desplazamiento(estacion10, estacion5, 11.0f, mov2),
                new Desplazamiento(estacion10, estacion1, 13.0f, mov1),
                new Desplazamiento(estacion11, estacion3, 20.0f, mov2),
                new Desplazamiento(estacion11, estacion6, 15.0f, mov1),
                new Desplazamiento(estacion12, estacion4, 10.0f, mov2),
                new Desplazamiento(estacion12, estacion1, 11.0f, mov1)
        );

        List<Estacion> lugaresObligatorios = Arrays.asList(
                estacion2, estacion3, estacion6, estacion8, estacion9, estacion11
        );

        BacktrackingSolver solver = new BacktrackingSolver();

        List<Decision> mejorRuta = solver.encontrarRecorridoUADA(
                estacion1, 100.0f, lugaresObligatorios, desplazamientos
        );

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
            System.out.println("Tiempo total: " + tiempoTotal);
            System.out.println("Batería final: " + bateriaFinal);
        }
    }
}
