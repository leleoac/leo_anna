/**
 * Musico que tem um instrumento para tocar.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Musician{
    private String musicianName;            // nome do musico.
    private InstrumentsFamily expertFamily; // famila de instrumentos.
    private Instruments[] instruments;      // lista de instrumentos
    private int ranking;                    // ranking do musico.
    
    /**
     * Constructor for objects of class Musician
     * @param musicianName - Musician name.
     * @param ranking - Rank of the Musician.
     * @param familyName - Name of the family of instrumets.
     */
    public Musician(String musicianName, int ranking, String familyName){
            instruments =  new Instruments[10]; // 10?
        if(musicianName!=null){
            this.musicianName=musicianName;
        }else musicianName= "No Name";
        
        if(ranking>=1 && ranking<=5){
            this.ranking=ranking;
        }else ranking = -1;
        
        if(familyName!=null){
            expertFamily=addInstrumentsFamily(familyName);
        }else{
            expertFamily=expertFamily.INVALID;
        }
    }
    
    /**
     * Return the Musicia name.
     * @ return the Musician name.
     */
    public String getName(){
        return musicianName;
    }
    
    /**
     * Return the Instruments Family.
     * @return the family of instruments.
     */
    public InstrumentsFamily getExpertFamily(){
        return expertFamily;
    }
    
    /**
     * Return the Musicia rank.
     * @return the musician rank.
     */
    public int getRanking(){
        return ranking;
    }
    
    /**
     * Add the instrument family from the given name.
     * @param familyName - Family of instrumets.
     * @return the family of instruments.
     */
    public InstrumentsFamily addInstrumentsFamily(String familyName){
        familyName=familyName.toLowerCase().trim();
        switch(familyName){
            case "sopro":
                expertFamily=InstrumentsFamily.WOODWIND;
                    break;
            case "teclas":
                expertFamily= InstrumentsFamily.KEYS;
                    break;
            case "percursao":
                expertFamily=InstrumentsFamily.PERCURSSION;
                    break;
            case "cordas":
                expertFamily=InstrumentsFamily.STRINGS;
                    break;
            default:
                expertFamily=InstrumentsFamily.INVALID;
                    break;
        }
        return expertFamily;
    }
    
     /**
     * Buy one instruments by the name.
     * @param instrumentName - Name of the instruments.
     */
    public void buyInstrument(String instrumentName){
        if(instrumentName!=null){
            Instruments newInstrument = new Instruments(instrumentName);
            for(int i=0; i < instruments.length; i++){
                if(instruments[i]==null){
                    instruments[i]=newInstrument;
                    break;
                }
            }
        }
    }
    
     /**
     * Buy one intruments by the instrument.
     * @param instrumentName - instrument.
     * @return the instrument.
     */
    public Instruments buyInstrument2(Instruments instrumentName){
        if(instrumentName!=null && instrumentName.getFamily(instrumentName.getName())==expertFamily ){
            for(int i=0; i < instruments.length; i++){
                if(instruments[i]==null){
                    instruments[i]=instrumentName;
                    break;
                }
            }
        }
        return instrumentName;
    }
    
    /**
     * Sell one instrument by the series number.
     * @param instrumentSeriesNumber - series number.
     * @return the selled instrument.
     */
    public Instruments sellInstruments(int instrumentSeriesNumber){
        Instruments instrumentRemove = null;
        if(instrumentSeriesNumber>0){
            for(int i=0; i < instruments.length; i++){
                if(instruments[i]!=null && instruments[i].getSeriesNumber()==instrumentSeriesNumber ){
                    instrumentRemove = instruments[i];
                    instruments[i]=null;
                    break;
                }
            }
        }
        return instrumentRemove;
    }
    
     /**
     * Verify if the musician can play a certain music.
     * @param music - music to play.
     * @return true if musician can play music.
     */
    public boolean canPlayMusic(Music music){
        boolean play = false;
        if(music.hasMusicFamilys(expertFamily)){
            for(int i=0; i < instruments.length; i++){
                if(instruments[i].isTune()==true && instruments[i].getFamily(instruments[i].getName() ) == expertFamily )  {
                    play= true;
                }         
            }
        }
        return play;
    }
    
     /**
     * Show the musician statistics.
     */
    public void show(){
        System.out.println("Nome do musico:" + musicianName);
        System.out.println("Ranking: "+ranking);
        System.out.println("Familia de instrumentos: "+ expertFamily);
        for(int i=0;i<instruments.length;i++){
            if(instruments[i]!=null){
                instruments[i].show();
            }
        }
    }
}