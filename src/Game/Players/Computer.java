package Game.Players;

import Game.Field.Field;

import java.util.Random;

public class Computer extends Player {

    private int x, y;
    private Random n;

    public Computer(String name) {
        super(name);
        n = new Random();
    }

    @Override
    public boolean performStep() {

        System.out.println("Okay, check " + getName()+ " stroke ");
        do{
            x = n.nextInt(Field.getLength());
            y = n.nextInt(Field.getLength());
        }while( !getField().isValid(x, y) );

        return getField().setValue(x, y, getMark());
    }

}
