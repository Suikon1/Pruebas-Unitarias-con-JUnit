package com.ejemplo;

public class DescuentoRepository {
    
    public double obtenerPorcentaje(String codigo) {
        // Simula consulta a base de datos
        if ("PROMO10".equals(codigo)) {
            return 0.10; // 10% descuento
        } else if ("PROMO20".equals(codigo)) {
            return 0.20; // 20% descuento
        } else if ("VIP".equals(codigo)) {
            return 0.15; // 15% descuento
        }
        return 0.0; // Sin descuento
    }
}