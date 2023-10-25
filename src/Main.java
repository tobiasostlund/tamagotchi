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
        Tamagotchi activeTam;

        ArrayList<Tamagotchi> tamagotchis=new ArrayList<Tamagotchi>();
        System.out.println("Välkommen till Tamagotchi!");
        System.out.println("Vad ska din Tamagotchi heta? ");
        String name=scan.nextLine();
        Tamagotchi tama1 = new Tamagotchi(name);
        tamagotchis.add(tama1);

        System.out.println();



        while(true) {
            int i=0;
            System.out.println("Dina tamagotchis");
            for (i = 0; i < tamagotchis.size(); i++) {
                System.out.println((i + 1) + ": " + tamagotchis.get(i).name);
                //System.out.println();

            }
            System.out.println("Skriv siffran på tamagotchin du vill köra med");
            int choice = scan.nextInt();


            rungame(tamagotchis.get(choice - 1));
            for (i = 0; i < tamagotchis.size(); i++) {
                if(tamagotchis.get(i).getHunger()>9 || tamagotchis.get(i).getBoredom()>9) {
                    tamagotchis.remove(i);
                }
            }
            scan.nextLine();
            System.out.println("Vill du skapa en ny tamagotchi? (j/n)");
            String createNew = scan.nextLine();
            if(createNew.equalsIgnoreCase("j")){
                System.out.println("Vad ska den heta?");
                String newName = scan.nextLine();
                tamagotchis.add(new Tamagotchi(newName));
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

    public static void rungame(Tamagotchi tama1){
        int money = 50;
        Scanner scan = new Scanner(System.in);


        while (true){

            System.out.println("Skriv numret till valet du vill göra:");
            System.out.println("1: Mata ("+(money)+ANSI_RED+"-10 kr"+ANSI_RESET+")");
            System.out.println("2: Lär ett nytt ord ("+(money)+ANSI_RED+"-10 kr"+ANSI_RESET+")");
            System.out.println("3: Säg ett ord");
            System.out.println("4: Sälj en njure för pengar ("+money+ANSI_GREEN+"+50 kr"+ANSI_RESET+")");
            System.out.println("5: Gör ingenting (gå tillbaka till menyn)");
            int menyVal = scan.nextInt();

            switch(menyVal){
                case 1:
                    money=money-10;
                    tama1.feed();

                    break;
                case 2:
                    money=money-10;
                    scan.nextLine();
                    System.out.println("Vad för ord ska Tamagotchin lära sig?");
                    String newWord = scan.nextLine();
                    tama1.teach(newWord);

                    break;
                case 3:
                    tama1.hi();

                    break;
                case 4:
                    money=money+50;

                case 5:
                    System.out.println("Du gjorde ingenting...");

                    break;
                default:
            }
            tama1.Tick();
            tama1.printStats();
            boolean checkAlive = tama1.getAlive();
            if(!checkAlive){
                System.out.println("DU DÖDADE TAMAGOTCHIN");
                //tamagotchis.remove(tama1);
                break;
            }
            if(menyVal==5){
                break;
            }
        }
    }
}