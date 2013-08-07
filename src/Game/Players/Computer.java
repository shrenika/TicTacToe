package Game.Players;

import Game.Field.Field;

import java.util.Random;

public class Computer extends Player {

    private static final Random n = new Random();
    private int x, y;

    public Computer(String name) {
        super(name);
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
