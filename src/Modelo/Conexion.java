package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private static final String URL = "jdbc:mysql://b1l10ffmecjwwtmaooay-mysql.services.clever-cloud.com:3306/b1l10ffmecjwwtmaooay";
    private static final String USER = "ujivqmwrdfmglhba";
    private static final String PASS = "Ao5pol8H59Ue3Kg20B5M";

     public static Connection getConnection() {
        Connection con = null; // 2. La conexión se declara como una variable local.

        try {
            // 3. Ya no se comprueba si la conexión es nula.
            // Siempre intentamos crear una nueva.
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException e) {
            // 4. Si algo sale mal, imprimimos un error claro y devolvemos null.
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        
        // 5. Devolvemos la conexión nueva (o null si falló).
        return con;
    }
}