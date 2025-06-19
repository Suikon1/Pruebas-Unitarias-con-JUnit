package com.ejemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
    
    private PedidoService service;
    
    @BeforeEach
    void setUp() {
        service = new PedidoService();
    }
    
    @Test
    @DisplayName("Calcular total sin descuento y envío normal")
    void testSinDescuentoYEnvioNormal() {
        // Arrange (Preparar)
        double subtotal = 100.0;
        
        // Act (Actuar)
        double total = service.calcularTotal(subtotal, false, false);
        
        // Assert (Verificar)
        assertEquals(110.0, total, 0.01);
    }
    
    @Test
    @DisplayName("Calcular total con descuento y envío express")
    void testConDescuentoYEnvioExpress() {
        // Arrange
        double subtotal = 100.0;
        
        // Act
        double total = service.calcularTotal(subtotal, true, true);
        
        // Assert
        assertEquals(110.0, total, 0.01); // 100 - 10% + 20 = 90 + 20 = 110
    }
    
    @Test
    @DisplayName("Calcular total con descuento y envío normal")
    void testConDescuentoYEnvioNormal() {
        // Arrange
        double subtotal = 200.0;
        
        // Act
        double total = service.calcularTotal(subtotal, true, false);
        
        // Assert
        assertEquals(190.0, total, 0.01); // 200 - 10% + 10 = 180 + 10 = 190
    }
    
    @Test
    @DisplayName("Calcular total sin descuento y envío express")
    void testSinDescuentoYEnvioExpress() {
        // Arrange
        double subtotal = 150.0;
        
        // Act
        double total = service.calcularTotal(subtotal, false, true);
        
        // Assert
        assertEquals(170.0, total, 0.01); // 150 + 20 = 170
    }
}