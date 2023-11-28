package main.java.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.java.MVC.Observer;
import main.java.MVC.Subject;
import main.java.model.Cells.Cell;

public class CellView extends JButton implements Observer{

    private static final String ICON_FILES_PATH = "ressource/icons/";
    private static final ImageIcon MINE = new ImageIcon(ICON_FILES_PATH+"mine50.png");
    private static final ImageIcon FLAG = new ImageIcon(ICON_FILES_PATH+"flag50.png");

    Cell cell = null;

    public CellView(Cell cell){
        this.cell=cell;
        setSize(50, 50);
        addMouseListener(new CellMouseListener(cell));
        update((Subject) cell);
    }

    public void update(Subject subj) {
        this.cell = (Cell) subj;
    }

    public void update(Subject subj, Object data) {
        updateFlag();
        updateDiscovered();
    }

    public void updateFlag(){
        if(cell.isFLagged()) setIcon(FLAG);
        else setIcon(null);
    }

    public void updateDiscovered(){
        if(cell.isDiscovered()){ 
            cell.action();
            if(cell.getClass().getSimpleName().equals("MineCell")) setIcon(MINE);
            else setText(cell.getMineCounter()+"");
        }
    }

}
