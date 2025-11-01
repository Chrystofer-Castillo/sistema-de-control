package Modelo;

import java.util.Objects;

/**
 * Representa la información de un proyecto.
 * Esta clase es un POJO (Plain Old Java Object) utilizada para transportar
 * datos entre la base de datos y la aplicación.
 */
public class Datos {

    private int id;
    private String tproyecto;
    private String sede;
    private String pnf;
    private String trayecto;
    private String seccion;
    private String fdpresentacion;
    private String txtnom;
    private String profesor;
    private String url;

    /**
     * Constructor vacío. Permite crear un objeto para llenarlo después.
     */
    public Datos() {
    }

    /**
     * Constructor principal y completo.
     * Es la forma recomendada para crear un objeto 'Datos' con toda su información.
     * El orden de los parámetros coincide con la declaración de las variables para mayor claridad.
     */
    public Datos(int id, String tproyecto, String sede, String pnf, String trayecto, String seccion, String fdpresentacion, String txtnom, String profesor, String url) {
        this.id = id;
        this.tproyecto = tproyecto;
        this.sede = sede;
        this.pnf = pnf;
        this.trayecto = trayecto;
        this.seccion = seccion;
        this.fdpresentacion = fdpresentacion;
        this.txtnom = txtnom;
        this.profesor = profesor;
        this.url = url;
    }

    // ----------------------------------------------------
    // GETTERS Y SETTERS (Sin cambios)
    // ----------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTproyecto() {
        return tproyecto;
    }

    public void setTproyecto(String tproyecto) {
        this.tproyecto = tproyecto;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPnf() {
        return pnf;
    }

    public void setPnf(String pnf) {
        this.pnf = pnf;
    }

    public String getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(String trayecto) {
        this.trayecto = trayecto;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getFdpresentacion() {
        return fdpresentacion;
    }

    public void setFdpresentacion(String fdpresentacion) {
        this.fdpresentacion = fdpresentacion;
    }

    public String getTxtnom() {
        return txtnom;
    }

    public void setTxtnom(String txtnom) {
        this.txtnom = txtnom;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // ----------------------------------------------------
    // MÉTODOS DE UTILIDAD (Añadidos para seguir buenas prácticas)
    // ----------------------------------------------------

    /**
     * Genera una representación en texto del objeto, ideal para depuración.
     * En lugar de ver "Modelo.Datos@1a2b3c4d", verás todos los datos del objeto.
     */
    @Override
    public String toString() {
        return "Datos{" +
                "id=" + id +
                ", tproyecto='" + tproyecto + '\'' +
                ", sede='" + sede + '\'' +
                ", pnf='" + pnf + '\'' +
                ", trayecto='" + trayecto + '\'' +
                ", seccion='" + seccion + '\'' +
                ", fdpresentacion='" + fdpresentacion + '\'' +
                ", txtnom='" + txtnom + '\'' +
                ", profesor='" + profesor + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * Compara este objeto con otro para ver si son "iguales".
     * Se considera que dos objetos 'Datos' son iguales si tienen el mismo ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datos datos = (Datos) o;
        return id == datos.id;
    }

    /**
     * Genera un código hash basado en el ID.
     * Es necesario implementarlo si se implementa equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}