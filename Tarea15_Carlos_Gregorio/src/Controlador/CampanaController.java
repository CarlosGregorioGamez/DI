/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConnectionBD;
import Modelo.ModeloCampana;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class CampanaController {

    ConnectionBD connection = new ConnectionBD();
    ModeloCampana modelo = new ModeloCampana();
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public CampanaController() throws SQLException {
        connection.connection();

    }

    public void crearCampana(ModeloCampana campana) throws SQLException {
        String consulta = "insert into partidas (nombre, dificultad) values(?,?)";
        Statement statement = connection.getStatement();

        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, campana.getNombre());
        ps.setString(2, campana.getDificultad());
        ps.execute();
    }

    public DefaultTableModel verCampanas() throws SQLException {
        String consulta = "Select * from partidas";
        Statement statement = connection.getStatement();
        int id;
        String nombre;
        String dificultad;

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dificultad");

        ResultSet set = statement.executeQuery(consulta);

        while (set.next()) {
            id = set.getInt(1);
            nombre = set.getString(2);
            dificultad = set.getString(3);
            Object[] campana = new Object[]{id, nombre, dificultad};
            modeloTabla.addRow(campana);
        }
        return modeloTabla;
    }

    public void borrarCampana(String nombre) throws SQLException {
        String consulta = "Delete from partidas where nombre = ?";
        Statement statement = connection.getStatement();

        PreparedStatement ps = connection.getConnection().prepareStatement(consulta);
        ps.setString(1, nombre);
        ps.execute();
    }

    public ModeloCampana obtenerCampañaPorNombre(String nombreBuscado) throws SQLException {
        ConnectionBD conexionBD = new ConnectionBD();
        conexionBD.connection(); 
        Connection conn = conexionBD.getConnection();

        ModeloCampana campaña = null;

        String sql = "SELECT * FROM partidas WHERE nombre = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombreBuscado);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String dificultad = rs.getString("dificultad");

            campaña = new ModeloCampana(id, nombre, dificultad);
        }

        conexionBD.closeConnection(); 
        return campaña;
    }
    
    public void actualizarCampaña(String nombreViejo, ModeloCampana nuevaCampaña) throws SQLException {
    ConnectionBD conexionBD = new ConnectionBD();
    conexionBD.connection();
    Connection conn = conexionBD.getConnection();

    String sql = "UPDATE partidas SET nombre = ?, dificultad = ? WHERE nombre = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, nuevaCampaña.getNombre());
    ps.setString(2, nuevaCampaña.getDificultad());
    ps.setString(3, nombreViejo);

    ps.executeUpdate();
    conexionBD.closeConnection();
}

}
