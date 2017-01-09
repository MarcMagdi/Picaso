package paint.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import paint.DTO.SymmetricCoordinates;
import paint.helpers.SymmetricalShapesHelper;

/**.
 * @author Marc Magdi
 */
public class CircleShape extends ElipseShape {

    public CircleShape() {

    }

    @Override
    public void updateDrawableShape(final Point point, final int index) {
    	int x = (int) (2 * ellipse.getCenterX() - point.getX());
		int y = (int) (2 * ellipse.getCenterY() - point.getY());

		Point fixedPoint = new Point(x, y);

		Point relativePoint = new Point((int) point.getX(),
				(int) point.getY());
		Point ellipseCenter = new Point();

		double radiusX = (Math.abs(fixedPoint.getX()
				- relativePoint.getX()) / 2);
		double radiusY = (Math.abs(fixedPoint.getY()
        		- relativePoint.getY()) / 2);

    	ellipseCenter.x = (int) (Math.min(fixedPoint.getX(),
    			relativePoint.getX()) + radiusX);
    	ellipseCenter.y = (int) (Math.min(fixedPoint.getY(),
    			relativePoint.getY()) + radiusY);

    	double minRadius = Math.min(radiusX, radiusY);
    	this.updateEllipseRadiusCenter(minRadius, minRadius, ellipseCenter);
    }

    private void updateEllipseRadiusCenter(double radiusX, double radiusY, Point center) {
    	ellipse.setRadiusX(radiusX);
    	ellipse.setRadiusY(radiusY);
    	ellipse.setCenterX(center.getX());
    	ellipse.setCenterY(center.getY());
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
