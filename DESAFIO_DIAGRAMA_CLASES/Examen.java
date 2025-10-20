package DESAFIO_DIAGRAMA_CLASES;

public class Examen {
    private int numero;
    private int puntaje;

    public Examen(int numero, int puntaje) {
        this.numero = numero;
        this.puntaje = puntaje;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
