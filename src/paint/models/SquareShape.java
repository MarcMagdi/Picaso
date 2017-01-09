package paint.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import paint.DTO.SymmetricCoordinates;
import paint.helpers.SymmetricalShapesHelper;
/**.
 * @author Marc Magdi
 */
public class SquareShape extends RectangleShape {

    /**
     * Empty Constructor.
     */
    public SquareShape() {

    }

	@Override
    public void updateDrawableShape(final Point point, final int index) {
    	this.updateShapeVertices(point, index);
    }

	private void updateShapeVertices(final Point point, final int index) {

		double prevX = this.polygon.getPoints().get(index + 2);
		double prevY = this.polygon.getPoints().get(index + 3);
		double deltaX = point.getX() - prevX;
		double deltaY = point.getY() - prevY;
		double delta = Math.min(deltaX, deltaY);

    	// index refers to the x of the second point
    	this.polygon.getPoints().set(index,
    			this.polygon.getPoints().get(index) + delta);

    	// index refers to the x of the third point
    	this.polygon.getPoints().set(index + 2,
    			this.polygon.getPoints().get(index + 2) + delta);

    	// index refers to the y of the third point
    	this.polygon.getPoints().set(index + 3,
    			this.polygon.getPoints().get(index + 3) + delta);

    	// index refers to the y of the forth point
    	this.polygon.getPoints().set(index + 5,
    			this.polygon.getPoints().get(index+5)+delta);
    }
	
	@Override
	public void resizeDragging(double x, double y) {
		double scaleX = resizeRectangle.getScaleX();
    	double scaleY = resizeRectangle.getScaleY();
    	if(getxLSetted()) {
    		double deltaX = x - getPrevX();
    		double newScale = (scaleX
        			* ((resizeRectangle.getLayoutBounds().getWidth() / 2) - deltaX));
        	newScale /= (resizeRectangle.getLayoutBounds().getWidth() / 2);
        	shape.setScaleX(newScale);
        	shape.setScaleY(newScale);
        	resizeRectangle.setScaleX(newScale);
        	resizeRectangle.setScaleY(newScale);
    	} else if(getxRSetted()) {
    		double deltaX = x - getPrevX();
    		double newScale = (scaleX
        			* ((resizeRectangle.getLayoutBounds().getWidth() / 2) + deltaX));
        	newScale /= (resizeRectangle.getLayoutBounds().getWidth() / 2);
        	shape.setScaleX(newScale);
        	shape.setScaleY(newScale);
        	resizeRectangle.setScaleX(newScale);
        	resizeRectangle.setScaleY(newScale);
    	} else if(getyBSetted()) {
    		double deltaY = y - getPrevY();
    		double newScale = (scaleY
                    * ((resizeRectangle.getLayoutBounds().getHeight() / 2) - deltaY));
    		newScale /= (resizeRectangle.getLayoutBounds().getHeight() / 2);
        	shape.setScaleY(newScale);
        	shape.setScaleX(newScale);
        	resizeRectangle.setScaleX(newScale);
        	resizeRectangle.setScaleY(newScale);
    	} else if(getyTSetted()) {
    		double deltaY = y - getPrevY();
    		double newScale = (scaleY
                    * ((resizeRectangle.getLayoutBounds().getHeight() / 2) + deltaY));
    		newScale /= (resizeRectangle.getLayoutBounds().getHeight() / 2);
        	shape.setScaleX(newScale);
        	shape.setScaleY(newScale);
        	resizeRectangle.setScaleX(newScale);
        	resizeRectangle.setScaleY(newScale);
    	}
	}
}
