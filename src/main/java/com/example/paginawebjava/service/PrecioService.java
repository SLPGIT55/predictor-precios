package com.example.paginawebjava.service;

import com.example.paginawebjava.modelo.Producto; // Importamos la clase Producto
import org.springframework.stereotype.Service;

@Service
public class PrecioService {

    /**
     * Aplica la fórmula o reglas de negocio para predecir el precio.
     * La lógica se basa en:
     * - Precio Base Inicial
     * - Ajuste por Calidad (factor positivo)
     * - Penalización por Antigüedad (factor negativo)
     */
    public Producto predecirPrecio(Producto producto) {

        double precioFinal = producto.getPrecioBaseInicial();

        // 1. Ajuste por Calidad (Fórmula: Calidad * 50)
        // (Asumimos que la calidad es una escala de 1 a 10)
        double ajusteCalidad = producto.getCalidadMaterial() * 50.0;
        precioFinal += ajusteCalidad;

        // 2. Penalización por Antigüedad (Fórmula: Antigüedad * 20 por año)
        double penalizacionAntiguedad = producto.getAntiguedadAnios() * 20.0;
        precioFinal -= penalizacionAntiguedad;

        // Opcional: Asegurarse de que el precio no es negativo (precio mínimo)
        if (precioFinal < 0) {
            precioFinal = 10.0; // Precio mínimo de 10
        }

        // 3. Guardar el resultado en el objeto Producto
        producto.setPrecioPredicho(precioFinal);

        return producto;
    }
}