package map;

public class Frame {
    
    private Coordinate coord;
    private FrameState state;
    public int mineCounter;

    public Frame(int x, int y){
        this(new Coordinate(x, y), null);
    }

    public Frame(int x, int y, FrameState state){
        this(new Coordinate(x, y), state);
    }

    public Frame(Coordinate coord, FrameState state){
        this.coord = coord;
        this.state = state;
        this.mineCounter = 0;
    }

    public void setState(FrameState state) {
        this.state = state;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public FrameState getState() {
        return state;
    }

    public boolean equals(Frame o){
        if(o==null) return false;
        if(!getCoord().equals(o.getCoord())) return false;
        if(getState()!=o.getState()) return false;
        else return true;
    }

}
