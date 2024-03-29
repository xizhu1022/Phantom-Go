package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Coord implements Serializable {
    int x, y;
    transient private int[][] near4Coords = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    transient private int[][] near8Coords = {
            {+1, 0}, {+1, +1}, {0, +1}, {-1, +1},
            {-1, 0}, {-1, -1}, {0, -1}, {+1, -1}
    };
    transient private int[][] near16Coords = {
            {-2, 2}, {-1, 2}, {0, 2}, {1, 2},
            {2, 2}, {2, 1}, {2, 0}, {2, -1},
            {2, -2}, {1, -2}, {0, -2}, {-1, -2},
            {-2, -2}, {-2, -1}, {-2, 0}, {-2, 1}
    };

    @Override
    protected Coord clone() throws CloneNotSupportedException {
        return ((Coord) super.clone());
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coord(Coord coord) {
        x = coord.x;
        y = coord.y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %s)", y+1, (char) (x + 'A'));
    }

    public String toNumString(){
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object obj) { return obj instanceof Coord && equals((Coord) obj); }

    static boolean isCoordLegal(int x, int y) {
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    static boolean equals(Coord a, Coord b) {
        return a.x == b.x && a.y == b.y;
    }


    boolean equals(Coord coord) {
        return x == coord.x && y == coord.y;
    }

    boolean isLegal(){
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    private List<Coord> getNearCoord(int[][] paras, boolean isLegal) {
        List<Coord> nearCoords = new ArrayList<>();
        for (int[] para : paras) {
            Coord temp = new Coord(x + para[0], y + para[1]);
            if (isLegal) {
                if (temp.isLegal()) nearCoords.add(temp);
            } else {
                nearCoords.add(temp);
            }
        }
        return nearCoords;
    }

    List<Coord> getNear4Coord(boolean onlyLegal) { return getNearCoord(near4Coords, onlyLegal); }

    List<Coord> getNear8Coord(boolean onlyLegal) { return getNearCoord(near8Coords, onlyLegal); }

    List<Coord> getNear16Coord(boolean onlyLegal) { return getNearCoord(near16Coords,onlyLegal); }
}
