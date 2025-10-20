package DESAFIO_DIAGRAMA_CLASES;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Examen> examenes = new ArrayList<>();

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void addExamen(Examen e) {
        examenes.add(e);
    }

    public double calcularPromedio() {
        if (examenes.isEmpty()) return 0.0;
        return (double) obtenerTotal() / examenes.size();
    }

    public int obtenerTotal() {
        int suma = 0;
        for (Examen e : examenes) suma += e.getPuntaje();
        return suma;
    }

    public int verificarAprobadas() {
        int contador = 0;
        for (Examen e : examenes) if (e.getPuntaje() >= 60) contador++;
        return contador;
    }

    public boolean esProgresivo() {
        if (examenes.size() < 2) return false;
        for (int i = 0; i < examenes.size() - 1; i++) {
            if (examenes.get(i).getPuntaje() >= examenes.get(i + 1).getPuntaje()) return false;
        }
        return true;
    }

    public int obtenerVariacionMax() {
        if (examenes.size() < 2) return 0;
        int maxVar = 0;
        for (int i = 0; i < examenes.size() - 1; i++) {
            int var = Math.abs(examenes.get(i + 1).getPuntaje() - examenes.get(i).getPuntaje());
            if (var > maxVar) maxVar = var;
        }
        return maxVar;
    }

    public int obtenerDiferenciaMaxMin() {
        if (examenes.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Examen e : examenes) {
            int p = e.getPuntaje();
            if (p > max) max = p;
            if (p < min) min = p;
        }
        return max - min;
    }
}