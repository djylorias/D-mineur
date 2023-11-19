package map;

import Exceptions.CantBeFLaggedException;
import Exceptions.CantBeUnflaggedException;

public enum CellState {
    
    NUMBER,
    MINE,
    FLAGED_NUMBER,
    FLAGED_MINE,
    BORDER;

    public static boolean isFlagged(CellState cs){
        if(cs==FLAGED_MINE || cs==FLAGED_NUMBER) return true;
        else return false;
    }

    public static boolean isFlagged(Cell cell){
        return isFlagged(cell.getState());
    }

    public static CellState getUnflaggedOf(CellState cs) throws CantBeUnflaggedException {
        if(cs==FLAGED_NUMBER) return NUMBER;
        else if(cs==FLAGED_MINE) return MINE;
        else throw new CantBeUnflaggedException("This states can't be unflagged.");
    }

    public static CellState getFlaggedOf(CellState cs) throws CantBeFLaggedException{
        if(cs==NUMBER) return FLAGED_NUMBER;
        else if(cs==MINE) return FLAGED_MINE;
        else throw new CantBeFLaggedException("This states can't be flagged");
    }

}
