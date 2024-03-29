package paint.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**.
 * @author Marc Magdi
 */
public class RectangleShape extends PolygonShape {

	public RectangleShape() {
		this.minimumNumberOfVericesToDraw = 2;
		this.minimumNumberOfPointsToDraw = 4;
	}

	@Override
    public void updateDrawableShape(final Point point, final int index) {
    	this.updateShapeVertices(point, index);
    }

    private void updateShapeVertices(final Point point, final int index) {

    	// index refers to the x of the second point
    	this.polygon.getPoints().set(index, point.getX());

    	// index refers to the x of the third point
    	this.polygon.getPoints().set(index + 2, point.getX());

    	// index refers to the y of the third point
    	this.polygon.getPoints().set(index + 3, point.getY());

    	// index refers to the y of the forth point
    	this.polygon.getPoints().set(index + 5, point.getY());
    }

	@Override
	public List<Double> getPoints() {
		List<Double> ret = new ArrayList<Double>();
		ret.add(polygon.getPoints().get(0));
		ret.add(polygon.getPoints().get(1));
		ret.add(polygon.getPoints().get(4));
		ret.add(polygon.getPoints().get(5));
		return ret;
	}

}
