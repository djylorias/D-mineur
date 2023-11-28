package main.java.model.Cells;

/**
 * Independance to get an action() method.
 * @since 0.6
 */
public interface Cell {
    
    public void action();
    public void discover();
    public void flag();
    public boolean isDiscovered();
    public boolean isFLagged();
    public int getX();
    public int getY();
    public int getMineCounter();
    public void increaseMineCounter();

}
