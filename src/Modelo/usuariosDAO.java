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
 * DAO (Data Access Object) para la entidad 'usuarios'.
 * Contiene toda la lógica para interactuar (CRUD) con la tabla 'usuarios'.
 * Hereda de Conexion para poder usar el método estático getConnection().
 */
public class usuariosDAO extends Conexion {

    /**
     * Registra un nuevo usuario en la base de datos.
     * @param usr El objeto 'usuarios' con la información a insertar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
public boolean registrar(usuarios usr) {
        // ✅ CAMBIO 1: Agregamos 'last_session' a la consulta
        // ✅ CAMBIO 2: Usamos 'NOW()' para que MySQL inserte la fecha/hora actual automáticamente
        String sql = "INSERT INTO usuarios (ci, nombre, password, id_tipo, last_session) VALUES (?, ?, ?, ?, NOW())";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usr.getCi());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getPassword());
            ps.setInt(4, usr.getId_tipo());
            
            // Nota: No necesitamos hacer ps.setString para el 5to valor 
            // porque pusimos NOW() directamente en el SQL.

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, "Error al registrar usuario", ex);
            return false;
        }
    }

    /**
     * Valida las credenciales de un usuario y actualiza su última sesión.
     * @param usr Un objeto 'usuarios' que debe contener la CI y la contraseña (hasheada) a verificar.
     * @return true si el login es exitoso, false en caso contrario. Si es exitoso, el objeto 'usr' se rellena con los demás datos.
     */
    public boolean login(usuarios usr) {
        // 2. Hacemos un JOIN para obtener también el nombre del tipo de usuario.
        String sql = "SELECT u.id, u.ci, u.password, u.nombre, u.id_tipo, t.nombre AS nombre_tipo " +
                     "FROM usuarios AS u " +
                     "INNER JOIN tipo_usuario AS t ON u.id_tipo = t.id " +
                     "WHERE u.ci = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usr.getCi());
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    // 3. Comparamos la contraseña hasheada de la BD con la que nos pasaron.
                    String passwordFromDB = rs.getString("password");
                    if (usr.getPassword().equals(passwordFromDB)) {
                        
                        // Si las contraseñas coinciden, rellenamos el objeto usuario.
                        usr.setId(rs.getInt("id"));
                        usr.setNombre(rs.getString("nombre"));
                        usr.setId_tipo(rs.getInt("id_tipo"));
                        usr.setNombre_tipo(rs.getString("nombre_tipo"));
                        
                        // Actualizamos la última sesión en una operación separada y segura.
                        actualizarLastSession(con, usr.getLast_session(), usr.getId());
                        
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, "Error durante el login", ex);
        }
        return false;
    }
    
    /**
     * Método auxiliar privado para actualizar la fecha de última sesión.
     * Se llama desde login() para mantener el código limpio.
     */
    private void actualizarLastSession(Connection con, String lastSession, int userId) throws SQLException {
        String sqlUpdate = "UPDATE usuarios SET last_session = ? WHERE id = ?";
        try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, lastSession);
            psUpdate.setInt(2, userId);
            psUpdate.executeUpdate();
        }
    }

    /**
     * Verifica si un usuario existe en la base de datos a través de su cédula.
     * @param ci La cédula del usuario a verificar.
     * @return 1 si el usuario existe, 0 si no existe, -1 si ocurre un error.
     */
    public int existeUsuario(String ci) {
        String sql = "SELECT count(id) FROM usuarios WHERE ci = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, ci);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1); // Devolverá 0 o 1
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, "Error al verificar si usuario existe", ex);
            return -1; // -1 indica que hubo un error en la consulta.
        }
        return -1; // Si algo muy raro pasa, devolvemos error.
    }

    /**
     * Recupera todos los usuarios de la base de datos.
     * @return Una lista de objetos 'usuarios'.
     */
    public List<usuarios> listarUser() {
        List<usuarios> listaUsuarios = new ArrayList<>();
        String sql = "SELECT id, ci, nombre, id_tipo, last_session FROM usuarios";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuarios u = new usuarios();
                u.setId(rs.getInt("id"));
                u.setCi(rs.getString("ci"));
                u.setNombre(rs.getString("nombre"));
                // NOTA: No obtenemos nombre_tipo aquí. Para eso se necesitaría un JOIN.
                // Esta función solo devuelve los datos directos de la tabla usuarios.
                u.setId_tipo(rs.getInt("id_tipo")); 
                u.setLast_session(rs.getString("last_session"));
                listaUsuarios.add(u);
            }
        } catch (SQLException e) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, "Error al listar usuarios", e);
        }
        return listaUsuarios;
    }

    /**
     * Elimina un usuario de la base de datos usando su ID.
     * ⚠️ IMPORTANTE: Este método solo elimina la fila. No reordena los IDs.
     * @param id El ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, "Error al eliminar usuario con id " + id, e);
            return false;
        }
    }
}