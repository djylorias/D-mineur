package main.java.model.Cells;

import main.java.MVC.Subject;
import main.java.model.Coordinate;

/**
 * A blank cell wich is none of number, mine or border.
 * @since 0.6
 */
public abstract class BlankCell extends Subject implements Cell {
    
    protected Coordinate coord = null;
    private boolean discovered = false;
    private boolean flagged = false;

    /**
     * Set the cell discovered.
     */
    public void discover(){
        discovered=true;
    }

    /**
     * Set the cell flagged.
     */
    public void flag(){
        flagged=true;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public boolean isFLagged(){
        return flagged;
    }

    public boolean equals(BlankCell o){
        if(o==null) return false;
        if(!getCoord().equals(o.getCoord())) return false;
        if(discovered!=o.isDiscovered()) return false;
        if(flagged!=o.isFLagged()) return false;
        else return true;
    }

}