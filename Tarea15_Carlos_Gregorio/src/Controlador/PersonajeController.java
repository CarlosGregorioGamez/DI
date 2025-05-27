/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConnectionBD;
import Modelo.ModeloPersonaje;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class PersonajeController {

    ConnectionBD connection = new ConnectionBD();
    ModeloPersonaje modelo = new ModeloPersonaje();
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public PersonajeController() throws SQLException {
        connection.connection();
    }

    public void insertarPersonaje(ModeloPersonaje personaje) throws SQLException {
        String consulta = "insert into partidas (nombre, dificultad) values(?,?)";
        Statement statement = connection.getStatement();

        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, personaje.getNombrePersonaje());
        ps.setInt(2, personaje.getNivel());
        ps.setString(3, personaje.getClase());
        ps.setInt(4, personaje.getId_campaña());
        ps.execute();
    }

}
