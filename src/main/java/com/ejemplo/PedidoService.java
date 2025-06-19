package com.ejemplo;

public class PedidoService {
    
    private DescuentoRepository repository;
    
    public PedidoService(DescuentoRepository repository) {
        this.repository = repository;
    }
    
    // Constructor por defecto para mantener compatibilidad
    public PedidoService() {
        this.repository = new DescuentoRepository();
    }
    
    public double calcularTotal(double subtotal, String codigoDescuento, boolean envioExpress) {
        double porcentajeDescuento = repository.obtenerPorcentaje(codigoDescuento);
        double envio = envioExpress ? 20.0 : 10.0;
        
        return (subtotal * (1 - porcentajeDescuento)) + envio;
    }
    
    // Método legacy para mantener compatibilidad con pruebas anteriores
    public double calcularTotal(double subtotal, boolean aplicaDescuento, boolean envioExpress) {
        String codigo = aplicaDescuento ? "PROMO10" : "";
        return calcularTotal(subtotal, codigo, envioExpress);
    }
}