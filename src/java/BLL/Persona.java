package BLL;

import java.util.ArrayList;

public class Persona {
    private int rut;
    private String nombre;
    private int contacto;
    private int folio;
    private String alojamiento;
    private int idciudad;
    private int idiglesia;
    private int año;

    public Persona() {
    }

    public Persona(int rut, String nombre, int contacto, int folio, String alojamiento, int idciudad, int idiglesia, int año) {
        this.rut = rut;
        this.nombre = nombre;
        this.contacto = contacto;
        this.folio = folio;
        this.alojamiento = alojamiento;
        this.idciudad = idciudad;
        this.idiglesia = idiglesia;
        this.año = año;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(String alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getIdiglesia() {
        return idiglesia;
    }

    public void setIdiglesia(int idiglesia) {
        this.idiglesia = idiglesia;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public int registrarPersona(int rut, String nombre, int contacto, int folio, String alojamiento, int idciudad, int idiglesia, int año){
        Persona p = new Persona(rut,nombre,contacto,folio,alojamiento,idciudad,idiglesia,año);
        return new DAL.PersonaDAL().insertPersona(p);
    }
    
    public int eliminarPersona(int rut){
        return new DAL.PersonaDAL().deletePersona(rut);
    }
    
    public Persona buscarPersona(int rut){
        return new DAL.PersonaDAL().buscarPersona(rut);
    }
    
    public ArrayList<Persona> listadoPersonas(){
        return new DAL.PersonaDAL().selectPersonas();
    }
    
    public int actualizarPersona(int rut, String nombre, int contacto, int folio, String alojamiento, int idciudad, int idiglesia, int año){
        Persona p = new Persona(rut,nombre,contacto,folio,alojamiento,idciudad,idiglesia,año);
        return new DAL.PersonaDAL().updatePersona(p);
    }
}
