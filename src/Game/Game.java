package Game;

import Game.Field.Field;
import Game.Players.Player;

public class Game {

    private final Field field;
    private final Player player1, player2;
    private boolean win = false;

    public void start() {
        System.out.println("Tic-Tac-Toe. LETS START:");
        field.show();

        while( true ){
            if ( performStroke(player1) )break;
            if ( performStroke(player2) )break;
        }
        if (!win) System.out.println("The game was very boring...Draw");
    }

    private boolean checkForWinner(char c){

        int count1 = 0; int count2 = 0;

        for(int i = 0; i < Field.getLength(); i++){
            for(int j =0; j < Field.getLength(); j++){
                if ( field.getValue(i, j) == c )++count1;
                if ( field.getValue(j, i) ==c )++count2;
            }
            if ( (count1 >= Field.getLength()) || (count2 >= Field.getLength()) )return true;
            count1 = 0; count2 = 0;
        }

        return ((field.getValue(0, 0) == c) && (field.getValue(1, 1) == c) && (field.getValue(2, 2) == c)) ||
                ((field.getValue(2, 0) == c) && (field.getValue(1, 1) == c) && (field.getValue(0, 2) == c));
    }

    private void notify(Player player) {
        win = true;
        System.out.println("CONGRATULATIONS! " + player.getName()+ " has won!" );
    }

    private boolean performStroke(Player player){

        player.performStep();
        field.show();
        if ( checkForWinner(player.getMark()) ){
            notify(player);
            return true;
        }
        if ( field.isFull() ) return true;

        return false;
    }

    public Game( Player player1, Player player2 ) {

        this.player1 = player1;
        this.player2 = player2;
        field = new Field();

        player1.setField(field);
        player1.setMark(Field.CHARACTER_X);
        player2.setField(field);
        player2.setMark(Field.CHARACTER_O);
    }

}
