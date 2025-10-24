package Modelo;

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

    public Datos() {
        // Constructor vacío (default)
    }

    // Constructor para INSERCIÓN (Asumo que esta es la versión original sin ID ni URL)
    public Datos(String tproyecto, String sede, String pnf, String trayecto, String seccion, String fdpresentacion, String txtnom, String profesor) {
        this.tproyecto = tproyecto;
        this.sede = sede;
        this.pnf = pnf;
        this.trayecto = trayecto;
        this.seccion = seccion;
        this.fdpresentacion = fdpresentacion;
        this.txtnom = txtnom;
        this.profesor = profesor;
    }

    // 💡 CONSTRUCTOR PARA EDICIÓN (Incluye el ID y TODOS los 9 campos String)
    // El orden de los argumentos en el constructor debe coincidir con el orden en que los tomas de la tabla.
    public Datos(int id, String pnf, String sede, String trayecto, String seccion, String profesor, String tproyecto, String txtnom, String fdpresentacion, String url) {
        this.id = id;
        
        // El orden de asignación interna es según la declaración de variables (tproyecto, sede, pnf, etc.)
        this.pnf = pnf;
        this.sede = sede;
        this.trayecto = trayecto;
        this.seccion = seccion;
        this.profesor = profesor;
        this.tproyecto = tproyecto; 
        this.txtnom = txtnom;
        this.fdpresentacion = fdpresentacion;
        this.url = url;
    }
    
    // ----------------------------------------------------
    // GETTERS Y SETTERS
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
}