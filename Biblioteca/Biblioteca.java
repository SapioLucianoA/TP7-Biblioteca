import java.util.ArrayList;

/**
 * Representa una Biblioteca que administra una colección de libros y una lista de socios.
 * 
 * @author (Sapio Luciano, Romero Agustín, Veglia Marcos)
 * @version 1.0
 */
public class Biblioteca {

    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;

    /**
     * Constructor por defecto.
     * Crea una biblioteca con un nombre específico e inicializa las listas 
     * de libros y socios como colecciones vacías.
     * 
     * @param p_nombre El nombre de la biblioteca.
     */
    public Biblioteca(String p_nombre) {
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<>());
        this.setSocios(new ArrayList<>());
    }

    /**
     * Constructor con un libro inicial.
     * Crea una biblioteca con un nombre, agrega un libro a la colección inicial 
     * e inicializa la lista de socios vacía.
     * 
     * @param p_nombre El nombre de la biblioteca.
     * @param p_libro  El primer libro que se agregará a la biblioteca.
     */
    public Biblioteca(String p_nombre, Libro p_libro) {
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<>());
        this.getLibros().add(p_libro);
        this.setSocios(new ArrayList<>());
    }

    /**
     * Constructor con un socio inicial.
     * Crea una biblioteca con un nombre, inicializa la lista de libros vacía 
     * y agrega un socio a la colección inicial.
     * 
     * @param p_nombre El nombre de la biblioteca.
     * @param p_socio  El primer socio que se registrará en la biblioteca.
     */
    public Biblioteca(String p_nombre, Socio p_socio) {
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<>());
        this.setSocios(new ArrayList<>());
        this.getSocios().add(p_socio);
    }

    /**
     * Constructor con un libro y un socio iniciales.
     * Crea una biblioteca con un nombre e inicializa las colecciones agregando 
     * un libro y un socio específicos.
     * 
     * @param p_nombre El nombre de la biblioteca.
     * @param p_libro  El primer libro que se agregará a la biblioteca.
     * @param p_socio  El primer socio que se registrará en la biblioteca.
     */
    public Biblioteca(String p_nombre, Libro p_libro, Socio p_socio) {
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<>());
        this.getLibros().add(p_libro);
        this.setSocios(new ArrayList<>());
        this.getSocios().add(p_socio);
    }

    /**
     * Constructor con listas predefinidas.
     * Crea una biblioteca asignando colecciones de libros y socios ya existentes.
     * 
     * @param p_nombre El nombre de la biblioteca.
     * @param p_libros Una lista (ArrayList) de objetos Libro.
     * @param p_socios Una lista (ArrayList) de objetos Socio.
     */
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros, ArrayList<Socio> p_socios) {
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(p_socios);
    }

    // ---------------- GETTERS Y SETTERS ----------------

    /**
     * Obtiene el nombre de la biblioteca.
     * 
     * @return El nombre actual de la biblioteca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la biblioteca.
     * 
     * @param nombre El nuevo nombre para la biblioteca.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la colección de libros disponibles en la biblioteca.
     * 
     * @return Un ArrayList que contiene los libros.
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Establece la colección completa de libros de la biblioteca.
     * 
     * @param libros Un ArrayList de objetos Libro.
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Obtiene la colección de socios registrados en la biblioteca.
     * 
     * @return Un ArrayList que contiene los socios.
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * Establece la colección completa de socios de la biblioteca.
     * 
     * @param socios Un ArrayList de objetos Socio.
     */
    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
}