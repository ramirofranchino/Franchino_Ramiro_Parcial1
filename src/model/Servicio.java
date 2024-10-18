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
public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        if(codServicio.length() != 6){
            throw new Exception("El codigo del servicio debe tener una longitud de 6 caracteres");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
    
    public abstract double calcularPrecioFinal(LocalDate dia);
    
    public String getCodServicio(){
        return codServicio;
    }
    
    public boolean isEnPromocion(){
        return enPromocion;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codServicio= " + codServicio + ", porcentajeDescuento= " + porcentajeDescuento + ", enPromocion= " + enPromocion + '}';
    }
    
    
}
