/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                throw new Exception("El servicio ya existe.");
            }
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                throw new Exception("El servicio ya existe.");
            }
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) > 0) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Servicio> getServicios() {
        return lstServicio;
    }
}
