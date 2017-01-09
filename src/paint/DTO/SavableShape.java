package paint.DTO;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**.
 * @author Marc Magdi
 */
@XmlRootElement
public class SavableShape {

	public String className;
	public FormatingData formats;
	public List<Double> points;

	public SavableShape(String className, FormatingData formats) {
		super();
		this.className = className;
		this.formats = formats;
	}

	public SavableShape() {
	}


	@XmlElement
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public FormatingData getFormats() {
		return formats;
	}

	@XmlElement
	public void setFormats(FormatingData formats) {
		this.formats = formats;
	}

	@XmlElement
	public List<Double> getPoints() {
		return points;
	}

	public void setPoints(List<Double> points) {
		this.points = points;
	}
}
