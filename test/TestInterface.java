package test;

import java.util.Random;

public class TestInterface{
    public static void game(GameFactory g) {
        Game c = g.getGame();
        System.out.println(c.drop());
    }
    public static void main(String[] args) {
        game(Coin.factory);
        game(Cube.factory);
    }
}
interface Game {
    String drop();
}
interface GameFactory {
    Game getGame();
}
class Coin implements Game {
    public String drop() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        if (i == 0) {
            return "орел";
        }
        return "решка";
    }
    public static GameFactory factory = new GameFactory() {
        public Game getGame() {
            return new Coin();
        }
    };

}
class Cube implements Game {
    public String drop() {
        Random rand  = new Random();
        return "" + rand.nextInt(6);
    }
    public static GameFactory factory = new GameFactory() {
        public Game getGame() {
            return new Cube();
        }
    };
}