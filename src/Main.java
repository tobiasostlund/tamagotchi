import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //för att färga texten
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Tamagotchi> tamagotchis=new ArrayList<Tamagotchi>();
        System.out.println("Välkommen till Tamagotchi!");
        System.out.println("Vad ska din Tamagotchi heta? ");
        String name=scan.nextLine();
        Tamagotchi tama1 = new Tamagotchi(name);
        tamagotchis.add(tama1);
        System.out.println(tama1.name+" är ett jätte dåligt namn wtf");
        System.out.println();

        int money = 50;

        while (true){

            System.out.println("Skriv numret till valet du vill göra:");
            System.out.println("1: Mata ("+(money)+ANSI_RED+"-10 kr"+ANSI_RESET+")");
            System.out.println("2: Lär ett nytt ord ("+(money)+ANSI_RED+"-10 kr"+ANSI_RESET+")");
            System.out.println("3: Säg ett ord");
            System.out.println("4: Sälj en njure för pengar ("+money+ANSI_GREEN+"+50 kr"+ANSI_RESET+")");
            System.out.println("5: Gör ingenting");
            int menyVal = scan.nextInt();

            switch(menyVal){
                case 1:
                    money=money-10;
                    tama1.feed();
                    tama1.printStats();
                    break;
                case 2:
                    money=money-10;
                    scan.nextLine();
                    System.out.println("Vad för ord ska Tamagotchin lära sig?");
                    String newWord = scan.nextLine();
                    tama1.teach(newWord);
                    tama1.printStats();
                    break;
                case 3:
                    tama1.hi();
                    tama1.printStats();
                    break;
                case 4:

                case 5:
                    System.out.println("Du gjorde ingenting...");
                    tama1.printStats();
                    break;
                default:
            }
            tama1.Tick();
            boolean checkAlive = tama1.getAlive();
            if(!checkAlive){
                System.out.println("DU DÖDADE TAMAGOTCHIN");
                break;
            }
        }

        /*
        ArrayList<String> list= new ArrayList<>();
        System.out.println(list);
        list.add("hej");
        System.out.println(list);
        list.add("hopp");
        list.add("foo");
        list.add("bar");
        System.out.println(list);
        list.remove( 3);
        System.out.println(list.get(0));

        Random random= new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1, 3));

        }

         */



        //System.out.println();

    }
}