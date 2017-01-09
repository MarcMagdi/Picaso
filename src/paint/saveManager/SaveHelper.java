package paint.saveManager;

import java.util.ArrayList;
import java.util.List;

import paint.models.ShapePicaso;

/**.
 * Save Helper Class
 * @author Marc Magdi
 *
 */
public class SaveHelper {

	public List<SavableShape> getSerializedList(List<ShapePicaso> shapes) {
		List<SavableShape> savableShapes = new ArrayList<SavableShape>();
		for (int i = 0; i < shapes.size(); i++) {
			savableShapes.add(shapes.get(i).getSavableShape());
		}

		return savableShapes;
	}
}
