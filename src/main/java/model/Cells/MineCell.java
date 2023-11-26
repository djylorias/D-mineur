package main.java.model.Cells;

import main.java.model.Coordinate;
import main.java.model.Map;

/**
 * Mine of the game.
 * @since 0.6
 */
public class MineCell extends BlankCell{

    Map map = null;

    public MineCell(Map map, int x, int y){
        coord = new Coordinate(x, y);
        this.map = map;
    }

    public void action() {
        discover();
    }

}