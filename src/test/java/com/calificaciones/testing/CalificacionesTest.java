package com.calificaciones.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalificacionesTest {

    private Calificaciones calificaciones;

    @BeforeEach
    void setUp() {
        calificaciones = new Calificaciones();
    }

    // ---------- 1. calcularPromedio() ----------

    @Test
    @DisplayName("Promedio de 15, 14, 16 -> 15")
    void calcularPromedio_notasAltas_retorna15() {
        assertEquals(15, calificaciones.calcularPromedio(15, 14, 16));
    }

    @Test
    @DisplayName("Promedio de 10, 12, 14 -> 12")
    void calcularPromedio_notasMedias_retorna12() {
        assertEquals(12, calificaciones.calcularPromedio(10, 12, 14));
    }

    @Test
    @DisplayName("Promedio de 20, 18, 16 -> 18")
    void calcularPromedio_notasMaximas_retorna18() {
        assertEquals(18, calificaciones.calcularPromedio(20, 18, 16));
    }

    // ---------- 2. estaAprobado() ----------

    @Test
    @DisplayName("Promedio 15 -> aprobado")
    void estaAprobado_promedio15_esTrue() {
        assertTrue(calificaciones.estaAprobado(15));
    }

    @Test
    @DisplayName("Promedio 13 (límite exacto) -> aprobado")
    void estaAprobado_promedio13_esTrue() {
        assertTrue(calificaciones.estaAprobado(13));
    }

    @Test
    @DisplayName("Promedio 12 -> desaprobado")
    void estaAprobado_promedio12_esFalse() {
        assertFalse(calificaciones.estaAprobado(12));
    }

    @Test
    @DisplayName("Promedio 05 -> desaprobado")
    void estaAprobado_promedio05_esFalse() {
        assertFalse(calificaciones.estaAprobado(5));
    }

    // ---------- 3. Reto: octavo caso de prueba ----------

    /*
     * Justificación: los 7 casos originales solo cubren números "redondos" o
     * exactamente en el límite (13). Falta un caso que pruebe el valor
     * inmediatamente DEBAJO del límite (12.99), que es un caso borde crítico
     * porque un error de tipo "off-by-one" o de redondeo en la comparación
     * (por ejemplo usar > en vez de >=) podría dar un resultado incorrecto
     * justo en esa frontera. También se combina con un promedio calculado
     * con decimales (14, 12, 13 -> 13.0 exacto) para validar que
     * calcularPromedio() maneja bien divisiones no triviales.
     */
    @Test
    @DisplayName("Caso borde: promedio 12.99 (justo debajo del límite) -> desaprobado")
    void estaAprobado_promedioJustoDebajoDelLimite_esFalse() {
        assertFalse(calificaciones.estaAprobado(12.99));
    }

    @Test
    @DisplayName("Promedio de 14, 12, 13 -> 13.0 (verifica división exacta con decimales)")
    void calcularPromedio_conDivisionExacta_retorna13() {
        assertEquals(13.0, calificaciones.calcularPromedio(14, 12, 13), 0.0001);
    }
}
