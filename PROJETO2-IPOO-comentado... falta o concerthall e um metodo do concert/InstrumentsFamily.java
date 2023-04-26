/**
 * Familia de Instrumentos musicais existentes
 *
 * @author 202100213-202200009
 * @version 1
 */

public enum InstrumentsFamily{

    STRINGS, KEYS, PERCURSSION, WOODWIND, INVALID ;
    
    public String toString(){
        switch(this){
            case STRINGS:
                    return "Cordas";
            case KEYS:
                    return "Teclas";
            case PERCURSSION:
                    return "Percursão";
            case WOODWIND:
                    return "Sopro";
            case INVALID:
                    return "Invalido";
            default:    
                return "";
        }
    }
}