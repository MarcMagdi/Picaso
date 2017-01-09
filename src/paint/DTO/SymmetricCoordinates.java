package paint.DTO;

import javax.swing.DefaultBoundedRangeModel;
/**.
 * @author Marc Magdi
 */
public class SymmetricCoordinates {

    /**
     * X Coordinate of the fixed point.
     */
    private int minX;

    /**
     * Y Coordinate of the fixed point.
     */
    private int minY;

    /**
     * X Coordinate of the relative point.
     */
    private int maxX;

    /**
     * Y Coordinate of the relative point.
     */
    private int maxY;

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    /**
     * Overloaded Constructor.
     * @param minX X Coordinate of the fixed point.
     * @param minY Y Coordinate of the fixed point.
     * @param maxX X Coordinate of the relative point.
     * @param maxY Y Coordinate of the relative point.
     */
    public SymmetricCoordinates(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Default Constructor.
     */
    public SymmetricCoordinates() {
    }
}
