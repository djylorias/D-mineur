package view.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Game.GameFrame;

public class MineActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        GameFrame.mineExplode();
    }
    
}
