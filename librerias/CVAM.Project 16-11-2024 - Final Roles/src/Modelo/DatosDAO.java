package Modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DatosDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() throws SQLException {
        List<Datos> datos = new ArrayList<>();
        String sql = "select * from datos";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from datos");
            rs = ps.executeQuery();
            while (rs.next()) {
                Datos d = new Datos();
                d.setId(rs.getInt(1));
                d.setSede(rs.getString(2));
                d.setPnf(rs.getString(3));
                d.setTrayecto(rs.getString(4));
                d.setSeccion(rs.getString(5));
                d.setTproyecto(rs.getString(6));
                d.setTxtnom(rs.getString(7));
                d.setFdpresentacion(rs.getString(8));
                d.setProfesor(rs.getString(9));
                d.setUrl(rs.getString(10));
                datos.add(d);
            }
        } catch (SQLException e) {

        }
        return datos;
    }

    
    public int agregar(Datos d) {
        String sql = "INSERT INTO datos(sede, pnf, trayecto, seccion, tproyecto, txtnom, fdpresentacion, profesor, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = conectar.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d.getSede());
            ps.setString(2, d.getPnf());
            ps.setString(3, d.getTrayecto());
            ps.setString(4, d.getSeccion());
            ps.setString(5, d.getTproyecto());
            ps.setString(6, d.getTxtnom());
            ps.setString(7, d.getFdpresentacion());
            ps.setString(8, d.getProfesor());
            ps.setString(9, d.getUrl());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return 1;
    }

    public void delete(int id) {
        String deleteSql = "DELETE FROM datos WHERE id = ?";
        try {
            con = conectar.getConnection();

            // Eliminar el registro con el ID proporcionado
            ps = con.prepareStatement(deleteSql);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Obtener el máximo ID actual
            String getMaxIdSql = "SELECT MAX(id) FROM datos";
            ps = con.prepareStatement(getMaxIdSql);
            ResultSet rs = ps.executeQuery();
            int maxId = rs.next() ? rs.getInt(1) : 0;

            // Actualizar los valores de identificación posteriores
            String updateSql = "UPDATE datos SET id = id - 1 WHERE id > ?";
            ps = con.prepareStatement(updateSql);
            for (int i = id + 1; i <= maxId; i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }

            // Reiniciar la secuencia de identificación
            String resetSequenceSql = "ALTER TABLE datos AUTO_INCREMENT = ?";
            ps = con.prepareStatement(resetSequenceSql);
            ps.setInt(1, maxId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
