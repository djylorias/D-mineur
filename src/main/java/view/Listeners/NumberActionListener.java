package view.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Game.GameCell;
import view.Game.GameFrame;

public class NumberActionListener implements ActionListener{

    private GameCell gc;

    public NumberActionListener(GameCell gc){
        this.gc = gc;
    }
    
    public void actionPerformed(ActionEvent e) {
        GameFrame.numberDiscovered(gc);
        gc.setFlag();
    }

}
