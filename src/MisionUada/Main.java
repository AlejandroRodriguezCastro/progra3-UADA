package MisionUada;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // PASO 1: Crear las estaciones
        Estacion estacion1 = new Estacion("Aula 603", 603, false);
        Estacion estacion2 = new Estacion("Aula 101", 101, true);
        Estacion estacion3 = new Estacion("Biblioteca", 3, false);
        Estacion estacion4 = new Estacion("Aula 202", 202, true);
        Estacion estacion5 = new Estacion("Cafetería", 5, false);
        Estacion estacion6 = new Estacion("Aula 304", 304, true);
        Estacion estacion7 = new Estacion("Laboratorio", 7, false);
        Estacion estacion8 = new Estacion("Aula 405", 405, true);
        Estacion estacion9 = new Estacion("Gimnasio", 9, false);
        Estacion estacion10 = new Estacion("Enfermería", 10, false);
        Estacion estacion11 = new Estacion("Aula 506", 506, true);
        Estacion estacion12 = new Estacion("Centro de Cómputo", 12, false);
        Estacion estacion13 = new Estacion("Aula 607", 607, true);
        Estacion estacion14 = new Estacion("Auditorio", 14, false);
        Estacion estacion15 = new Estacion("Aula 708", 708, true);
        Estacion estacion16 = new Estacion("Piscina", 16, false);
        Estacion estacion17 = new Estacion("Aula 809", 809, true);
        Estacion estacion18 = new Estacion("Parque", 18, false);
        Estacion estacion19 = new Estacion("Aula 910", 910, true);
        Estacion estacion20 = new Estacion("Oficina", 20, false);

        // PASO 2: Crear los desplazamientos
        List<Movimiento> mov1 = Arrays.asList(Movimiento.CAMINAR, Movimiento.SALTAR);
        List<Movimiento> mov2 = Arrays.asList(Movimiento.CAMINAR, Movimiento.PATAS_PARA_ARRIBA);
        List<Movimiento> mov3 = Arrays.asList(Movimiento.SALTAR, Movimiento.PATAS_PARA_ARRIBA);

        List<Desplazamiento> desplazamientos = Arrays.asList(
                new Desplazamiento(estacion1, estacion2, 500.0f, mov1),
                new Desplazamiento(estacion1, estacion3, 400.0f, mov2),
                new Desplazamiento(estacion1, estacion5, 600.0f, mov3),
                new Desplazamiento(estacion1, estacion7, 550.0f, mov1),
                new Desplazamiento(estacion1, estacion9, 700.0f, mov2),
                new Desplazamiento(estacion1, estacion12, 650.0f, mov3),
                new Desplazamiento(estacion1, estacion16, 800.0f, mov1),
                new Desplazamiento(estacion2, estacion3, 700.0f, mov1),
                new Desplazamiento(estacion2, estacion4, 800.0f, mov2),
                new Desplazamiento(estacion2, estacion5, 900.0f, mov3),
                new Desplazamiento(estacion2, estacion6, 650.0f, mov1),
                new Desplazamiento(estacion2, estacion10, 750.0f, mov2),
                new Desplazamiento(estacion2, estacion11, 600.0f, mov3),
                new Desplazamiento(estacion2, estacion20, 1000.0f, mov1),
                new Desplazamiento(estacion3, estacion1, 400.0f, mov1),
                new Desplazamiento(estacion3, estacion2, 700.0f, mov2),
                new Desplazamiento(estacion3, estacion4, 600.0f, mov3),
                new Desplazamiento(estacion3, estacion5, 500.0f, mov1),
                new Desplazamiento(estacion3, estacion8, 850.0f, mov2),
                new Desplazamiento(estacion3, estacion14, 750.0f, mov3),
                new Desplazamiento(estacion3, estacion18, 900.0f, mov1),
                new Desplazamiento(estacion4, estacion1, 1000.0f, mov2),
                new Desplazamiento(estacion4, estacion2, 800.0f, mov1),
                new Desplazamiento(estacion4, estacion3, 600.0f, mov3),
                new Desplazamiento(estacion4, estacion5, 700.0f, mov2),
                new Desplazamiento(estacion4, estacion7, 750.0f, mov1),
                new Desplazamiento(estacion4, estacion13, 900.0f, mov3),
                new Desplazamiento(estacion4, estacion17, 950.0f, mov2),
                new Desplazamiento(estacion5, estacion1, 600.0f, mov3),
                new Desplazamiento(estacion5, estacion2, 900.0f, mov1),
                new Desplazamiento(estacion5, estacion3, 500.0f, mov2),
                new Desplazamiento(estacion5, estacion4, 700.0f, mov1),
                new Desplazamiento(estacion5, estacion6, 550.0f, mov3),
                new Desplazamiento(estacion5, estacion12, 650.0f, mov2),
                new Desplazamiento(estacion5, estacion19, 1100.0f, mov1),
                new Desplazamiento(estacion6, estacion2, 650.0f, mov1),
                new Desplazamiento(estacion6, estacion8, 800.0f, mov2),
                new Desplazamiento(estacion6, estacion11, 700.0f, mov3),
                new Desplazamiento(estacion6, estacion15, 950.0f, mov1),
                new Desplazamiento(estacion6, estacion20, 850.0f, mov2),
                new Desplazamiento(estacion7, estacion1, 550.0f, mov1),
                new Desplazamiento(estacion7, estacion9, 450.0f, mov3),
                new Desplazamiento(estacion7, estacion12, 500.0f, mov2),
                new Desplazamiento(estacion7, estacion16, 700.0f, mov1),
                new Desplazamiento(estacion8, estacion4, 800.0f, mov2),
                new Desplazamiento(estacion8, estacion6, 800.0f, mov1),
                new Desplazamiento(estacion8, estacion13, 650.0f, mov3),
                new Desplazamiento(estacion8, estacion17, 900.0f, mov2),
                new Desplazamiento(estacion9, estacion1, 700.0f, mov2),
                new Desplazamiento(estacion9, estacion7, 450.0f, mov1),
                new Desplazamiento(estacion9, estacion10, 300.0f, mov3),
                new Desplazamiento(estacion9, estacion18, 600.0f, mov1),
                new Desplazamiento(estacion10, estacion2, 750.0f, mov1),
                new Desplazamiento(estacion10, estacion9, 300.0f, mov2),
                new Desplazamiento(estacion10, estacion20, 500.0f, mov3),
                new Desplazamiento(estacion11, estacion6, 700.0f, mov3),
                new Desplazamiento(estacion11, estacion15, 800.0f, mov1),
                new Desplazamiento(estacion11, estacion19, 950.0f, mov2),
                new Desplazamiento(estacion12, estacion3, 650.0f, mov2),
                new Desplazamiento(estacion12, estacion7, 500.0f, mov1),
                new Desplazamiento(estacion12, estacion16, 550.0f, mov3),
                new Desplazamiento(estacion13, estacion4, 900.0f, mov3),
                new Desplazamiento(estacion13, estacion8, 650.0f, mov2),
                new Desplazamiento(estacion13, estacion17, 700.0f, mov1),
                new Desplazamiento(estacion14, estacion3, 750.0f, mov1),
                new Desplazamiento(estacion14, estacion12, 600.0f, mov2),
                new Desplazamiento(estacion14, estacion18, 500.0f, mov3),
                new Desplazamiento(estacion15, estacion6, 950.0f, mov3),
                new Desplazamiento(estacion15, estacion11, 800.0f, mov1),
                new Desplazamiento(estacion15, estacion19, 850.0f, mov2),
                new Desplazamiento(estacion16, estacion1, 800.0f, mov1),
                new Desplazamiento(estacion16, estacion7, 700.0f, mov2),
                new Desplazamiento(estacion16, estacion12, 550.0f, mov3),
                new Desplazamiento(estacion17, estacion4, 950.0f, mov2),
                new Desplazamiento(estacion17, estacion8, 900.0f, mov1),
                new Desplazamiento(estacion17, estacion13, 700.0f, mov3),
                new Desplazamiento(estacion18, estacion3, 900.0f, mov3),
                new Desplazamiento(estacion18, estacion9, 600.0f, mov2),
                new Desplazamiento(estacion18, estacion14, 500.0f, mov1),
                new Desplazamiento(estacion19, estacion5, 1100.0f, mov1),
                new Desplazamiento(estacion19, estacion11, 950.0f, mov3),
                new Desplazamiento(estacion19, estacion15, 850.0f, mov2),
                new Desplazamiento(estacion20, estacion2, 1000.0f, mov2),
                new Desplazamiento(estacion20, estacion6, 850.0f, mov3),
                new Desplazamiento(estacion20, estacion10, 500.0f, mov1)
        );

        List<Estacion> lugaresObligatorios = Arrays.asList(
                estacion2, estacion4, estacion6, estacion8, estacion11, estacion13,
                estacion15, estacion17, estacion19, estacion1, estacion3, estacion5, estacion7, estacion9
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
