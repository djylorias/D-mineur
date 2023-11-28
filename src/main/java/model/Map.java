package main.java.model;

import java.util.Random;

import main.java.model.Cells.*;

/**
 * The map of the game
 * @since 0.6
 */
public class Map {

    private static final Random random = new Random();
    
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
     * The map; Composed of cells wich can be a mine, a number or a border.
     */
    private Cell[][] map = null;

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
        generateBlankMap();
        generateMines();
        System.out.println("Map created succesfuly");
    }

    private void generateBlankMap(){
        System.out.println("generating map...");
        map = new Cell[height][width];
        for(int x=0;x<height;x++){
            System.out.println("generating row "+x+"...");
            for(int y=0;y<width;y++){
                map[x][y] = generateCell(x, y);
            }
        }
    }

    private Cell generateCell(int x, int y){
        if(isBorder(x, y)) return new BorderCell(x, y);
        else return new NumberCell(this, x, y);
    }

    private boolean isBorder(int x, int y){
        return (x==0 || x==height-1 || y==0 || y==width-1);
    }

    private void generateMines(){
        System.out.println("Generating mines...");
        boolean mineInserted;
        Coordinate coord = null;
        for(int i=0;i<mines_quantity;i++){
            mineInserted = false;
            while(!mineInserted){
                coord = new Coordinate(random.nextInt(this.height), random.nextInt(this.width));
                if(insertMine(coord)) mineInserted = true;
            }
        }
        System.out.println();
    }

    private boolean insertMine(Coordinate coord){
        if(canBeMine(getCell(coord))){
            int x = coord.getX();
            int y = coord.getY();
            this.map[x][y] = new MineCell(this, x, y);
            increaseProximityCounter(coord);
            System.out.print("|");
            return true;
        }
        else return false;
    }

    private boolean canBeMine(Cell cell){
        if(isBorder(cell) || isMine(cell)) return false;
        if(countProximityBombs(cell)>=4) return false;
        else return true;
    }

    private int countProximityBombs(Cell cell){
        int res = 0;
        int x = cell.getX();
        int y = cell.getY();
        for(int i=x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){
                if(map[i][j]!=null && isMine(map[i][j])) res++;
            }
        }
        return res;
    }

    private void increaseProximityCounter(Coordinate coord){
        int x = coord.getX();
        int y = coord.getY();
        for(int i=(x-1);i<=(x+1);i++){
            for(int j=(y-1);j<=(y+1);j++){
                map[i][j].increaseMineCounter();;
            }
        }
    }

    public Cell getCell(Coordinate coord){
        if(map==null) return null;
        else return map[coord.getX()][coord.getY()];
    }

    public void discovered(Coordinate coord){
        map[coord.getX()][coord.getY()].discover();
    }

    public boolean isMine(Cell cell){
        return getCellType(cell).equals("MineCell");
    }

    public boolean isBorder(Cell cell){
        return getCellType(cell).equals("BorderCell");
    }

    public String getCellType(Cell cell){
        return cell.getClass().getSimpleName();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getMap() {
        return map;
    }

}
