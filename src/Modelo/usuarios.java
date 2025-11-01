package Modelo;

import java.util.Objects;

/**
 * Representa la entidad 'Usuario' en el sistema.
 * Esta clase es un POJO (Plain Old Java Object) que transporta los datos del usuario
 * entre la base de datos, la lógica del negocio y la interfaz gráfica.
 */
public class usuarios {

    private int id;
    private String ci;
    private String nombre;
    private String password;
    private String last_session;
    private int id_tipo;
    private String nombre_tipo;

    /**
     * Constructor vacío. Útil para crear un objeto 'usuarios' que se llenará
     * con datos más adelante (por ejemplo, desde un formulario).
     */
    public usuarios() {
    }

    // --- GETTERS Y SETTERS (Sin cambios, están perfectos) ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_session() {
        return last_session;
    }

    public void setLast_session(String last_session) {
        this.last_session = last_session;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    // --- MÉTODOS DE UTILIDAD (Añadidos para seguir buenas prácticas) ---

    /**
     * Genera una representación en texto del objeto, ideal para depuración.
     * IMPORTANTE: La contraseña se oculta para no exponerla en logs o consolas.
     */
    @Override
    public String toString() {
        return "usuarios{" +
                "id=" + id +
                ", ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='[OCULTO]'" + // Por seguridad, nunca imprimas la contraseña.
                ", last_session='" + last_session + '\'' +
                ", id_tipo=" + id_tipo +
                ", nombre_tipo='" + nombre_tipo + '\'' +
                '}';
    }

    /**
     * Compara este objeto con otro para ver si son "iguales".
     * Se considera que dos objetos 'usuarios' son iguales si tienen la misma cédula (ci).
     * La cédula es un identificador único de negocio.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usuarios usuario = (usuarios) o;
        // Comparamos por 'ci' (cédula), asumiendo que es un identificador único y no nulo.
        return Objects.equals(ci, usuario.ci);
    }

    /**
     * Genera un código hash basado en la cédula (ci).
     * Es obligatorio implementarlo si se sobreescribe el método equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(ci);
    }
}