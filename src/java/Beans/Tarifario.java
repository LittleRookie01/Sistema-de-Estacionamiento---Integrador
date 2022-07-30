package Beans;

public class Tarifario {

private int id_tarifa;
private String cat_nombre;
private double tar_precio;

//Constructor

    public Tarifario(int id_tarifa, String cat_nombre, double tar_precio) {
        this.id_tarifa = id_tarifa;
        this.cat_nombre = cat_nombre;
        this.tar_precio = tar_precio;
    }



//Getter and Setter

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public double getTar_precio() {
        return tar_precio;
    }

    public void setTar_precio(double tar_precio) {
        this.tar_precio = tar_precio;
    }    
}
