package view.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.Game.GameCell;

public class NumberMouseListener implements MouseListener{

    boolean pressed;
    GameCell gc;

    public NumberMouseListener(GameCell gc){
        this.gc = gc;
    }

    public void mouseClicked(MouseEvent e) {
        // gc.getModel().setArmed(true);
        // gc.getModel().setPressed(true);
        pressed = true;
    }

    public void mousePressed(MouseEvent e) {
        // gc.getModel().setArmed(false);
        // gc.getModel().setPressed(false);
        if (pressed) {
            if (SwingUtilities.isRightMouseButton(e)) {
                gc.setFlag();
            }
            else {
                gc.clearFlag();
                gc.setText(gc.getCell().mineCounter+"");
            }
        }
            pressed = false;
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        pressed = false;
    }

    public void mouseExited(MouseEvent e) {
        pressed = true;
    }
    
}
