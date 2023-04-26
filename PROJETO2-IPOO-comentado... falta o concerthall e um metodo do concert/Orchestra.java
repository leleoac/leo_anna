
/**
 * Uma orquestra é conduzida por um maestro e conta com músicos que irão participar num 
concerto.
 *
 * @author 202100213-202200009
 * @version 1
 */
public class Orchestra{
    
    private Maestro maestro; // maestro
    private Musician[] allMusicians; // lista de musicos
    private int numberOfMusicians; // numero de musicos
    /**
     * Constructor for objects of class Orchestra
     */
    public Orchestra(){
        numberOfMusicians=0;
        allMusicians= new Musician[30]; // numero maximos de musicas da orquesta
    }
    
     /**
     * Add one musician to the orchestra.
     * @param name - musician name.
     * @param ranking - musician rank.
     * @param expertFamilyName - family of instruments.
     * @return the musician.
     */
    public Musician addMusician(String name, int ranking, String expertFamilyName){
        Musician musician = new Musician(name,ranking,expertFamilyName);
        if(allMusicians[numberOfMusicians]==null){
            allMusicians[numberOfMusicians]=musician;
            numberOfMusicians++;
        }
        return musician;
    }
    
     /**
     * Remove one musician by the name.
     * @param name - musician name.
     * @return the musician who get removed.
     */
    public Musician removeMusicianByName(String name){
        Musician removedMusician=null;
        for(int i=0;i<allMusicians.length;i++){
            if(allMusicians[i]!=null){
                if(allMusicians[i].getName()==name ){
                    removedMusician=allMusicians[i];
                    allMusicians[i]=null;
                    numberOfMusicians--;
                }
            }
        }
        return removedMusician;
    }
    
    /**
     * Remove one musician by the name.
     * @param name - musician name.
     * @return the musician who get removed.
     */public boolean removeMusician(Musician musician){
        boolean remove = false;
        if(musician!=null){
            for(int i =0;i<allMusicians.length;i++){
                if(allMusicians[i]!=null){
                    if(allMusicians[i].getName()==musician.getName() &&
                        allMusicians[i].getExpertFamily()==musician.getExpertFamily() &&
                        allMusicians[i].getRanking()==musician.getRanking())  {
                            allMusicians[i]=null;
                            remove=true;
                    }
                }
            }
        }
        return remove;
    }
    
    /**
     * Return the musician by one especific family.
     * @param family - family of instruments.
     */
    public void getMusiciansByFamily(String family){
        if(family!=null){
          Musician experterFamily = new Musician("",0,family);
          experterFamily.addInstrumentsFamily(family);
            for(int i=0;i<numberOfMusicians;i++){
                if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                    allMusicians[i].show();
                }
            }
        }
    }
    
    /**
     * Return the number of musician by one especific family.
     * @param family - family of instruments.
     */
    public int getNumberOfMusiciansByFamily(String family){
        int counter=0;
        if(family!=null){
          Musician experterFamily = new Musician("",0,family);
          experterFamily.addInstrumentsFamily(family);
            for(int i=0;i<numberOfMusicians;i++){
                if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                    counter++;
                }
            }
        }
        return counter;
    }
    
    /**
     * Return the musician name.
     */
    public void getNameOfMusicians(){
        for(int i=0;i<allMusicians.length;i++){
            if(allMusicians[i]!=null){
                System.out.println(allMusicians[i].getName() );
            }
        }
    }
    
    /**
     * Return the orchestra.
     */
    public void getOrchestra(){
        System.out.println("\nCORDAS");
            for(int i=0;i<allMusicians.length;i++){
                if(allMusicians[i]!=null){
                  Musician experterFamily = new Musician (" ",0,"cordas");
                    if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                        allMusicians[i].show();
                    }
                }
            }
        System.out.println("\nTECLAS");
            for(int i=0;i<allMusicians.length;i++){
                if(allMusicians[i]!=null){
                  Musician experterFamily = new Musician("",0,"teclas");
                    if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                        allMusicians[i].show();
                    }
                }
            }
        System.out.println("\nPERCURSSÃO");
            for(int i=0;i<allMusicians.length;i++){
                if(allMusicians[i]!=null){
                  Musician experterFamily = new Musician("",0,"percursao");
                    if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                        allMusicians[i].show();
                    }
                }
            }
        System.out.println("\nSOPRO");
            for(int i=0;i<allMusicians.length;i++){
                if(allMusicians[i]!=null){
                  Musician experterFamily = new Musician("",0,"sopro");
                    if(allMusicians[i].getExpertFamily()==experterFamily.getExpertFamily()){
                        allMusicians[i].show();
                    }
                }
            }
    }
    
    /**
     * verify if the orchestra can play a music.
     * @param music - music to play.
     * @return true if the orchestra can play music.
     */
    public boolean canOrchestraPlayMusic(Music music){
        boolean play=false;
        if(music!=null){
            for(int i=0;i<allMusicians.length;i++){
               if(allMusicians[i].canPlayMusic(music)){
                   play=true;
               }
            }
        }
        return play;
    }
    
    /**
     * Add a maestro to the orchestra.
     * @param ranking - maestro rank.
     * @param maestroName - maestro name
     */
    public void addMaestro(int ranking,String maestroName){
        maestro = new Maestro(ranking,maestroName);
    }
    
    /**
     * Show the maestro specs.
     */
    public void showMaestro(){
        maestro.showDescription();
    }
}