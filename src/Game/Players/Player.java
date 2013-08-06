package Game.Players;

import Game.Field.Field;

public abstract class Player {

    private Field field;
    private String name;
    private char mark;

    public abstract boolean performStep();

    public Player(String name) {
        this.name = name;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public char getMark() {
        return mark;
    }
}
