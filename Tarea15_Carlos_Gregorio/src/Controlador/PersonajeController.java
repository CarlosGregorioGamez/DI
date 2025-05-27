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
        String consulta = "insert into personajes (nombre, nivel, clase, id_campaña) values(?,?,?,?)";
        Statement statement = connection.getStatement();

        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, personaje.getNombrePersonaje());
        ps.setInt(2, personaje.getNivel());
        ps.setString(3, personaje.getClase());
        ps.setInt(4, personaje.getId_campana());
        ps.execute();
    }

    public DefaultTableModel verPersonajes() throws SQLException {
        String consulta = "SELECT * FROM personajes";
        Statement statement = connection.getStatement();
        int id;
        String nombre;
        int nivel;
        String clase;
        int idCampana;

        // Limpiar columnas previas si el modelo ya tiene columnas (opcional pero recomendable)
        if (modeloTabla.getColumnCount() == 0) {
            modeloTabla.addColumn("ID");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Nivel");
            modeloTabla.addColumn("Clase");
            modeloTabla.addColumn("ID Campaña");
        }

        ResultSet set = statement.executeQuery(consulta);

        while (set.next()) {
            id = set.getInt("id");
            nombre = set.getString("nombre");
            nivel = set.getInt("nivel");
            clase = set.getString("clase");
            idCampana = set.getInt("id_campaña");

            Object[] personaje = new Object[]{id, nombre, nivel, clase, idCampana};
            modeloTabla.addRow(personaje);
        }

        return modeloTabla;
    }

    public void borrarPersonaje(String nombre) throws SQLException {
        String consulta = "Delete from personajes where nombre = ?";
        Statement statement = connection.getStatement();

        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, nombre);
        ps.execute();
    }

    public ModeloPersonaje obtenerPersonajePorNombre(String nombreBuscar) throws SQLException {
        ModeloPersonaje personaje = null;

        String consulta = "SELECT * FROM personajes WHERE nombre = ?";
        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, nombreBuscar);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int nivel = rs.getInt("nivel");
            String clase = rs.getString("clase");
            int id_campana = rs.getInt("id_campaña");
            personaje = new ModeloPersonaje(id, nombre, nivel, clase, id_campana);
        }
        return personaje;
    }

    public void actualizarPersonaje(String nombreViejo, ModeloPersonaje personaje) throws SQLException {
    String consulta = "UPDATE personajes SET nombre = ?, nivel = ?, clase = ?, id_campaña = ? WHERE nombre = ?";
    PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
    ps.setString(1, personaje.getNombrePersonaje());
    ps.setInt(2, personaje.getNivel());
    ps.setString(3, personaje.getClase());
    ps.setInt(4, personaje.getId_campana());
    ps.setString(5, nombreViejo);
    ps.executeUpdate();
}

    public int obtenerIdCampañaPorNombre(String nombreCampaña) throws SQLException {
    String query = "SELECT id FROM partidas WHERE nombre = ?";
    PreparedStatement ps = connection.getConnection().prepareStatement(query);
    ps.setString(1, nombreCampaña);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        return rs.getInt("id");
    } else {
        throw new SQLException("Campaña no encontrada");
    }
}

}
