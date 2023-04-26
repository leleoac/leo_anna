/**
 *Uma música que tem um conjunto de famílias de instrumentos.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Music{
    private MusicStyle style; // estilo da musica
    private String title;  // titlo da musica
    private double duration; // duracao da musica
    private InstrumentsFamily[] wholeInstrumentsFamily; // conjunto de familia de instrumentos da musica
    
    /**
     * Constructor for objects of class Music
     * @param title - title of the music.
     * @param duration - duration of the music.
     * @param musicStyle - style of the music.
     */
    public Music(String title, double duration, String musicStyle){
        if(title!=null){
            this.title=title;
        }
        if(duration>0){
            this.duration=duration;
        }else{
            duration=0;
        }
        if(musicStyle!=null){
            style=addNewMusicStyle(musicStyle);
        }else{
            style=style.INVALID;
        }
        wholeInstrumentsFamily= new InstrumentsFamily[4];
    }
    
     /**
     * Return the music title.
     * @return the title of the music.
     */
    public String getTitle(){
        return title;
    }
    
     /**
     * Return the duration of the music.
     * @return the music duration.
     */
    public double getTime(){
        return duration;
    }
    
     /**
     * Return the music style.
     * @return the style of the music.
     */
    public MusicStyle getMusicStyle(){
        return style;
    }
    
    private MusicStyle addNewMusicStyle(String musicStyle){
        musicStyle = musicStyle.toLowerCase().trim();
        switch(musicStyle){
            case "mediaval":
                style = MusicStyle.MEDIEVAL;
                    break;
            case "renascentista":
                style =MusicStyle.RENAISSANCE;
                    break;
            case "barroca":
                style= MusicStyle.BAROQUE;
                    break;
            case "classica + romantica":
                style = MusicStyle.CLASSICROMANTIC;
                    break;
            case "seculos 20 e 21":
                style = MusicStyle.CENTURY2021;
            default:
                style = MusicStyle.INVALID;
                    break;
            }
        return style;
    }
    
    /**
     * Add a family of instruments into the music list.
     * @param familyName - family name.
     * @return the name of the family.
     */
    public InstrumentsFamily addNewFamily(String familyName){
        InstrumentsFamily family;
        familyName=familyName.toLowerCase().trim();
        switch(familyName){
            case "sopro":
                family=InstrumentsFamily.WOODWIND;
                    break;
            case "teclas":
                family= InstrumentsFamily.KEYS;
                    break;
            case "percursao":
                family=InstrumentsFamily.PERCURSSION;
                    break;
            case "cordas":
                family=InstrumentsFamily.STRINGS;
                    break;
            default:
                family=InstrumentsFamily.INVALID;
                    break;
        }
        if(family != InstrumentsFamily.INVALID){
            for(int i=0; i < wholeInstrumentsFamily.length; i++){
                if(wholeInstrumentsFamily[i]==null){
                    wholeInstrumentsFamily[i]=family;
                    break;
                }
            }
        }
        return family;
    }
 
    /**
     * Verify is existe a especific family.
     * @param family - family of instruments.
     * @return true if the family existe
     */
    public boolean hasMusicFamilys(InstrumentsFamily family){
        for(int i =0;i<wholeInstrumentsFamily.length;i++){
            if(wholeInstrumentsFamily[i]!=null && wholeInstrumentsFamily[i]==family){
                return true;
            }
        }
        return false;
    }
    
     /**
     * Show the music statistics.
     */
    public void showMusic(){
        System.out.println("Nome da musica: "+title);
        System.out.println("Duracao da musica: "+duration);
        System.out.println("Tipo de musica: "+ style);
        System.out.println("Familia de Instrumentos: ");
            for(int i=0;i<wholeInstrumentsFamily.length;i++){
                if(wholeInstrumentsFamily[i]!=null){
                    System.out.println(wholeInstrumentsFamily[i]);
                }
            }
        System.out.println("\n\n");
        }
}
