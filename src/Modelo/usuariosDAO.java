package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <Dev's: Chrys y Manuel> <CVAM-TEAM>
 */
public class usuariosDAO extends Conexion {
    
    public boolean registrar(usuarios usr) {
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO usuarios (ci, nombre, password, id_tipo) VALUES (?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getCi());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getPassword());
            ps.setInt(4, usr.getId_tipo());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean login(usuarios usr) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT u.id, u.ci, u.password, u.nombre, u.id_tipo, t.nombre FROM usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id WHERE ci = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getCi());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                if (usr.getPassword().equals(rs.getString(3))) {
                    
                    String sqlUpdate = "UPDATE usuarios SET last_session = ? WHERE id=?";
                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    usr.setNombre_tipo(rs.getString(6));
                    return true;
                    
                } else {
                    return false;
                }
                
            }
            
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int existeUsuario(String ci) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT count(id) FROM usuarios WHERE ci = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ci);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
// COPIAS Y PEGAS
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

// COPIAS Y PEGAS
    public List listarUser() throws SQLException {
        List<usuarios> usuarios = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from usuarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios u = new usuarios();
                u.setId(rs.getInt(1));
                u.setCi(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setNombre_tipo(rs.getString(5));
                u.setLast_session(rs.getString(6));
                
                
                
                usuarios.add(u);
            }
        } catch (SQLException e) {
            
        }
        return usuarios;
    }
    
    
    
    


    // Método para eliminar un usuario por ID
    public void deleteUser(int id) {
        String deleteSql = "DELETE FROM usuarios WHERE id = ?";
        try {
            con = conectar.getConnection();

            // Eliminar el registro con el ID proporcionado
            ps = con.prepareStatement(deleteSql);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Obtener el máximo ID actual
            String getMaxIdSql = "SELECT MAX(id) FROM usuarios";
            ps = con.prepareStatement(getMaxIdSql);
            ResultSet rs = ps.executeQuery();
            int maxId = rs.next() ? rs.getInt(1) : 0;

            // Actualizar los valores de identificación posteriores
            String updateSql = "UPDATE usuarios SET id = id - 1 WHERE id > ?";
            ps = con.prepareStatement(updateSql);
            for (int i = id + 1; i <= maxId; i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }

            // Reiniciar la secuencia de identificación
            String resetSequenceSql = "ALTER TABLE usuarios AUTO_INCREMENT = ?";
            ps = con.prepareStatement(resetSequenceSql);
            ps.setInt(1, maxId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
