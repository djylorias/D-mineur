package main.java.model.Cells;

import main.java.model.Map;

/**
 * Mine of the game.
 * @since 0.6
 */
public class MineCell extends BlankCell{

    Map map = null;

    public MineCell(Map map, int x, int y){
        super(x, y);
        this.map = map;
    }

    public void action() {
        map.explosion();
    }

}