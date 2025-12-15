package com.example.paginawebjava.modelo;

public class Producto {

    // ----------------------------------------------------
    // Atributos de Entrada (Inputs del Usuario)
    // ----------------------------------------------------
    private int antiguedadAnios;
    private double calidadMaterial; // Usamos double por si se quiere usar 7.5, por ejemplo
    private double precioBaseInicial;

    // ----------------------------------------------------
    // Atributo de Salida (Output del Servicio)
    // ----------------------------------------------------
    private double precioPredicho;

    // ----------------------------------------------------
    // Constructor (Opcional, pero útil)
    // ----------------------------------------------------

    public Producto () {
    }

    // ----------------------------------------------------
    // Getters y Setters (¡Imprescindibles para Spring Boot y Thymeleaf!)
    // ----------------------------------------------------

    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }

    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }

    public double getCalidadMaterial() {
        return calidadMaterial;
    }

    public void setCalidadMaterial(double calidadMaterial) {
        this.calidadMaterial = calidadMaterial;
    }

    public double getPrecioBaseInicial() {
        return precioBaseInicial;
    }

    public void setPrecioBaseInicial(double precioBaseInicial) {
        this.precioBaseInicial = precioBaseInicial;
    }

    public double getPrecioPredicho() {
        return precioPredicho;
    }

    public void setPrecioPredicho(double precioPredicho) {
        this.precioPredicho = precioPredicho;
    }
}
