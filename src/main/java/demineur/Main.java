package demineur;

import map.Map;
import view.Game.GameFrame;

/**
 * @version 0.5
 */

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        GameFrame frame = new GameFrame(map);
        frame.show();
    }
}