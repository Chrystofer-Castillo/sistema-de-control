package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO (Data Access Object) para la entidad 'Datos'.
 * Esta clase contiene toda la lógica para interactuar (CRUD) con la tabla 'datos'
 * en la base de datos.
 */
public class DatosDAO {

    /**
     * Recupera todos los registros de la tabla 'datos'.
     * @return una Lista de objetos 'Datos'. La lista estará vacía si no hay datos o si ocurre un error.
     */
    public List<Datos> listar() {
        List<Datos> datos = new ArrayList<>();
        // 1. Especificar las columnas es más seguro y claro que "select *".
        String sql = "SELECT id, sede, pnf, trayecto, seccion, tproyecto, txtnom, fdpresentacion, profesor, url FROM datos";

        // 2. Usamos "try-with-resources", que cierra automáticamente la conexión y los statements. ¡Cero fugas!
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Datos d = new Datos();
                // 3. Usar nombres de columna es más robusto que usar índices numéricos.
                d.setId(rs.getInt("id"));
                d.setSede(rs.getString("sede"));
                d.setPnf(rs.getString("pnf"));
                d.setTrayecto(rs.getString("trayecto"));
                d.setSeccion(rs.getString("seccion"));
                d.setTproyecto(rs.getString("tproyecto"));
                d.setTxtnom(rs.getString("txtnom"));
                d.setFdpresentacion(rs.getString("fdpresentacion"));
                d.setProfesor(rs.getString("profesor"));
                d.setUrl(rs.getString("url"));
                datos.add(d);
            }
        } catch (SQLException e) {
            // 4. Si hay un error, lo registramos para poder depurar.
            Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, "Error al listar datos", e);
        }
        return datos;
    }

    /**
     * Agrega un nuevo registro de proyecto a la base de datos.
     * @param d El objeto 'Datos' con la información a insertar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean agregar(Datos d) {
        String sql = "INSERT INTO datos(sede, pnf, trayecto, seccion, tproyecto, txtnom, fdpresentacion, profesor, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, d.getSede());
            ps.setString(2, d.getPnf());
            ps.setString(3, d.getTrayecto());
            ps.setString(4, d.getSeccion());
            ps.setString(5, d.getTproyecto());
            ps.setString(6, d.getTxtnom());
            ps.setString(7, d.getFdpresentacion());
            ps.setString(8, d.getProfesor());
            ps.setString(9, d.getUrl());
            
            // 5. Devolvemos 'true' solo si la inserción afectó al menos una fila.
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, "Error al agregar dato", e);
            return false;
        }
    }

    /**
     * Actualiza un registro existente en la base de datos.
     * @param d El objeto 'Datos' con el ID a actualizar y la nueva información.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(Datos d) {
        String sql = "UPDATE datos SET sede=?, pnf=?, trayecto=?, seccion=?, tproyecto=?, txtnom=?, fdpresentacion=?, profesor=?, url=? WHERE id=?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getSede());
            ps.setString(2, d.getPnf());
            ps.setString(3, d.getTrayecto());
            ps.setString(4, d.getSeccion());
            ps.setString(5, d.getTproyecto());
            ps.setString(6, d.getTxtnom());
            ps.setString(7, d.getFdpresentacion());
            ps.setString(8, d.getProfesor());
            ps.setString(9, d.getUrl());
            ps.setInt(10, d.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, "Error al actualizar dato con id " + d.getId(), e);
            return false;
        }
    }

    /**
     * Elimina un registro de la base de datos usando su ID.
     * ⚠️ IMPORTANTE: Este método solo elimina el registro. No reordena los IDs.
     * Reordenar IDs es una práctica muy peligrosa que puede corromper la base de datos.
     * @param id El ID del registro a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean delete(int id) {
        String sql = "DELETE FROM datos WHERE id = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            Logger.getLogger(DatosDAO.class.getName()).log(Level.SEVERE, "Error al eliminar dato con id " + id, e);
            return false;
        }
    }
}