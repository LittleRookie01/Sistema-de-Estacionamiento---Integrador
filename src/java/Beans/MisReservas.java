/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class MisReservas {

    private String dni;
    private String placa;
    private String es_zona;
    private String h_entrada;
    private String h_salida;

//Constructor    
    public MisReservas(String dni, String placa, String es_zona, String h_entrada, String h_salida) {
        this.dni = dni;
        this.placa = placa;        
        this.es_zona = es_zona;
        this.h_entrada = h_entrada;
        this.h_salida = h_salida;
    }

//Getter and Setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEs_zona() {
        return es_zona;
    }

    public void setEs_zona(String es_zona) {
        this.es_zona = es_zona;
    }

    public String getH_entrada() {
        return h_entrada;
    }

    public void setH_entrada(String h_entrada) {
        this.h_entrada = h_entrada;
    }

    public String getH_salida() {
        return h_salida;
    }

    public void setH_salida(String h_salida) {
        this.h_salida = h_salida;
    }

}
