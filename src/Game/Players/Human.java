package Game.Players;

import java.util.Scanner;

public class Human extends Player{

    private static final Scanner sc = new Scanner(System.in);
    private int x, y;

    public Human(String name) {
        super(name);
    }

    @Override
    public boolean performStep(){

        System.out.println( getName() + ", make your stroke ");
        do{
            System.out.println("Row: ");
            x = acceptValue();
            System.out.println("Column: ");
            y = acceptValue();
            if ( !getField().isValid(x, y))System.out.println("Incorrect values. Try again");
        }while( !getField().isValid(x, y) );

        return getField().setValue(x, y, getMark());
    }

    private int acceptValue(){
        while(!sc.hasNextInt())sc.next();
        return sc.nextInt()-1;
    }

}
