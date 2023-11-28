package main.java.view;

import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.java.model.Map;
import main.java.model.Cells.Cell;

public class MapView extends JFrame {
    
    private JFrame frame = null;

    private List<CellView> cells = new ArrayList<>();

    public MapView(Map map){

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
        for(Cell[] line : map.getMap()){
            for(Cell cell : line) frame.add(createIconedButton(cell));
        }
    }

    public CellView createIconedButton(Cell cell){
        CellView res = new CellView(cell);
        cell.attach(res);
        cells.add(res);
        return res;
    }

}
