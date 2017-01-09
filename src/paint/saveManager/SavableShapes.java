package paint.saveManager;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**.
 * The list to save as serialized
 * @author Marc Magdi
 *
 */
@XmlRootElement
public class SavableShapes {
	private List<SavableShape> shapes;

	public SavableShapes() {
	}
	
	public SavableShapes(List<SavableShape> shapesParam) {
		this.setShapesList(shapesParam);
	}

	@XmlElement(name = "ShapePica")
	public void setShapesList(List<SavableShape> shapesList) {
		this.shapes = shapesList;
	}

	public List<SavableShape> getShapesList() {
		return this.shapes;
	}
}
