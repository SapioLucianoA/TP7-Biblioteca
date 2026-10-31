
import java.util.ArrayList;

/**
 * CLase Libro la cual permite gestionar la información y el historial de préstamos de un libro.
 * 
 * @author Villagra Facundo Nahuel Grupo 3 laboratorio.
 * @version 1.0 (29/10/2026)
 */
public class Libro {
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor para inicializar un objeto Libro.
     * Realiza la asignación mediante doble encapsulamiento.
     * 
     * @param p_titulo El título del libro.
     * @param p_edicion El número de edición.
     * @param p_editorial La editorial que lo publica.
     * @param p_anio El año de publicación.
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }

    /**
     * Establece el título del libro.
     * 
     * @param p_titulo El nuevo título.
     */
    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    /**
     * Establece el número de edición del libro.
     * 
     * @param p_edicion El número de edición.
     */
    private void setEdicion(int p_edicion) {
        this.edicion = p_edicion;
    }

    /**
     * Establece la editorial del libro.
     * 
     * @param p_editorial La empresa editorial.
     */
    private void setEditorial(String p_editorial) {
        this.editorial = p_editorial;
    }

    /**
     * Establece el año de publicación del libro.
     * 
     * @param p_anio El año de publicación.
     */
    private void setAnio(int p_anio) {
        this.anio = p_anio;
    }

    /**
     * Establece la colección de préstamos del libro.
     * 
     * @param p_prestamos La lista de préstamos.
     */
    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }

    /**
     * Obtiene el título del libro.
     * 
     * @return String El título del libro.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Obtiene el número de edición del libro.
     * 
     * @return int El número de edición.
     */
    public int getEdicion() {
        return this.edicion;
    }

    /**
     * Obtiene la editorial del libro.
     * 
     * @return String La editorial.
     */
    public String getEditorial() {
        return this.editorial;
    }

    /**
     * Obtiene el año de publicación del libro.
     * 
     * @return int El año.
     */
    public int getAnio() {
        return this.anio;
    }

    /**
     * Obtiene la colección completa de préstamos asociados al libro.
     * 
     * @return ArrayList La lista conteniendo los objetos Prestamo.
     */
    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    /**
     * Asienta un nuevo préstamo en la colección del libro.
     * 
     * @param p_prestamo El objeto préstamo a registrar.
     */
    public void agregarPrestamo(Prestamo p_prestamo) {
        
    }
    
    /**
     * Determina si el libro se encuentra prestado actualmente.
     * 
     * @return boolean true si está en poder de un socio, false en caso contrario.
     */
    public boolean prestado() {
        return false;
    }

    /**
     * Recupera el último préstamo registrado en el historial del libro.
     * 
     * @return Prestamo El préstamo más reciente, o null si no posee historial.
     */
    public Prestamo ultimoPrestamo() {
        return null;
    }

    /**
     * Retorna la representación del libro en cadena de texto según formato exigido.
     * 
     * @return String Cadena con el formato "Titulo: <<titulo>>".
     */
    @Override
    public String toString() {
        return "";
    }
}
