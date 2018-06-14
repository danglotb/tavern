package fr.inria.stamp.map;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 14/06/18
 */
public class Map {

    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isInMap(int x, int y) {
        return x >= 0 && x < width &&
                y >= 0 && y < height;
    }

    public boolean canMoveTo(int xFrom, int yFrom, int offsetX, int offsetY) {
        return isInMap(xFrom + offsetX, yFrom + offsetY);
    }

    public int[] getNewPositionIfMoveFromTo(int xFrom, int yFrom, int offsetX, int offsetY) {
        int newX = xFrom + offsetX;
        if (newX < 0){
            newX += this.width;
        }
        int newY = yFrom + offsetY;
        if (newY < 0){
            newY += this.height;
        }
        return new int[]{newX, newY};
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
