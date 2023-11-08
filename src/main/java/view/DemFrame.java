package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import map.Frame;
import map.FrameState;
import map.Map;

import java.awt.GridLayout;

public class DemFrame {
    
    private JFrame frame = null;

    private static final String ICON_FILES_PATH = "ressource/icons/";
    private static final ImageIcon MINE = new ImageIcon(ICON_FILES_PATH+"mine.png");
    private static final ImageIcon FLAG = new ImageIcon(ICON_FILES_PATH+"flag.png");

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
                frame.add(createIconedButton(map.getMap()[i][j]));
            }
        }
    }

    public JButton createIconedButton(Frame frame){
        FrameState state = frame.getState();
        JButton res = new JButton();
        res.setSize(50, 50);
        res.addActionListener(e -> System.out.println(frame.mineCounter));
        if(state.equals(FrameState.NUMBER)) res.setIcon(FLAG);
        if(state.equals(FrameState.MINE)) res.setIcon(MINE);
        return res;
    }

}
