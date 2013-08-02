package Game;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Game {

    private Field field;
    private Scanner sc;
    private  int x,y;
    private Stack<Field> history;


    public int generateNewStep(char c){
        do{
            x = new Random().nextInt(Field.getLength());
            y = new Random().nextInt(Field.getLength());
        }while( !field.isEmptyCell(x, y) );

        return setStep(x,y,c);
    }


    public void start() {

        sc = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe. LETS START:");
        field.show();

        while ( true ) {
            System.out.println("Please, make your stroke:");
            do{
                System.out.println("ROW: ");
                while(!sc.hasNextInt())sc.next();
                x = sc.nextInt()-1;

                System.out.println("COLUMN: ");
                while(!sc.hasNextInt())sc.next();
                y = sc.nextInt()-1;

               if (! field.isValid(x, y))System.out.println("Incorrect values. Try again");
            }while( ! field.isValid(x, y) );

            if (checkTheEndGameState(setStep(x, y, Field.CHARACTER_X))) break;
//            history.push(field.getInstance());

            System.out.println("Ok.Check the enemy stroke ");
            if (checkTheEndGameState(generateNewStep(Field.CHARACTER_O))) break;
//            history.push(field);
            field.show();
        }
    }

    public int setStep (int x, int y, char c) {
        return field.setStep( x, y, c );
    }


    public void showHistory() {
        while (!history.empty()) {
            history.pop().show();
            System.out.println();
        }
    }


    private void notification(String str) {
        System.out.println(str);
        System.out.println("SEE YOUR FIELD!");
        field.show();
//        System.out.println();
//        System.out.println("See the history of the game:");
//        showHistory();
    }

    private boolean checkTheEndGameState(int code) {

        switch (code){
            case Field.DRAW_CODE:
                notification("DRAW!");
                return true;
            case Field.O_WIN_CODE:
                notification("COMPUTER WINS!");
                return true;
            case Field.X_WIN_CODE:
                notification("CONGRATULATIONS!YOU WON!");
                return true;
        }

      return false;
    }

    public Game( Field field ) {
        this.field = field;
        history = new Stack<Field>();
    }
}
