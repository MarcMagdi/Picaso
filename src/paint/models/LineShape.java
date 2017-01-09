package paint.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**.
 * @author Marc Magdi
 */
public class LineShape extends PolygonShape {

	public LineShape() {
		this.minimumNumberOfVericesToDraw = 2;
		this.minimumNumberOfPointsToDraw = 2;
	}

}
