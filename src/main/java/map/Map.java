package map;

import java.util.Random;

public class Map {

    private static Random random = new Random();

    private static final int DEFAULT_HEIGHT = 20;
    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_MINES_QUANTITY = 50;
    
    private int height;
    private int width;
    private int mines_quantity;

    private Cell[][] map;

    public Map(){
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH, DEFAULT_MINES_QUANTITY);
    }

    public Map(int mines_quantity){
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH, mines_quantity);
    }

    public Map(int height, int width){
        this(height, width, DEFAULT_MINES_QUANTITY);
    }

    public Map(int heigth, int width, int mines_quantity){
        this.height = heigth;
        this.width = width;
        this.mines_quantity = mines_quantity;
        generateBlankMap();
        generateMines();
    }

    private void generateBlankMap(){
        System.out.println("generating map...");
        map = new Cell[height][width];
        for(int x=0;x<height;x++){
            System.out.println("generating row "+x+"...");
            for(int y=0;y<width;y++){
                map[x][y] = generateCell(x, y);
                //System.out.print(y+""+map[x][y].getState().name()+", ");
            }
        }
    }

    private Cell generateCell(int x, int y){
        Cell cell = new Cell(x, y);
        if(isBorder(cell)) cell.setState(CellState.BORDER);
        else cell.setState(CellState.NUMBER);
        return cell;
    }

    private boolean isBorder(Cell cell){
        int x = cell.getCoord().getX();
        int y = cell.getCoord().getY();
        return (x==0 || x==height-1 || y==0 || y==width-1);
    }

    private void generateMines(){
        boolean mineInserted;
        Coordinate coord = null;
        for(int i=0;i<mines_quantity;i++){
            mineInserted = false;
            while(!mineInserted){
                coord = new Coordinate(random.nextInt(this.height), random.nextInt(this.width));
                if(insertMine(coord)) mineInserted = true;
            }
        }
    }

    private boolean insertMine(Coordinate coord){
        if(canBeMine(getCell(coord))){
            this.map[coord.getX()][coord.getY()].setState(CellState.MINE);
            return true;
        }
        else return false;
    }

    private boolean canBeMine(Cell cell){
        if(cell.getState()==CellState.BORDER || cell.getState()==CellState.MINE) return false;
        countProximityBombs(cell);
        if(cell.mineCounter>=4) return false;
        else return true;
    }

    private void countProximityBombs(Cell cell){
        int x = cell.getCoord().getX();
        int y = cell.getCoord().getY();
        for(int i=x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){
                if(map[i][j]!=null && map[i][j].getState()==CellState.MINE) cell.mineCounter++;
            }
        }
    }

    // private CellState getRandomState(){
    //     return POSSIBLE_MAP_STATEMENT[random.nextInt(POSSIBLE_MAP_STATEMENT.length)];
    // }

    public Cell getCell(Coordinate coord){
        if(map==null) return null;
        else return map[coord.getX()][coord.getY()];
    }

    public void discovered(Coordinate coord){
        map[coord.getX()][coord.getY()].discovered();
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
