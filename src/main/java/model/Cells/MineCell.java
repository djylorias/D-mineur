package main.java.model.Cells;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.java.model.Map;

/**
 * Mine of the game.
 * @since 0.6
 */
public class MineCell extends BlankCell{

    private static final ImageIcon ICON = new ImageIcon(ICON_FILES_PATH+"mine50.png");
    Map map = null;

    public MineCell(Map map, int x, int y){
        super(x, y);
        this.map = map;
    }

    public void action() {
        map.explosion();
    }

    public Icon getIcon(){
        return ICON;
    }

}