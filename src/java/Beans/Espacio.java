/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class Espacio {

    private String id_espacio;
    private String es_zona;
    private String es_nombre;
    private String es_estado;

//Constructor

    public Espacio(String id_espacio, String es_zona, String es_nombre, String es_estado) {
        this.id_espacio = id_espacio;
        this.es_zona = es_zona;
        this.es_nombre = es_nombre;
        this.es_estado = es_estado;
    }

//Getter and Setter

    public String getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(String id_espacio) {
        this.id_espacio = id_espacio;
    }

    public String getEs_zona() {
        return es_zona;
    }

    public void setEs_zona(String es_zona) {
        this.es_zona = es_zona;
    }

    public String getEs_nombre() {
        return es_nombre;
    }

    public void setEs_nombre(String es_nombre) {
        this.es_nombre = es_nombre;
    }

    public String getEs_estado() {
        return es_estado;
    }

    public void setEs_estado(String es_estado) {
        this.es_estado = es_estado;
    }



}
