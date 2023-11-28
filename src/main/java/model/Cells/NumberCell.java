package main.java.model.Cells;

import main.java.model.Map;

public class NumberCell extends BlankCell {

    Map map = null;

    public NumberCell(Map map, int x, int y){
        super(x, y);
        this.map = map;
    }

    public void action() {

    }
    
}
