package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection con; // Cambia a una variable estática
    private final String b1l10ffmecjwwtmaooay = "usuarios";

    public static Connection getConnection() {
        if (con == null) {
            String url = "jdbc:mysql://b1l10ffmecjwwtmaooay-mysql.services.clever-cloud.com:3306/b1l10ffmecjwwtmaooay";
            String user = "ujivqmwrdfmglhba";
            String pass = "Ao5pol8H59Ue3Kg20B5M";

            try { 
              Class.forName("com.mysql.cj.jdbc.Driver"); // Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
