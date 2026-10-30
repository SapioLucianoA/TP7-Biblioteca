import java.util.*;
import java.util.ArrayList; 

    public abstract class Socio{
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList <Prestamo> prestamos;

  
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
    }
    
    
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList <Prestamo> p_prestamos){
    }
    
    private void setDniSocio(int p_dniSocio){
    }
    
    public int getDniSocio(){
        return 0;
    }
    
    private void setNombre(String p_nombre){
    }
    
    public String getNombre(){
        return null;
    }
    
    private void setPrestamos(ArrayList <Prestamo> p_prestamos){
    }
    
    public ArrayList <Prestamo> getPrestamos(){
        return null;
    }
    
    public boolean addPrestamo(Prestamo p_prestamo){
        return true;
    }
    
    public boolean removePrestamo(Prestamo p_prestamo){
         return true;
    }
    
    public int cantLibrosPrestados(){
        return 0;
    }
    
    public void setDiasPrestamo(int p_dias){
    }
    
    public int getDiasPrestamo(){
        return 0;
    }
    
    public String toString(){
        return null;
    }
    
    public boolean puedePedir(){
        return true;
    }
    
    public abstract String soyDeLaClase();
}