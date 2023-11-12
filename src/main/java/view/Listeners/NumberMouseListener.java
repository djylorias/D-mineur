package view.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import Exceptions.CantBeFLaggedException;
import Exceptions.CantBeUnflaggedException;
import view.Game.GameCell;

public class NumberMouseListener implements MouseListener{

    boolean pressed;
    GameCell gc;

    public NumberMouseListener(GameCell gc){
        this.gc = gc;
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        if (pressed) {
            if (SwingUtilities.isRightMouseButton(e) && gc.getCell().isDiscovered()==false) {
                try {
                    gc.updateFlag();
                } catch (CantBeUnflaggedException | CantBeFLaggedException e1) {
                    System.out.println(e1.getMessage());
                }
            }
            else{
                gc.getCell().discovered();
                gc.clearFlag();
                gc.setText(gc.getCell().mineCounter+"");
            }
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
