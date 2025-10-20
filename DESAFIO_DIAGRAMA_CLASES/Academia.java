package DESAFIO_DIAGRAMA_CLASES;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private String nombre;
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Academia(String nombre) {
        this.nombre = nombre;
    }

    public void addEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void calcularRanking() {
        Estudiante mejor = obtenerMejorPromedio();
        Estudiante masRegular = obtenerMasRegular();
        Estudiante peorTercera = obtenerPeorEnPrueba(3);

        if (mejor != null) {
            System.out.println("Mejor promedio: " + mejor.getNombre() + " -> " + mejor.calcularPromedio());
        }
        if (masRegular != null) {
            System.out.println("Más regular: " + masRegular.getNombre() + " -> diferencia max-min = " + masRegular.obtenerDiferenciaMaxMin());
        }
        if (peorTercera != null) {
            System.out.println("Peor en la prueba 3: " + peorTercera.getNombre() + " -> puntaje = " + obtenerPuntajeEnPrueba(peorTercera, 3));
        }
    }

    public Estudiante obtenerMejorPromedio() {
        Estudiante mejor = null;
        double mejorProm = -1;
        for (Estudiante s : estudiantes) {
            double p = s.calcularPromedio();
            if (p > mejorProm) {
                mejorProm = p;
                mejor = s;
            }
        }
        return mejor;
    }

    public Estudiante obtenerMasRegular() {
        Estudiante mejor = null;
        int menorDiferencia = Integer.MAX_VALUE;
        for (Estudiante s : estudiantes) {
            int dif = s.obtenerDiferenciaMaxMin();
            if (dif < menorDiferencia) {
                menorDiferencia = dif;
                mejor = s;
            }
        }
        return mejor;
    }

    public Estudiante obtenerPeorEnPrueba(int n) {
        Estudiante peor = null;
        int peorPuntaje = Integer.MAX_VALUE;
        for (Estudiante s : estudiantes) {
            int p = obtenerPuntajeEnPrueba(s, n);
            if (p >= 0 && p < peorPuntaje) {
                peorPuntaje = p;
                peor = s;
            }
        }
        return peor;
    }

    private int obtenerPuntajeEnPrueba(Estudiante s, int n) {
        int index = n - 1;
        if (index < 0 || index >= s.getExamenes().size()) return -1;
        return s.getExamenes().get(index).getPuntaje();
    }
}