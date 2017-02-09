
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    // instance variables - replace the example below with your own
    private String nombrePersona;
    // True si es hombre, false si es mujer
    private boolean esHombre;
    private int pesoPersona;
    private int alturaPersona;
    private int edadPersona;
    private int caloriasIngeridas;
    private int metabolismoBasal;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombrePersona, boolean esHombre, int pesoPersona, int alturaPersona, int edadPersona)
    {
        // initialise instance variables
        this.nombrePersona = nombrePersona;
        this.esHombre = esHombre;
        this.pesoPersona = pesoPersona;
        this.alturaPersona = alturaPersona;
        this.edadPersona = edadPersona;
        caloriasIngeridas = 0;
        if(esHombre == false){
            metabolismoBasal = (10*pesoPersona) + (6*alturaPersona) + (5*edadPersona) + 5; 
        }
        else{
            metabolismoBasal = (10*pesoPersona) + (6*alturaPersona) + (5*edadPersona) - 161;
        }
    }
    
    public int comer(Comida comida)
    {
        int calorias = -1;
        if((caloriasIngeridas <= metabolismoBasal)){
            caloriasIngeridas = caloriasIngeridas + comida.getCalorias();
            calorias = comida.getCalorias();
        }
        return calorias;
    }
    
    public int getCaloriasIngeridas()
    {
        return caloriasIngeridas;
    }
}
