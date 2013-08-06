package Game.Players;

import java.util.Scanner;

public class Human extends Player{

    private int x, y;
    private Scanner sc;

    public Human(String name) {
        super(name);
        sc = new Scanner(System.in);
    }

    @Override
    public boolean performStep(){

        System.out.println( getName() + ", make your stroke ");

        do{
            System.out.println("ROW: ");
            while(!sc.hasNextInt())sc.next();
            x = sc.nextInt()-1;

            System.out.println("COLUMN: ");
            while(!sc.hasNextInt())sc.next();
            y = sc.nextInt()-1;

            if ( !getField().isValid(x, y))System.out.println("Incorrect values. Try again");
        }while( !getField().isValid(x, y) );


        return getField().setValue(x, y, getMark());
    }

}
