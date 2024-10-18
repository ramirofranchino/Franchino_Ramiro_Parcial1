/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {  
        if (enPromocion && dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY) {
            return precioPorNoche * (1 - porcentajeDescuento / 100);
        }
        return precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje [" + codServicio + ", " + "porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion
                + ", hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + "]";
    }
}
