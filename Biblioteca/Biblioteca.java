import java.util.ArrayList;
import java.util.*;
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


    /**
     * agrega un libro a la coleccion de libros de la biblioteca
     * @param p_titulo el titulo del libro a agregar
     * @param p_edicion del libro a agregar
     * @param p_editorial de origen del libro
     * @param p_anio de publicacion del libro
     */
    public void nuevoLibro(String p_titulo, String p_edicion, String p_editorial, int p_anio) {
        Libro libro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.getLibros().add(libro);
    }

    /**
     * agrega un socio estudiante a la coleccion de socios de la biblioteca
     * @param p_dniSocio del socio a agregar
     * @param p_nombre el nombre del socio a agregar
     * @param p_carrera del socio a agregar
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        Socio socio = new Estudiante(p_dniSocio, p_nombre, p_carrera);
        this.getSocios().add(socio);
    }

    /**
     * agrega un socio profesor a la coleccion de socios de la biblioteca
     * @param p_dniSocio del socio a agregar
     * @param p_nombre el nombre del socio a agregar
     * @param p_area del socio a agregar
     */
    public void nuevoSocioProfesor(int p_dniSocio, String p_nombre, String p_area) {
        Socio socio = new Profesor(p_dniSocio, p_nombre, p_area);
        this.getSocios().add(socio);
    }

    /**
     * Crea el préstamo, y lo agrega en el libro y el socio.
     * @param p_fecha de prestamo del libro
     * @param p_socio que realiza el prestamo
     * @param p_libro adjunto al prestamo
     */
    public boolean prestarLibro(String p_fecha, Socio p_socio, Libro p_libro) {
        Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
        return p_libro.agregarPrestamo(prestamo) && p_socio.agregarPrestamo(prestamo);
    }

    /**
     * Asigna la fecha de devolución del préstamo con la fecha actual
     * @param p_prestamo el préstamo que se desea devolver
     * @throws LibroNoPrestadoException si el libro no se encuentra prestado
     */
    public void devolverLibro(Prestamo p_prestamo) {
        for (Libro libro : this.getLibros()) {
            if (libro.getPrestamos().contains(p_prestamo)) {
                libro.getPrestamos().get(p_prestamo).registrarFechaDevolucion(Calendar.getInstance());
                return;
            }
        }
        throw new LibroNoPrestadoException("El libro " + libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int cantidadDeSociosPorTipo(String p_objeto){
         int sociosTotales = 0;
         for(Socio unSocio : this.getSocios()){
             if(p_objeto.equalsIgnoreCase(unSocio.soyDeLaClase())){
                 sociosTotales ++;
             }
         }
         return sociosTotales;
    }
    public ArrayList<Prestamo> prestamosVencidos(){
        Calendar fechaDeHoy =  Calendar.getInstance();
        ArrayList<Prestamo> vencidos = new ArrayList<>();
        for(Socio unSocio : this.getSocios()){
            for(Prestamo unPrestamo : unSocio.getPrestamos()){
                if(unPrestamo.vencido(fechaDeHoy)){
                    vencidos.add(unPrestamo);
                }
            }
        }
        return vencidos;
    }
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docentes = new ArrayList<>();
        for(Socio unSocio : this.getSocios()){
                if (unSocio.soyDeLaClase().equalsIgnoreCase("docente")) {
                Docente elDocente = (Docente) unSocio;
                if (elDocente.esResponsable()) {
                    docentes.add(elDocente);
                }
            }
        }
        return docentes;
    }
    public String quienTieneElLibro(Libro p_libro){
        if (p_libro.prestado()) {
            Prestamo prestamoActual = p_libro.ultimoPrestamo();
            for (Socio unSocio : this.getSocios()) {
                if (unSocio.getPrestamos().contains(prestamoActual)) {
                    return "El libro fue prestado a " + unSocio.getNombre() + " DNI: " + unSocio.getDniSocio(); 
                }
            }
        }
            return "El libro no se encuentra prestado actualmente";
    }

    public String listaDeSocios(){
        String listadoSocios = "";
        int ordenSocio = 1;
        int socioEstudiantes = 0;
        int socioDocentes = 0;
        
        for(Socio unSocio :this.getSocios()){
            if(unSocio.soyDeLaClase().equalsIgnoreCase("docente")){
                socioDocentes++;
            }else{
                socioEstudiantes++;
            }
            int librosPrestados = unSocio.cantLibrosPrestados();
            listadoSocios = listadoSocios + "\n" + ordenSocio + ") " + "D.N.I: " + unSocio.getDniSocio() + " || " + unSocio.getNombre() + "(" + 
            unSocio.soyDeLaClase()
            +")" + " || "  + "Libros Prestados: " + librosPrestados;
            
            ordenSocio ++; 
        }
        
            listadoSocios = listadoSocios + "\n ********************************** \n" +
        "Cantidad de Socios de tipo Estudiante: " + socioEstudiantes + "\n" + 
        "Cantidad de Socios de tipo Docente: " + socioDocentes + "\n ********************************** \n";
        
        return listadoSocios;
    }
    
    
    
    
    
    
    
      

}