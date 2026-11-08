package Biblioteca;

 

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
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
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
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) {
        Socio socio = new Docente(p_dniSocio, p_nombre, p_area);
        this.getSocios().add(socio);
    }

    /**
     * Crea el préstamo, y lo agrega en el libro y el socio.
     * @param p_fecha de prestamo del libro
     * @param p_socio que realiza el prestamo
     * @param p_libro adjunto al prestamo
     */
    public boolean prestarLibro(Calendar p_fecha, Socio p_socio, Libro p_libro) {
        Prestamo prestamo = new Prestamo(p_fecha, p_socio, p_libro);
        return p_libro.agregarPrestamo(prestamo) && p_socio.addPrestamo(prestamo);
    }

    /**
     * Asigna la fecha de devolución del préstamo con la fecha actual
     * @param p_prestamo el préstamo que se desea devolver
     * @throws LibroNoPrestadoException si el libro no se encuentra prestado
     */
    public void devolverLibro(Libro p_libro) {
        if(p_libro.prestado()){
            p_libro.ultimoPrestamo().registrarFechaDevolucion(Calendar.getInstance());
            return;
        }
        throw new LibroNoPrestadoException("El libro " + p_libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca");
    }

    /**
     * Busca y devuelve el socio que posee el DNI pasado como parámetro.
     * 
     * @param dni El DNI del socio a buscar.
     * @return El objeto Socio encontrado, o null si no existe.
     */
    public Socio buscarSocio(int p_dniSocio) {
        for (Socio s : socios) {
            if (s.getDniSocio() == p_dniSocio) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Devuelve una cadena de texto formateada con la lista de libros de la biblioteca.
     * 
     * @return String con el listado de libros.
     */
    public String listaDeLibros() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Libros:\n\n");
        
        int i = 1;
        for (Libro l : libros) {
            String prestadoStr = l.prestado() ? "(Si)" : "(No)";
            
            sb.append(i).append(") Titulo: ").append(l.getTitulo())
              .append(" || Prestado: ").append(prestadoStr)
              .append("\n");
            i++;
        }
        
        return sb.toString();
    }

    /**
     * Devuelve una cadena de texto con la lista de los títulos con los que cuenta la Biblioteca,
     * sin repetir en caso de haber más de un ejemplar.
     * 
     * @return String con los títulos únicos de la biblioteca.
     */
    public String listaDeTitulos() {
        Set<String> titulosUnicos = new HashSet<>();
        for (Libro l : libros) {
            titulosUnicos.add(l.getTitulo());
        }
        StringBuilder sb = new StringBuilder();
        for (String t : titulosUnicos) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    /**
     * Devuelve una cadena de texto formateada con la lista de los docentes responsables.
     * 
     * @return String con el listado de docentes responsables (Formato 3).
     */
    public String listaDeDocentesResponsables() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Docentes Responsables:\n\n");
        
        List<Docente> responsables = docentesResponsables();

        for (Docente d : responsables) {
            sb.append("* D.N.I.: ").append(d.getDniSocio())
              .append(" || ").append(d.getNombre())
              .append(" (").append(d.getArea()).append(")")
              .append(" || Libros Prestados: ").append(d.cantLibrosPrestados())
              .append("\n");
        }
        
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * Calcula la cantidad total de socios registrados en la biblioteca que coinciden con un tipo específico.
     * 
     * @param p_objeto El tipo de socio a buscar (por ejemplo, "Estudiante" o "Docente").
     * @return La cantidad de socios que pertenecen a la clase indicada.
     */
    public int cantidadDeSociosPorTipo(String p_objeto){
         int sociosTotales = 0;
         for(Socio unSocio : this.getSocios()){
             if(p_objeto.equalsIgnoreCase(unSocio.soyDeLaClase())){
                 sociosTotales ++;
             }
         }
         return sociosTotales;
    }

    /**
     * Recupera una lista de todos los préstamos de la biblioteca que se encuentran 
     * vencidos a la fecha actual, evaluando el historial de cada socio.
     * 
     * @return Un ArrayList con los objetos Prestamo cuya fecha de devolución ya ha expirado.
     */
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

    /**
     * Genera una lista exclusiva de los docentes que cumplen con la condición de ser responsables,
     * evaluando y filtrando el padrón completo de socios.
     * 
     * @return Un ArrayList de objetos Docente que tienen la propiedad de responsabilidad activa.
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docentes = new ArrayList<Docente>();
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

    /**
     * Identifica qué socio tiene actualmente en su poder un libro específico.
     * Si el libro está prestado, recupera el préstamo activo y busca al responsable 
     * cotejando las colecciones de cada miembro.
     * 
     * @param p_libro El libro cuyo estado de préstamo y poseedor se desea consultar.
     * @return Una cadena de texto indicando el nombre y DNI del socio que posee el libro, 
     *         o un mensaje notificando que no se encuentra prestado actualmente.
     */
    public String quienTieneElLibro(Libro p_libro){
        if (p_libro.prestado()) {
            Prestamo prestamoActual = p_libro.ultimoPrestamo();
            for (Socio unSocio : this.getSocios()) {
                if (unSocio.getPrestamos().contains(prestamoActual)) {
                    return "El libro fue prestado a " + unSocio.getNombre() + " DNI: " + unSocio.getDniSocio(); 
                }
            }
        }
            throw new LibroNoPrestadoException("El libro " + p_libro.getTitulo() + " no se encuentra prestado");
    }

    /**
     * Genera un reporte formateado con el listado detallado de todos los socios registrados.
     * Incluye el número de orden, DNI, nombre, tipo de socio, 
     * la cantidad de libros que tienen prestados actualmente y un totalizador estadístico final.
     * 
     * @return Una cadena de texto con el listado completo y las cantidades agrupadas.
     */
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
