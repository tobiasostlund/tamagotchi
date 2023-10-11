import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Välkommen till Tamagotchi!");
        System.out.println("Vad ska din Tamagotchi heta? ");
        String name=scan.nextLine();
        Tamagotchi tama1 = new Tamagotchi(name);
        System.out.println(tama1.name+" är ett jätte dåligt namn wtf");


        while (true){
            System.out.println("Skriv numret till valet du vill göra:");
            System.out.println("1: Mata");
            System.out.println("2: Lär ett nytt ord");
            System.out.println("3: Säg ett ord");
            System.out.println("4: Kolla hälsa");
            int menyVal = scan.nextInt();

            switch(menyVal){
                case 1:
                    tama1.feed();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
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