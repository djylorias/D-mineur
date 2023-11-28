package main.java.game;

import main.java.model.Map;

/**
 * The main class of the game.
 * @version 0.9
 * @since 0.6
 */
public class Main {

    private static final int DEFAULT_HEIGHT = 20;
    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_MINES_QUANTITY = 50;
    
    public static void main(String[] args) {
        Map map = new Map(DEFAULT_HEIGHT, DEFAULT_WIDTH, DEFAULT_MINES_QUANTITY);
    }

}
