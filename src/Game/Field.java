package Game;

public class Field {

    public static final int DEFAULT_FIELD_SIZE = 3;
    public static final int ERROR_CODE = 0;
    public static final int SUCCESS_CODE = 1;
    public static final int DRAW_CODE = 2;
    public static final int X_WIN_CODE = 3;
    public static final int O_WIN_CODE = 4;
    public static final char CHARACTER_X = 'X';
    public static final char CHARACTER_O = 'O';

    private final char [][] cells;
    private final char DEFAULT_CHAR = ' ';


    public static int getLength(){
        return Field.DEFAULT_FIELD_SIZE;
    }

    public void show(){
        for(int i = 0; i < DEFAULT_FIELD_SIZE; i++){
            for(int j =0; j < DEFAULT_FIELD_SIZE; j++){
                System.out.print("[" + cells[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean isValid(int x, int y) {
        if ( (x >= DEFAULT_FIELD_SIZE) || (y >= DEFAULT_FIELD_SIZE) || (x<0) || (y<0) )return false;
        if ( cells[x][y] == DEFAULT_CHAR )return true;
        else return false;
    }

    public int setStep(int x, int y, char c) {

        if ( isValid(x, y) ) cells[x][y] = c;
        else return Field.ERROR_CODE;

        if ( checkForWinner(Field.CHARACTER_X) ) return Field.X_WIN_CODE;
        if ( checkForWinner(Field.CHARACTER_O) ) return Field.O_WIN_CODE;
        if ( isFull() ) return Field.DRAW_CODE;

        return Field.SUCCESS_CODE;
    }

    public boolean isFull(){
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++)
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++)
                if ( cells[i][j] == DEFAULT_CHAR ) return false;
        return true;
    }

    public boolean isEmptyCell( int x, int y) {
        return ( cells[x][y] == DEFAULT_CHAR ? true: false );
    }

    public boolean checkForWinner(char c){

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < DEFAULT_FIELD_SIZE; i++){
            for(int j =0; j < DEFAULT_FIELD_SIZE; j++){
                if ( cells[i][j] == c )++count1;
                if ( cells[j][i] ==c )++count2;
            }
            if ( (count1 >= DEFAULT_FIELD_SIZE) || (count2 >= DEFAULT_FIELD_SIZE) )return true;
            count1 = 0;
            count2 = 0;
        }

        if ( ( ( cells[0][0] == c ) && ( cells[1][1] == c ) && ( cells[2][2] == c ) ) ||
                ( ( cells[2][0] == c ) && ( cells[1][1] == c ) && ( cells[0][2] == c ) ) )return true;
        return false;
    }

    private void initField(){
        for(int i = 0; i < DEFAULT_FIELD_SIZE; i++)
            for(int j =0; j < DEFAULT_FIELD_SIZE; j++)
                cells[i][j] = DEFAULT_CHAR;
    }


    public Field() {
        cells = new char[DEFAULT_FIELD_SIZE][DEFAULT_FIELD_SIZE];
        initField();
    }


}
