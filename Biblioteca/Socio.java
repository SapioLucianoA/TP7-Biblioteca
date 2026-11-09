<<<<<<< HEAD
import java.util.*;
=======
package Biblioteca;



import java.util.*;
>>>>>>> 59f27cfdcc0e70d1c46354faa6c0a645a294e9a2
import java.util.ArrayList; 

/**
 * Representa un socio abstracto de una biblioteca o institución.
 * Gestiona la información personal del socio, sus días permitidos de préstamo 
 * y la colección de préstamos activos que posee.
 * 
 * @author Romero Alegre Benjamin
 */
public abstract class Socio {
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor de la clase Socio que inicializa los datos principales 
     * y crea una lista de préstamos vacía.
     * 
     * @param p_dniSocio    Número de D.N.I. del socio.
     * @param p_nombre      Nombre completo del socio.
     * @param p_diasPrestamo Cantidad de días permitidos para sus préstamos.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    /**
     * Constructor de la clase Socio que permite inicializar todos los atributos,
     * incluyendo una lista de préstamos preexistente.
     * 
     * @param p_dniSocio    Número de D.N.I. del socio.
     * @param p_nombre      Nombre completo del socio.
     * @param p_diasPrestamo Cantidad de días permitidos para sus préstamos.
     * @param p_prestamos   Lista de préstamos iniciales asignados al socio.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }
    
    /**
     * Establece el número de D.N.I. del socio.
     * 
     * @param p_dniSocio El D.N.I. a configurar.
     */
    private void setDniSocio(int p_dniSocio) {
        this.dniSocio = p_dniSocio;
    }
    
    /**
     * Obtiene el número de D.N.I. del socio.
     * 
     * @return El D.N.I. del socio.
     */
    public int getDniSocio() {
        return this.dniSocio;
    }
    
    /**
     * Establece el nombre del socio.
     * 
     * @param p_nombre El nombre a configurar.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    /**
     * Obtiene el nombre del socio.
     * 
     * @return El nombre del socio.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Establece la colección de préstamos del socio.
     * 
     * @param p_prestamos El ArrayList de préstamos a asignar.
     */
    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }
    
    /**
     * Obtiene la lista completa de préstamos asociados al socio.
     * 
     * @return Un ArrayList con los objetos {@link Prestamo} del socio.
     */
    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }
    
    /**
     * Agrega un nuevo préstamo a la lista del socio.
     * 
     * @param p_prestamo El objeto {@link Prestamo} a agregar.
     * @return true si se añadió correctamente, false en caso contrario.
     */
    public boolean addPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * Elimina un préstamo de la lista del socio.
     * 
     * @param p_prestamo El objeto {@link Prestamo} a remover.
     * @return true si se removió correctamente, false en caso contrario.
     */
    public boolean removePrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Devuelve la cantidad total de libros o elementos prestados actualmente.
     * 
     * @return Cantidad de préstamos en la lista.
     */
    public int cantLibrosPrestados() {
        return this.getPrestamos().size();
    }
    
    /**
     * Modifica la cantidad de días de préstamo permitidos para el socio.
     * 
     * @param p_dias Nueva cantidad de días.
     */
    public void setDiasPrestamo(int p_dias) {
        this.diasPrestamo = p_dias;
    }
    
    /**
     * Obtiene la cantidad de días de préstamo permitidos para el socio.
     * 
     * @return Cantidad de días de préstamo.
     */
    public int getDiasPrestamo() {
        return this.diasPrestamo;
    }
    
    /**
     * Devuelve una representación en cadena (String) con la información básica del socio,
     * incluyendo DNI, nombre, tipo de socio (según la subclase) y cantidad de libros prestados.
     * 
     * @return Una cadena formateada con los datos del socio.
     */
    @Override
    public String toString() {
        return ("D.N.I.: " + this.getDniSocio() + " || " + this.getNombre() + 
                " (" + this.soyDeLaClase() + ") || Libros Prestados: " + this.cantLibrosPrestados());
    }
    
    /**
     * Evalúa si el socio se encuentra habilitado para solicitar un nuevo préstamo.
     * Recorre sus préstamos y verifica si alguno se encuentra vencido a la fecha actual.
     * 
     * @return true si ninguno de sus préstamos está vencido (puede pedir), false si posee al menos uno vencido.
     */
    public boolean puedePedir() {
        Calendar fechaHoy = Calendar.getInstance();
        for (Prestamo x : this.getPrestamos()) {
            if (x.vencido(fechaHoy)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método abstracto que debe ser implementado por las subclases concretas 
     * para retornar una descripción textual del tipo específico de socio.
     * 
     * @return Un String que representa la clasificación o categoría del socio.
     */
    public abstract String soyDeLaClase();
}
