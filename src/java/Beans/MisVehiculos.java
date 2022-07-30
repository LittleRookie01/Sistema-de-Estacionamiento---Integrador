/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class MisVehiculos {

    private String placa;
    private String dni;
    private String nombre;
    private String marca;
    private String categoria;
    private double precioH;

//Constructor

    public MisVehiculos(String placa, String dni, String nombre, String marca, String categoria, double precioH) {
        this.placa = placa;
        this.dni = dni;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precioH = precioH;
    }

//Getter And Setter
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioH() {
        return precioH;
    }

    public void setPrecioH(double precioH) {
        this.precioH = precioH;
    }

}
