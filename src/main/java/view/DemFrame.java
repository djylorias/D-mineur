package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemFrame {
    
    private JFrame frame = null;

    public DemFrame(){

        JLabel label = new JLabel();
        label.setText("c'est le jeu du démineur !");

        frame = new JFrame();
        frame.setTitle("Démineur");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void show(){
        frame.setVisible(true);
    }

}
