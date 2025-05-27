/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class ModeloCampana {

    private int id;
    private String nombre;
    private String dificultad;

    public ModeloCampana(int id, String nombre, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.dificultad = dificultad;
    }
    
    public ModeloCampana(String nombre, String dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
    }

    public ModeloCampana() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModeloCampana{" + "nombre=" + nombre + ", dificultad=" + dificultad + '}';
    }
    
    
}
