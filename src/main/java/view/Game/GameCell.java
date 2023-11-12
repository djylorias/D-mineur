package view.Game;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Exceptions.CantBeFLaggedException;
import Exceptions.CantBeUnflaggedException;
import map.Cell;
import map.CellState;
import view.Listeners.MineActionListener;
import view.Listeners.NumberActionListener;
import view.Listeners.NumberMouseListener;

public class GameCell extends JButton{

    private Cell cell;
    private Font font = null;

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
        this.addActionListener(new NumberActionListener(this));
        this.addMouseListener(new NumberMouseListener(this));
    }

    private void initMine(){
        this.setIcon(MINE);
        this.addActionListener(new MineActionListener());
    }
    
    private void initBorder(){

    }

    public void updateFlag() throws CantBeUnflaggedException, CantBeFLaggedException{
        CellState current_state = this.cell.getState();
        if(CellState.isFlagged(current_state)){
            this.cell.setState(CellState.getUnflaggedOf(current_state));
            this.setIcon(null);
        }
        else{
            this.cell.setState(CellState.getFlaggedOf(current_state));
            this.setIcon(FLAG);
        }
    }

    public void clearFlag(){
        this.setIcon(null);
    }

    public Cell getCell() {
        return cell;
    }

}
