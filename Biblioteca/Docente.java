import java.util.*;
/**
 *Especializacion de la clase Socio.
 * 
 * @author (Gomez Varela, Verónica) 
 * @version (1.0 30/10/2026)
 */
public class Docente extends Socio{
    //variables de instancia  
    private String area;

    /**
     * Constructor de objectos de la clase Docente
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area){
        super(p_dniSocio, p_nombre, 5);
        this.setArea(p_area);
        
    }
    
     /**
     * Getters y Setters
     */
    
     /**
     * 
     * 
     * @param  p_area 
     * @return no retorna nada
     */
    private void setArea(String p_area){
       this.area = p_area;   
    }
    
    public String getArea(){
        return this.area;
    }
    
    /**
     * Descripción  del metodo
     * 
     * @param no posee parametros 
     * @return retirna un tipo booleano    
     */
    public boolean esResponsable(){
    
        
        return true;
    }
    
    
    public void cambiarDiasDePrestamo(int p_dias){
       System.out.println(""); 
    }
    
    public boolean puedePedir(){
      return true;   
    }
    
     /**
     * Devuelve el nombre del tipo de clase 
     * 
     * @param no posee parametros  
     * @return un tipo String     
     */
    public String soyDeLaCLase(){
       return "Docente";   
    }    
}
