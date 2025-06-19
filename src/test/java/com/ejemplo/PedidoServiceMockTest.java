package com.ejemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceMockTest {

    @Mock
    private DescuentoRepository mockRepository;

    @InjectMocks
    private PedidoService service;

    @Test
    @DisplayName("Probar con mock - código PROMO10")
    void testConMockDescuentoPromo10() {
        // Arrange: Configurar el mock para devolver 10% de descuento para "PROMO10"
        when(mockRepository.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

        // Act: Calcular el total con monto 100.0, código "PROMO10" y envío premium (true)
        double total = service.calcularTotal(100.0, "PROMO10", true);

        // Assert: Verificar que el total sea 110.0
        // Cálculo: 100 - (100 * 0.10) + 20 = 90 + 20 = 110
        assertEquals(110.0, total, 0.01);

        // Verificar que se llamó al método obtenerPorcentaje con "PROMO10"
        verify(mockRepository).obtenerPorcentaje("PROMO10");
    }

    @Test
    @DisplayName("Probar con mock - código inexistente")
    void testConMockCodigoInexistente() {
        // Arrange: Configurar el mock para devolver 0% de descuento para "INEXISTENTE"
        when(mockRepository.obtenerPorcentaje("INEXISTENTE")).thenReturn(0.0);

        // Act: Calcular el total con monto 100.0, código "INEXISTENTE" y envío estándar (false)
        double total = service.calcularTotal(100.0, "INEXISTENTE", false);

        // Assert: Verificar que el total sea 110.0
        // Cálculo: 100 - (100 * 0.0) + 10 = 100 + 10 = 110
        assertEquals(110.0, total, 0.01);

        // Verificar que se llamó al método obtenerPorcentaje con "INEXISTENTE"
        verify(mockRepository).obtenerPorcentaje("INEXISTENTE");
    }

    @Test
    @DisplayName("Probar con mock - descuento VIP")
    void testConMockDescuentoVip() {
        // Arrange: Configurar el mock para devolver 15% de descuento para "VIP"
        when(mockRepository.obtenerPorcentaje("VIP")).thenReturn(0.15);

        // Act: Calcular el total con monto 200.0, código "VIP" y envío premium (true)
        double total = service.calcularTotal(200.0, "VIP", true);

        // Assert: Verificar que el total sea 190.0
        // Cálculo: 200 - (200 * 0.15) + 20 = 170 + 20 = 190
        assertEquals(190.0, total, 0.01);

        // Verificar que se llamó al método obtenerPorcentaje con "VIP"
        verify(mockRepository).obtenerPorcentaje("VIP");
    }
}