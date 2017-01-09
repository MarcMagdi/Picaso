package paint.saveManager;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**.
 * @author Marc Magdi
 */
@XmlRootElement
public class SavableShape {

	private String className;

	private List<Double> points;

    /**.
     * The size of the stroke around the shape
     */
	private int strokeSize;

    /**.
     * The color of the stroke around the shape
     */
    private String strokeColor;

    /**.
     * The color of the shape.
     */
    private String fillColor;

    public int getStrokeSize() {
        return strokeSize;
    }

    @XmlElement
    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    @XmlElement
    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    @XmlElement
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

	public String getClassName() {
		return className;
	}

	@XmlElement
	public void setClassName(String className) {
		this.className = className;
	}

	public List<Double> getPoints() {
		return points;
	}

	@XmlElement
	public void setPoints(List<Double> points) {
		this.points = points;
	}
}
