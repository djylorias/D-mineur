package main.java.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import main.java.model.Cells.Cell;

public class CellMouseListener implements MouseListener{

    boolean pressed;
    Cell cell = null;

    public CellMouseListener(Cell cell){
        this.cell = cell;
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        if(cell.isDiscovered()) System.out.println("Cell already discovered.");
        else if(pressed && SwingUtilities.isRightMouseButton(e)){
            if(!cell.isFLagged()) cell.flag();
            else cell.unflag();
        }
        else if(pressed && SwingUtilities.isLeftMouseButton(e) && !cell.isFLagged()){
            cell.action();
        }
        pressed = false;
    }

    public void mouseEntered(MouseEvent e) {
        pressed = false;
    }

    public void mouseExited(MouseEvent e) {
        pressed = true;
    }
    
}
