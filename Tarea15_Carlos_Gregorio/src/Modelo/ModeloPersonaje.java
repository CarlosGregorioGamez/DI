/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class ModeloPersonaje {
    
    
    private String nombrePersonaje;
    private int nivel;
    private String clase;
    private int id_campaña;

    public ModeloPersonaje(String nombrePersonaje, int nivel, String clase, int id_campaña) {
        this.nombrePersonaje = nombrePersonaje;
        this.nivel = nivel;
        this.clase = clase;
        this.id_campaña = id_campaña;
    }

    public ModeloPersonaje() {
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getId_campaña() {
        return id_campaña;
    }

    public void setId_campaña(int id_campaña) {
        this.id_campaña = id_campaña;
    }

    @Override
    public String toString() {
        return "ModeloCampana{" + "nombrePersonaje=" + nombrePersonaje + ", nivel=" + nivel + ", clase=" + clase + ", id_campa\u00f1a=" + id_campaña + '}';
    }

    
}
