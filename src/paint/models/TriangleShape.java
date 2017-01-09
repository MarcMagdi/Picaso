package paint.models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**.
 * @author Marc Magdi
 */
public class TriangleShape extends PolygonShape {

    public TriangleShape() {
        this.minimumNumberOfVericesToDraw = 3;
        this.minimumNumberOfPointsToDraw = 3;
    }
}
