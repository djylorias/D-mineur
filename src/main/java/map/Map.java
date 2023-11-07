package map;

import java.util.Random;

public class Map {

    private static Random random = new Random();
    private static final FrameState[] POSSIBLE_MAP_STATEMENT = new FrameState[]{FrameState.NUMBER, FrameState.MINE};

    private static final int DEFAULT_HEIGHT = 30;
    private static final int DEFAULT_WIDTH = 20;
    
    private int height;
    private int width;

    private Frame[][] map;

    public Map(){
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    public Map(int heigth, int width){
        this.height = heigth;
        this.width = width;
        generateMap();
    }

    private void generateMap(){
        System.out.println("generating map...");
        map = new Frame[height][width];
        for(int x=0;x<height;x++){
            System.out.println("generating row "+x+"...");
            for(int y=0;y<width;y++){
                map[x][y] = generateFrame(x, y);
                //System.out.print(y+""+map[x][y].getState().name()+", ");
            }
        }
    }

    private Frame generateFrame(int x, int y){
        Frame frame = new Frame(x, y);
        if(isBorder(frame)) frame.setState(FrameState.BORDER);
        else{
            if(canBeMine(frame)) frame.setState(getRandomState());
            else frame.setState(FrameState.MINE);
        }
        return frame;
    }

    private boolean isBorder(Frame frame){
        int x = frame.getCoord().getX();
        int y = frame.getCoord().getY();
        return (x==0 || x==height-1 || y==0 || y==width-1);
    }

    private boolean canBeMine(Frame frame){
        countProximityBombs(frame);
        if(frame.mineCounter>=4) return false;
        else return true;
    }

    private void countProximityBombs(Frame frame){
        int x = frame.getCoord().getX();
        int y = frame.getCoord().getY();
        for(int i=x-1;i<x+1;i++){
            for(int j=y-1;j<y+1;j++){
                if(map[i][j]!=null && map[i][j].getState()==FrameState.MINE) frame.mineCounter++;
            }
        }
    }

    private FrameState getRandomState(){
        return POSSIBLE_MAP_STATEMENT[random.nextInt(POSSIBLE_MAP_STATEMENT.length)];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Frame[][] getMap() {
        return map;
    }

}
