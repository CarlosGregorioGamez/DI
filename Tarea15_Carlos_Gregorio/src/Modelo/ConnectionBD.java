/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author carlo
 */
public class ConnectionBD {
    
    Connection connection;
    Statement statement;
    public void connection() throws SQLException{
        String urlBD = "jdbc:mysql://localhost/dnd?user=root&password=abc123.";
        connection = DriverManager.getConnection(urlBD);
        statement = connection.createStatement();
    }
    
    public void closeConnection() throws SQLException{
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    
}
