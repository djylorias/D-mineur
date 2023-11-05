package map;

public class Map {

    private static final int DEFAULT_HEIGHT = 50;
    private static final int DEFAULT_WIDTH = 40;
    
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
        map = new Frame[height][width];
        for(int x=0;x<height;x++){
            for(int y=0;y<width;y++){
                map[x][y] = generateFrame(x, y);
            }
        }
    }

    private Frame generateFrame(int x, int y){
        return null; //TODO
    }

}
