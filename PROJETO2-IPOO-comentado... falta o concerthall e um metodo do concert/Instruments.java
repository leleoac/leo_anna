/**
 *Instrumentos que podem ser usados pelos musicos.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Instruments{
    private int seriesNumber; // numero de serie
    private String instrumentName;  // nome
    private static int counter=0;// contador
    private InstrumentsFamily family;//familia de intrumentos
    private boolean isTuned; // se esta afinado ou n
    
    /**
     * Constructor for objects of class Instruments.
     * @param instrumentName - Name of instrument.
     */
    public Instruments(String instrumentName){
        counter++;
        seriesNumber=counter;
        
        if(instrumentName!=null){
            this.instrumentName=instrumentName;
            family=getFamily(instrumentName);
        }else{
            instrumentName="";
            family=family.INVALID;
        }
        isTuned=false;
    }
    
     /**
     * Return the instrument name.
     * @return the instrument name.
     */
    public String getName(){
        return instrumentName;
    }
    
     /**
     * Return the series number of the instrument.
     * @return the series number.
     */
    public int getSeriesNumber(){
        return seriesNumber;
    }
    
     /**
     * Verify if the instrument is tuned.
     * @return true if the instrument is tuned.
     */
    public boolean isTune(){
        return isTuned;
    }  
    
     /**
     * Return the number of instruments created.
     * @return the number of instruments created.
     */
    public int numberOfInstruments(){
        return counter;
    }
    
     /**
     * Tune the instrument.
     */
    public void tune(){
        if(isTuned==false)
        isTuned=true;
    }
    
     /**
     * Untuned the instrument.
     */
    public void unTune(){
        if(isTuned==true)
        isTuned=false;
    }
    
    /**
     * Get the family of instrument of the instrument.
     * @param name - name of the instrument.
     * @return the family of that instrument.
     */
    public InstrumentsFamily getFamily(String name){
        if(name!=null){
           if(name.toLowerCase()=="clarinet"||name.toLowerCase()=="oboe"||name.toLowerCase()=="flute"||name.toLowerCase()=="recorder"||name.toLowerCase()=="french horn"
              ||name.toLowerCase()=="trumpet"||name.toLowerCase()=="trombone"||name.toLowerCase()=="tuba"){
               family=family.WOODWIND;
            }else
           if(name.toLowerCase()=="violin"||name.toLowerCase()=="viola"||name.toLowerCase()=="cello"||name.toLowerCase()=="double bass"||name.toLowerCase()=="harp"||name.toLowerCase()=="guitar"){
               family=family.STRINGS;
            }else
           if(name.toLowerCase()=="piano"||name.toLowerCase()=="organ"||name.toLowerCase()=="harpsichord"||name.toLowerCase()=="eletronic keyboard"){
                family=family.KEYS;
            }else
           if(name.toLowerCase()=="snare drum"||name.toLowerCase()=="chimes"||name.toLowerCase()=="cymbals"||name.toLowerCase()=="xylophone"){
               family=family.PERCURSSION;
            }
        }else{
            family=family.INVALID;
        }
        return family;
    }
    
     /**
     * Show the instrument info.
     */
    public void show(){
        String tune="Desafinado";
        if(isTuned==true)
            tune="Afinado";
            
        System.out.println("Nº "+ seriesNumber);
        System.out.println("Nome do instrumento: "+ instrumentName.toUpperCase() );
        System.out.println("Familia do intrumento: "+ family);
        System.out.println("Estado : "+ tune);
    }
}