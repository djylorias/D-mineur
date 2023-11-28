package main.java.model.Cells;

public class BorderCell extends BlankCell {

    public BorderCell(int x, int y){
        super(x, y);
    }

    public void action() {
        System.out.println("Border "+getX()+" "+getY()+" clicked");
    }
    
}
