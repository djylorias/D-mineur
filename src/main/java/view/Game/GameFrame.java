package view.Game;

import javax.swing.JFrame;
import javax.swing.JLabel;

import map.Cell;
import map.Map;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class GameFrame {
    
    private JFrame frame = null;

    private List<GameCell> buttons = new ArrayList<>();

    public GameFrame(Map map){

        JLabel label = new JLabel();
        label.setText("c'est le jeu du démineur !");

        frame = new JFrame();
        frame.setTitle("Démineur");
        frame.setSize(map.getWidth()*50,map.getHeight()*50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.setLayout(new GridLayout(map.getHeight(), map.getWidth()));
        insertFrames(map);

        System.out.println(frame.getLayout());

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

    public GameCell createIconedButton(Cell cell){
        GameCell res = new GameCell(cell);
        res.addActionListener(e -> System.out.println(cell.mineCounter));
        
        buttons.add(res);
        return res;
    }

    public static void mineExplode(){
        
    }

    public static void numberDiscovered(GameCell gc){
        System.out.println(gc.getCell().getCoord());
    }

}
