package com.calificaciones.testing;

public class Calificaciones {

    private static final double NOTA_MINIMA_APROBACION = 13;

    public double calcularPromedio(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }

    public boolean estaAprobado(double promedio) {
        return promedio >= NOTA_MINIMA_APROBACION;
    }
}
