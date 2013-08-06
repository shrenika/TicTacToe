package Game.Field;

public class Field {

    public static final char CHARACTER_X = 'X';
    public static final char CHARACTER_O = 'O';

    private static final int DEFAULT_FIELD_SIZE = 3;
    private final char DEFAULT_CHAR = ' ';
    private final char [][] cells;


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
        return !((x >= DEFAULT_FIELD_SIZE) || (y >= DEFAULT_FIELD_SIZE) || (x < 0) || (y < 0)) && cells[x][y] == DEFAULT_CHAR;
    }

    public boolean setValue(int x, int y, char c) {
        if ( isValid(x, y) ){
            cells[x][y] = c;
            return true;
        }else return false;
    }

    public boolean isFull(){
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++)
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++)
                if ( cells[i][j] == DEFAULT_CHAR ) return false;
        return true;
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

    public char getValue (int x, int y){
        return cells[x][y];
    }

}
