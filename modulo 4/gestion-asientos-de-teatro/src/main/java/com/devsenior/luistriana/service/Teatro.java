package com.devsenior.luistriana.service;

import com.devsenior.luistriana.exceptions.AsientoInvalidoException;
import com.devsenior.luistriana.exceptions.AsientoLibreException;
import com.devsenior.luistriana.exceptions.AsientoOcupadoException;
import com.devsenior.luistriana.model.Asiento;
import com.devsenior.luistriana.model.EstadoAsiento;

public class Teatro {
    private final int FILAS = 10;
    private final int COLUMNAS = 6;
    private Asiento[][] asientos;

    public Teatro() {
        asientos = new Asiento[FILAS][COLUMNAS];
        inicializarAsientos();
    }

    private void inicializarAsientos() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = new Asiento();
            }
        }
    }

    public EstadoAsiento[][] obtenerEstadoAsientos() {
        EstadoAsiento[][] estadoAsientos = new EstadoAsiento[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                estadoAsientos[i][j] = asientos[i][j].getEstado();
            }
        }
        return estadoAsientos;
    }

    public void reservarAsiento(int fila, int columna) throws AsientoInvalidoException, AsientoOcupadoException {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            throw new AsientoInvalidoException("Coordenadas fuera de rango. Seleccione una fila entre 0-" + (FILAS - 1)
                    + " y una columna entre 0-" + (COLUMNAS - 1) + ".");
        }
        if (!asientos[fila][columna].isLibre()) {
            throw new AsientoOcupadoException(
                    "El asiento en la fila " + fila + " y columna " + columna + " ya está ocupado.");
        }
        asientos[fila][columna].setEstado(EstadoAsiento.OCUPADO);
    }

    /**
     * Cancela la reserva de un asiento, cambiándolo a estado LIBRE.
     * Lanza excepciones si el asiento no es válido o ya está libre.
     */
    public void cancelarReserva(int fila, int columna) throws AsientoInvalidoException, AsientoLibreException {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            throw new AsientoInvalidoException("Coordenadas fuera de rango.");
        }
        if (asientos[fila][columna].isLibre()) {
            throw new AsientoLibreException(
                    "El asiento en la fila " + fila + " y columna " + columna + " ya está libre.");
        }
        asientos[fila][columna].setEstado(EstadoAsiento.LIBRE);
    }

    /**
     * Calcula y devuelve las estadísticas de ocupación del teatro.
     */
    public String calcularEstadisticas() {
        int ocupados = 0;
        int libres = 0;
        int totalAsientos = FILAS * COLUMNAS;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (asientos[i][j].isLibre()) {
                    libres++;
                } else {
                    ocupados++;
                }
            }
        }

        double porcentajeOcupacion = (double) ocupados / totalAsientos * 100;

        return String.format(
                "--- Estadísticas de Ocupación ---\n" +
                        "Asientos Ocupados: %d\n" +
                        "Asientos Libres: %d\n" +
                        "Porcentaje de Ocupación: %.2f%%\n" +
                        "---------------------------------",
                ocupados, libres, porcentajeOcupacion);
    }
}
