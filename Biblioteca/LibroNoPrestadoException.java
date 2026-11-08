package Biblioteca;

 

class LibroNoPrestadoException extends RuntimeException{
    public LibroNoPrestadoException(String mensaje){
        super(mensaje);
        }
}
