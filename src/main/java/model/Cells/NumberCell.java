package main.java.model.Cells;

import main.java.model.Map;

public class NumberCell extends BlankCell {

    Map map = null;

    public NumberCell(int x, int y){
        super(x, y);
    }

    public void action() {
        discover();
        notifyObservers();
    }
    
}
