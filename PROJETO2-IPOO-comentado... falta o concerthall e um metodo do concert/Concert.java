/**
 * A realização de um concerto que contará com a performance de todos os intervenientes.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Concert{
    
    private String description;
    private Orchestra orchestra;
    private MusicStyle style;
    private Music[] listOfMusics;
    
    /**
     * Constructor for objects of class Concert.
     * @param description - description of the concert.
     * @param musicStyle - style of the musics in the concerto.
     */
    public Concert(String description,String musicStyle){
        this.orchestra=orchestra;
        listOfMusics = new Music[10]; // tamanho do array
        if(description!=null){
            this.description=description;
        }else{
            description= "None ";
        }
        if(musicStyle!=null){
            style=addNewMusicStyle(musicStyle);
        }else{
            style=style.INVALID;
        }
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
     * Add a music to the concert.
     * @param music - music to add.
     * @return music.
     */
    public Music addMusic(Music music){
        int numberOfMusics=0;
        if(music!=null){
            if(orchestra!=null || orchestra.canOrchestraPlayMusic(music)){
                if(music.getMusicStyle()==style){
                    for(int i=0;i<listOfMusics.length;i++){
                        if(listOfMusics[i]==null){
                            listOfMusics[i]=music;
                            break;
                        }
                    }
                }
            }
        }
        return music;
    }
    
    /**
     * Add a orchestra to the concert.
     * @param newOrchestra - orchestra.
     * @return a orchestra.
     */
    public Orchestra addOrchestra(Orchestra newOrchestra){
        if(newOrchestra!=null && orchestra==null){
            orchestra=newOrchestra;
        }
        return orchestra;
    }
    
    /**
     * Add the maestro on the orchestra.
     * @param name - name of the maestro.
     * @param rank - maestro rank
     */
    public void getMaestro(String name,int rank){
        orchestra.addMaestro(rank, name);
    }
    
    /**
     * Calculate the duration of the concert.
     * @return the concert duration.
     */
    public double concertDuration(){
        double time=0;
        int a=0;
        for(int i=0;i<listOfMusics.length;i++){
            if(listOfMusics[i]!=null){  
                if( ( time+listOfMusics[i].getTime()) < 60){
                        time+=listOfMusics[i].getTime()+1;
                }
                if( (time+listOfMusics[i].getTime()) >= 60){
                        time+=listOfMusics[i].getTime()+1;
                        a=(int)(time) / 60;
                }
            }
        }
        return time+(a*15)-1;
    }
    
    /**
     * Show the musician in the concert.
     */
    public void showAllMusicians(){          
        orchestra.getOrchestra();    
    }
    
    /**
     * Show all the musics.
     */
    public void showAllMusics(){
        for(int i=0;i<listOfMusics.length;i++){
            if(listOfMusics[i]!=null){
                listOfMusics[i].showMusic();
            }
        }
        System.out.println("O Concerto tem no total:"+ concertDuration()+ " minutos");
    }
    
    /**
     * Show the concert schedule
     * @param startTime - time of the concerto start .
     */
    public void showSchedule(double startTime){
        concertDuration();
    
    
    }
    
    /**
     * Show the orchestra.
     */
    public void showOrchestra(){
        orchestra.getOrchestra();
         System.out.println("\n \n Maestro:");
        orchestra.showMaestro();
    }
    
    /**
     * Show the concert statistics.
     */
    public void showInfo(){
         System.out.println("Descricao do concerto: "+ description);
         System.out.println("Estilo de musica tocado: "+ style);
    }
}