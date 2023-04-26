/**
 * Os Estilos de muscia existentes
 *
 * @author 202100213-202200009
 * @version 1
 */
public enum MusicStyle{
    
    MEDIEVAL,RENAISSANCE,BAROQUE,CLASSICROMANTIC,CENTURY2021,INVALID;
    
    public String toString(){
        switch(this){   
            case MEDIEVAL:
                    return "Mediaval";
            case BAROQUE:
                    return "Barroca";
            case RENAISSANCE:
                    return "Renascentista";
            case CLASSICROMANTIC:
                    return "Clássica+Romântica";
            case CENTURY2021:
                    return "Séculos 20 e 21";
            case INVALID:
                    return "Invalido";
            default:    
                return "";
        }
    }
}