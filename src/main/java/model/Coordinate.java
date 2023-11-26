package main.java.model;

public class Coordinate {
    
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Coordinate o) {
        if(o==null) return false;
        if(o.getX()!=getX()) return false;
        if(o.getY()!=getY()) return false;
        else return true;
    }

    public String toString(){
        return "x:"+x+" | y:"+y;
    }

}
