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
                System.out.print("[" + getValues(i,j) + "]");
            }
            System.out.println();
        }
    }

    public Field getInstance(){
        return this;
    }

    public boolean validation(int x, int y) {
        if ( (x >= DEFAULT_FIELD_SIZE) || (y >= DEFAULT_FIELD_SIZE) || (x<0) || (y<0) )return false;
        if ( getValues(x,y) == DEFAULT_CHAR )return true;
        else return false;
    }

    public int setStep(int x, int y, char c) {

        if ( validation(x,y) ) setValue(x,y,c);
        else return Field.ERROR_CODE;

        if ( checkForWinner(Field.CHARACTER_X) ) return Field.X_WIN_CODE;
        if ( checkForWinner(Field.CHARACTER_O) ) return Field.O_WIN_CODE;
        if ( isEmpty() ) return Field.DRAW_CODE;

        return Field.SUCCESS_CODE;
    }

    public boolean isEmpty(){
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++)
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++)
                if ( getValues(i,j) == DEFAULT_CHAR ) return false;
        return true;
    }

    public boolean isEmptyCell( int x, int y) {
        return ( getValues(x,y) == DEFAULT_CHAR ? true: false );
    }

    public boolean checkForWinner(char c){

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < DEFAULT_FIELD_SIZE; i++){
            for(int j =0; j < DEFAULT_FIELD_SIZE; j++){
                if ( getValues(i,j) == c )++count1;
                if ( getValues(j,i) ==c )++count2;
            }
            if ( (count1 >= DEFAULT_FIELD_SIZE) || (count2 >= DEFAULT_FIELD_SIZE) )return true;
            count1 = 0;
            count2 = 0;
        }

        if ( ( (getValues(0,0)==c) && (getValues(1,1)==c) && (getValues(2,2)==c) ) ||
                ( (getValues(2,0)==c) && (getValues(1,1)==c) && (getValues(0,2)==c) ) )return true;
        return false;
    }

    private void setValue(int x, int y , char c) {
         cells[x][y] = c;
    }

    private char getValues (int x, int y) {
        return cells[x][y];
    }


    private void initField(){
        for(int i = 0; i < DEFAULT_FIELD_SIZE; i++)
            for(int j =0; j < DEFAULT_FIELD_SIZE; j++)
                setValue(i,j,DEFAULT_CHAR);
    }


    public Field() {
        cells = new char[DEFAULT_FIELD_SIZE][DEFAULT_FIELD_SIZE];
        initField();
    }


}