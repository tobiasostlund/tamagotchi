import java.util.ArrayList;
import java.util.Random;
public class Tamagotchi {
    //attributes
    private int hunger = 0;
    private int boredom = 0;
    private ArrayList<String> words=new ArrayList<String>();
    private boolean isAlive = true;
    Random random= new Random();
    public String name;

    //constructor
    public Tamagotchi(String name){
        this.name=name;
    }

    //methods
    public int getHunger() {
        return hunger;
    }
    public int getBoredom() {
        return boredom;
    }

    public void feed(){
        this.hunger=this.hunger-(random.nextInt(1, 4));
        if(this.hunger<0){
            this.hunger=0;
        }
    }

    public void printStats(){
        if(this.isAlive==false){
            System.out.println("Tamagotchin är död");
        }else {
            System.out.println("Tamagotchin lever");
            System.out.println("Hunger: " + this.hunger);
            System.out.println("Boredom: " + this.boredom);
        }
    }

    public void hi(){
        reduceBoredom();
        if(words.size()>0) {
            System.out.println(words.get(random.nextInt(words.size())));
        }else{
            System.out.println("Din Tamagotchi kan inga ord än...");
        }
    }

    public void teach(String word){
        reduceBoredom();
        words.add(word);
        //add word to list
    }

    public void Tick(){
        this.hunger++;
        this.boredom++;
        if(this.hunger>9||this.boredom>9){
            this.isAlive=false;
        }
    }

    public boolean getAlive(){ return isAlive; }

    private void reduceBoredom(){
        this.boredom=this.boredom-(random.nextInt(1, 4));
        if(this.boredom<0){
            this.boredom=0;
        }
    }
}
