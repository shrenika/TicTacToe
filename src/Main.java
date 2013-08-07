import Game.Game;
import Game.Players.Computer;
import Game.Players.Human;

public class Main {

    public static void main(String[] args) {

        Game game = new Game( new Human("Yarik"), new Computer("Ehor") );
        game.start();

    }


}

