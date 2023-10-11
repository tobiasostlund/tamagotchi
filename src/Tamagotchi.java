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
    }

    public void printStats(){
        System.out.println("Hunger: "+this.hunger);
        System.out.println("Boredom: "+this.boredom);
    }

    public void hi(){
        reduceBoredom();
        System.out.println(words.get(random.nextInt(words.size())));
    }

    public void teach(String word){
        reduceBoredom();
        words.add(word);
        //add word to list
    }

    public void Tick(){
        this.hunger++;
        this.boredom++;
    }

    public boolean getAlive(){ return isAlive; }

    private void reduceBoredom(){
        this.boredom=this.boredom-(random.nextInt(1, 4));
    }
}
