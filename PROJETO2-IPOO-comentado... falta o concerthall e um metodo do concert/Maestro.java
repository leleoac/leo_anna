
/**
 *Um maestro, responsável por dirigir uma orquestra.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Maestro{
    
    private MusicStyle[] wholeMusicStyle; // lista de estilos musicais 
    private String maestroName;  // nome do maestro
    private int ranking; // rank 
    
    /**
     * Constructor for objects of class Maestro.
     * @param ranking - rank of the maestro.
     * @param maestroName - maestro name.
    */
    public Maestro(int ranking,String maestroName){
        wholeMusicStyle = new MusicStyle[5];
        
        if(maestroName!=null){
            this.maestroName=maestroName;
        }else maestroName= "No Name";
        
        if(ranking>=1 && ranking<=5){
            this.ranking=ranking;
        }else ranking = -1;
        
    }
    
     /**
     * Add a music Style.
     * @param musicStyle - style of the music
     * @return the style of the music.
     */
    public MusicStyle addNewMusicStyle(String musicStyle){
        MusicStyle music;
        musicStyle = musicStyle.toLowerCase().trim();
        switch(musicStyle){
            case "mediaval":
                music = MusicStyle.MEDIEVAL;
                    break;
            case "renascentista":
                music =MusicStyle.RENAISSANCE;
                    break;
            case "barroca":
                music= MusicStyle.BAROQUE;
                    break;
            case "classica + romantica":
                music = MusicStyle.CLASSICROMANTIC;
                    break;
            case "seculos 20 e 21":
                music = MusicStyle.CENTURY2021;
            default:
                music = MusicStyle.INVALID;
                    break;
        }
        if(music != MusicStyle.INVALID){
            for(int i=0; i < wholeMusicStyle.length; i++){
                if(wholeMusicStyle[i]==null){
                    wholeMusicStyle[i]=music;
                    break;
                }
            }
        }
        return music;
    }
    
     /**
     *Show the maestro description.
     */
    public void showDescription(){
        System.out.println("Nome: "+ maestroName);
        System.out.println("Ranking: "+ ranking);
        for(int i=0;i<wholeMusicStyle.length;i++){
            if(wholeMusicStyle[i]!=null){
                System.out.println(wholeMusicStyle[i]);
            }
        }
    }
}
