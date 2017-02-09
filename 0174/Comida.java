
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida
{
    // instance variables - replace the example below with your own
    private String nombreComida;
    private int caloriasComida;
    /**
     * Constructor for objects of class Comida
     */
    public Comida(String nombreComida, int caloriasComida)
    {
        // initialise instance variables
        this.nombreComida = nombreComida;
        this.caloriasComida = caloriasComida;
    }
    
    public String getComida()
    {
        return nombreComida;
    }
    
    public int getCalorias()
    {
        return caloriasComida;
    }
}
