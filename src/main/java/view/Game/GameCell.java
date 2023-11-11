package view.Game;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import map.Cell;
import map.CellState;
import view.Listeners.MineActionListener;
import view.Listeners.NumberActionListener;
import view.Listeners.NumberMouseListener;

public class GameCell extends JButton{

    private Cell cell;

    private static final String ICON_FILES_PATH = "ressource/icons/";
    private static final ImageIcon MINE = new ImageIcon(ICON_FILES_PATH+"mine50.png");
    private static final ImageIcon FLAG = new ImageIcon(ICON_FILES_PATH+"flag50.png");

    public GameCell(Cell cell){
        this.cell=cell;
        setSize(50, 50);
        initRole();
    }

    private void initRole(){
        CellState state = cell.getState();
        if(state.equals(CellState.NUMBER)) initNumber();
        if(state.equals(CellState.MINE)) initMine();
        else initBorder();
    }

    private void initNumber(){
        //this.setIcon(FLAG);
        this.addActionListener(new NumberActionListener(this));
        this.addMouseListener(new NumberMouseListener(this));
    }

    private void initMine(){
        this.setIcon(MINE);
        this.addActionListener(new MineActionListener());
    }
    
    private void initBorder(){

    }

    public void setFlag(){
        if(this.cell.getState()==CellState.NUMBER) this.cell.setState(CellState.FLAGED_NUMBER);
        else this.cell.setState(CellState.FLAGED_MINE);
        this.setIcon(FLAG);
    }

    public void clearFlag(){
        this.setIcon(null);
    }

    public Cell getCell() {
        return cell;
    }

}
