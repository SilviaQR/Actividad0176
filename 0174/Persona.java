import java.util.ArrayList;
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
    private Comida comidaMasCalorica;
    private ArrayList<Comida> listaDeComida;

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
        listaDeComida = new ArrayList<Comida>();
        comidaMasCalorica = null;
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
        int calorias = comida.getCalorias();
        listaDeComida.add(comida);
        if((caloriasIngeridas <= metabolismoBasal)){
            caloriasIngeridas = caloriasIngeridas + comida.getCalorias();
            calorias = comida.getCalorias();
            if(comidaMasCalorica == null){
                comidaMasCalorica = comida;
            }
            else if(comidaMasCalorica.getCalorias() < comida.getCalorias()){
                comidaMasCalorica = comida;
            }
        }
        else{
            calorias = -1;
            System.out.println("No quiero comer más.");
        }
        return calorias;
    }
    
    public int getCaloriasIngeridas()
    {
        return caloriasIngeridas;
    }
    
    public String getNombre()
    {
        return nombrePersona;
    }

    public String contestar(String pregunta)
    {
        String preguntaFormulada = pregunta;
        String respuesta = "";
        if(caloriasIngeridas <= metabolismoBasal){    
            if((preguntaFormulada.length()%3) == 0){
                respuesta = "si";
            }
            else{
                respuesta = "no";
            }
        }
        else{
            respuesta = preguntaFormulada;
        }
        if(preguntaFormulada.contains(nombrePersona)){
            respuesta = preguntaFormulada;
        }
        System.out.println(respuesta.toUpperCase());
        return respuesta.toUpperCase(); 
    }

    public String getAlimentoMasCaloricoIngerido()
    {
        String haComido = null;
        if(comidaMasCalorica == null){
            System.out.println("No he comido nada aún.");
        }
        else{
            haComido = comidaMasCalorica.getComida();
        }
        System.out.println(haComido);
        return haComido;
    }
    
    public void verListadoComidasIngeridas()
    {
        for(Comida comidaActual : listaDeComida){
            System.out.println(comidaActual.getComida() + ": " + comidaActual.getCalorias() + " calorías.");
        }
    }
}
