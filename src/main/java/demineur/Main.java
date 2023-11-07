package demineur;

import map.Map;
import view.DemFrame;

/**
 * @version 0.1
 */

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        DemFrame frame = new DemFrame(map);
        frame.show();
    }
}