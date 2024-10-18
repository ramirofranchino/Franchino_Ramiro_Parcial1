/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author Acer
 */
public class Test {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Sistema sistema2 = new Sistema();

        // Pruebas de Creación de Objetos
        System.out.println("1-1) Intentar crear el objeto Gastronomia con codServicio=4892");
        try {
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());  // Debería imprimir un mensaje de error
        }

        System.out.println("1-2) Crear el objeto Gastronomia con codServicio=489235");
        try {
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("Gastronomia creada exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-3) Intentar crear el objeto Hospedaje con codServicio=2872");
        try {
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());  // Debería imprimir un mensaje de error
        }

        System.out.println("1-4) Crear el objeto Hospedaje con codServicio=287282");
        try {
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Hospedaje creado exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Cálculo de Precios Finales
        System.out.println("2-1) Calcular e imprimir precio final del servicio Gastronomia");
        Servicio gastronomia = sistema.traerServicio("489235");
        if (gastronomia != null) {
            System.out.println("Precio final: " + gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
        }

        System.out.println("2-2) Calcular e imprimir precio final del servicio Hospedaje");
        Servicio hospedaje = sistema.traerServicio("287282");
        if (hospedaje != null) {
            System.out.println("Precio final: " + hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
        }

        // Agregar Servicios
        System.out.println("3) Agregar y listar servicios");
        try {
            sistema2.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema2.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema2.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema2.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Servicio s : sistema2.getServicios()) {
            System.out.println(s);
        }

        // Consultas de Servicios
        System.out.println("4-1) Traer todos los servicios en promoción");
        for (Servicio s : sistema2.traerServicio(true)) {
            System.out.println(s);
        }

        System.out.println("4-2) Traer todos los servicios del 2020-10-28 y en promoción");
        for (Servicio s : sistema2.traerServicio(true, LocalDate.of(2020, 10, 28))) {
            System.out.println(s);
        }
    }
}
