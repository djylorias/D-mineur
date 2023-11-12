package map;

public class Cell {
    
    private Coordinate coord;
    private CellState state;
    private boolean discovered = false;
    public int mineCounter;

    public Cell(int x, int y){
        this(new Coordinate(x, y), null);
    }

    public Cell(int x, int y, CellState state){
        this(new Coordinate(x, y), state);
    }

    public Cell(Coordinate coord, CellState state){
        this.coord = coord;
        this.state = state;
        this.mineCounter = 0;
    }

    public void discovered(){
        discovered=true;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public CellState getState() {
        return state;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public boolean equals(Cell o){
        if(o==null) return false;
        if(!getCoord().equals(o.getCoord())) return false;
        if(getState()!=o.getState()) return false;
        else return true;
    }

}
