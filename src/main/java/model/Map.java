package main.java.model;

/**
 * The map of the game
 * @since 0.6
 */
public class Map {
    
    /**
     * The height of the map.
     */
    private int height;
    /**
     * The width of the map.
     */
    private int width;
    /**
     * The quantity of mines in the map.
     */
    private int mines_quantity;

    /**
     * The only constructor of this class
     * @param heigth The number of cell for the height of the map.
     * @param width The number of cell for the width of the map
     * @param mines_quantity The quantity of mine to flag.
     */
    public Map(int heigth, int width, int mines_quantity){
        this.height = heigth;
        this.width = width;
        this.mines_quantity = mines_quantity;

    }

}
