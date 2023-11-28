package main.java.model.Cells;

import main.java.MVC.Observer;

/**
 * Independance to get an action() method.
 * @since 0.6
 */
public interface Cell{
    
    public static final String ICON_FILES_PATH = "ressource/icons/";

    public void action();
    public void discover();
    public void flag();
    public void unflag();
    public boolean isDiscovered();
    public boolean isFLagged();
    public int getX();
    public int getY();
    public int getMineCounter();
    public void increaseMineCounter();
    public void attach(Observer observer);

}
