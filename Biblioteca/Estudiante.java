package Biblioteca;

/**
 * Especializaci�n de la clase Estudiante.
 * 
 * @author (Gomez Varela, Ver�nica) 
 * @version (1.0 30/10/2026)
 */
public class Estudiante extends Socio{
    //Variables de instancia
    private String carrera;

    /**
     * Constructor de objects de la clase Estudiante
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
        //Variable de instancia
        super(p_dniSocio, p_nombre, 1);
        this.setCarrera(p_carrera);
        
    }
    /**
     * Getters y Setters
     */
    
     /**
     * 
     */
    private void setCarrera(String p_carrera){
        this.carrera = p_carrera;
    }
    
     /**
     * 
     */
    public String getCarrera(){
        return this.carrera;
    }
    
   
    /**
     * Devuelve true si el Estudiante no tiene ning�n pr�stamo vencido y si no tiene m�s 
     * de 3 libros prestados (en su poder). 
     * 
     * @param no posee parametros  
     * @return  devuelve un tipo bollean    
     */
    public boolean puedePedir(){
         if(super.cantLibrosPrestados() < 3 && super.puedePedir()){
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     * Devuelve el nombre del tipo de clase 
     * 
     * @param no posee parametros  
     * @return un tipo String     
     */
    public String soyDeLaClase(){
        return "Estudiante";
    }
}
