package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // --- PARÁMETROS PARA XAMPP EN LOCALHOST ---
    // 1. URL: Apunta a tu propia máquina (localhost) en el puerto 3306.
    //    El nombre de la base de datos (mi_base_de_datos) debe ser el que creaste en phpMyAdmin.
    private static final String URL = "jdbc:mysql://localhost:3306/b1l10ffmecjwwtmaooay";

    // 2. USER: El usuario por defecto de MySQL en XAMPP es "root".
    private static final String USER = "root";

    // 3. PASS: La contraseña por defecto de MySQL en XAMPP está VACÍA.
    private static final String PASS = ""; // ¡Dejar en blanco!

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos local: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }
}