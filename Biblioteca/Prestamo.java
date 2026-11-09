package Biblioteca;



import java.util.*;
/**
 * Representa el préstamo de un libro a un socio en una biblioteca.
 * Gestiona las fechas de retiro y devolución, así como la relación 
 * con el socio que lo solicita y el libro prestado.
 * 
 * @author Romero Alegre Benjamin
 */
public class Prestamo {
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    /**
     * Constructor de la clase Prestamo que inicializa la fecha en que se retira,
     * el socio que realiza el préstamo y el libro asociado.
     * La fecha de devolución se mantiene inicialmente como nula hasta que se registre.
     * 
     * @param p_fechaRetiro Objeto {@link Calendar} que representa la fecha de retiro.
     * @param p_socio       Objeto {@link Socio} que solicita el préstamo.
     * @param p_libro       Objeto {@link Libro} que se está prestando.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }

    /**
     * Establece la fecha de retiro del préstamo.
     * 
     * @param p_fechaRetiro Objeto {@link Calendar} con la fecha de retiro.
     */
    private void setFechaRetiro(Calendar p_fechaRetiro) {
        this.fechaRetiro = p_fechaRetiro;
    }

    /**
     * Obtiene la fecha en la que se retiró el libro.
     * 
     * @return Un objeto {@link Calendar} con la fecha de retiro.
     */
    public Calendar getFechaRetiro() {
        return this.fechaRetiro;
    }

    /**
     * Establece la fecha de devolución real del libro.
     * 
     * @param p_fechaDevolucion Objeto {@link Calendar} con la fecha de devolución.
     */
    private void setFechaDevolucion(Calendar p_fechaDevolucion) {
        this.fechaDevolucion = p_fechaDevolucion;
    }

    /**
     * Registra la fecha oficial en la que se devuelve el libro del préstamo.
     * 
     * @param p_fechaDevolucion Objeto {@link Calendar} que representa el día de la devolución.
     */
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion) {
        this.setFechaDevolucion(p_fechaDevolucion);
    }

    /**
     * Obtiene la fecha de devolución del libro (puede ser null si aún no ha sido devuelto).
     * 
     * @return Un objeto {@link Calendar} con la fecha de devolución, o null si está pendiente.
     */
    public Calendar getFechaDevolucion() {
        return this.fechaDevolucion;
    }

    /**
     * Asocia un socio al préstamo.
     * 
     * @param p_socio El objeto {@link Socio} a asignar.
     */
    private void setSocio(Socio p_socio) {
        this.socio = p_socio;
    }

    /**
     * Obtiene el socio que realizó el préstamo.
     * 
     * @return El objeto {@link Socio} asociado.
     */
    public Socio getSocio() {
        return this.socio;
    }

    /**
     * Asocia un libro al préstamo.
     * 
     * @param p_libro El objeto {@link Libro} a asignar.
     */
    private void setLibro(Libro p_libro) {
        this.libro = p_libro;
    }

    /**
     * Obtiene el libro involucrado en el préstamo.
     * 
     * @return El objeto {@link Libro} asociado.
     */
    public Libro getLibro() {
        return this.libro;
    }

    /**
     * Evalúa si el préstamo se encuentra vencido respecto a una fecha dada,
     * calculando la fecha de vencimiento en base a los días de préstamo permitidos para el socio.
     * 
     * @param p_fecha Objeto {@link Calendar} contra el cual se desea verificar el vencimiento (ej. la fecha actual).
     * @return true si la fecha indicada es posterior a la fecha límite de vencimiento, false en caso contrario.
     */
    public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = Calendar.getInstance();
        int day = this.getFechaRetiro().get(Calendar.DAY_OF_MONTH);
        int month = this.getFechaRetiro().get(Calendar.MONTH);
        int year = this.getFechaRetiro().get(Calendar.YEAR);

        fechaVencimiento.set(year, month, day);

        // Se suman los días permitidos según las políticas específicas del socio
        fechaVencimiento.add(Calendar.DAY_OF_MONTH, this.getSocio().getDiasPrestamo());

        return p_fecha.after(fechaVencimiento);
    }

    /**
     * Devuelve una representación en cadena (String) con los detalles del préstamo,
     * incluyendo la fecha de retiro, la fecha de devolución (o N/A si sigue pendiente), 
     * el título del libro y el nombre del socio.
     * 
     * @return Una cadena formateada con la información completa del préstamo.
     */
    @Override
    public String toString() {
        String retiroStr = "\n\nRetiro: " + this.getFechaRetiro().get(Calendar.YEAR) + "/" 
                + this.getFechaRetiro().get(Calendar.MONTH) + "/" 
                + this.getFechaRetiro().get(Calendar.DAY_OF_MONTH);
        
        String devolucionStr = "Devolucion: ";

        if (this.getFechaDevolucion() != null) {
            devolucionStr += this.getFechaDevolucion().get(Calendar.YEAR) + "/"
                    + this.getFechaDevolucion().get(Calendar.MONTH) + "/"
                    + this.getFechaDevolucion().get(Calendar.DAY_OF_MONTH) + "\n";
        } else {
            devolucionStr += "N/A \n";
        }

        String libroStr = "Libro: " + this.getLibro().getTitulo() + "\n";
        String socioStr = "Socio: " + this.getSocio().getNombre();
        
        return retiroStr + devolucionStr + libroStr + socioStr;
    }
}