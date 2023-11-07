package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import map.Map;

import java.awt.GridLayout;

public class DemFrame {
    
    private JFrame frame = null;

    public DemFrame(Map map){

        JLabel label = new JLabel();
        label.setText("c'est le jeu du démineur !");

        frame = new JFrame();
        frame.setTitle("Démineur");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(map.getHeight(), map.getWidth()));
        insertFrames(map);

        show();

    }

    public void show(){
        frame.setVisible(true);
    }

    public void insertFrames(Map map){
        System.out.println(map.getHeight()+" "+map.getWidth());
        for(int i=0;i<map.getHeight();i++){
            for(int j=0;j<map.getWidth();j++){
                frame.add(new JButton(map.getMap()[i][j].getState().name()));
            }
        }
    }

}
