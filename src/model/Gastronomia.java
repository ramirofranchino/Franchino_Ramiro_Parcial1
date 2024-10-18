/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {  
        if (enPromocion && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio * (1 - porcentajeDescuento / 100);
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Gastronomia [" + codServicio + ", " + "porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion
                + ", gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + "]";
    }
}
