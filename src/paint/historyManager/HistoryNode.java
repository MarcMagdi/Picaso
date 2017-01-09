package paint.historyManager;

import java.awt.Point;

import paint.DTO.HorizontalAndVerticalScales;
import paint.DTO.SceneCoordinates;
import paint.models.ShapePicaso;

/**.
 * The History node cell, containing the history value
 * such as old value, new value, reference to the node
 * @author Bishoy Nader & Marc Magdi
 *
 */
public class HistoryNode {
	/**.
	 * A reference to the shape that have the operation done on it
	 */
	private ShapePicaso shape;

	/**
	 * @return the shape
	 */
	public ShapePicaso getShape() {
		return shape;
	}

	/**
	 * @return the oldScene
	 */
	public SceneCoordinates getOldScene() {
		return oldScene;
	}

	/**
	 * @return the newScene
	 */
	public SceneCoordinates getNewScene() {
		return newScene;
	}

	/**.
	 * The operation done on the shape
	 */
	private int operation;

	/**.
	 * (Move) old scene
	 */
	private SceneCoordinates oldScene;

	/**.
	 * (Move) new scene
	 */
	private SceneCoordinates newScene;

	/**
	 * (Resize) old scales.
	 */
	private HorizontalAndVerticalScales oldScales;

	/**
	 * (Resize) new scales.
	 */
	private HorizontalAndVerticalScales newScales;


	/**.
	 * A private constructor to save the shape and the operation
	 * @param shape a reference to the shape that has the operation
	 * @param operation the operation indication
	 */
	public HistoryNode(ShapePicaso shape, int operationParam) {
		this.shape = shape;
		this.operation = operationParam;
	}

	/**.
	 * A constructor used with the movement of a shape
	 * @param shape a reference to the shape that has the operation
	 * @param operation the operation indication
	 * @param oldCenter the old center
	 * @param newCenter the new center
	 */
	public HistoryNode(ShapePicaso shape, int operationParam,
			SceneCoordinates newSceneParam, SceneCoordinates oldSceneParam) {
		this(shape, operationParam);
		this.oldScene = oldSceneParam;
		this.newScene = newSceneParam;
	}

	/**.
	 * A constructor used with the movement of a shape
	 * @param shape a reference to the shape that has the operation
	 * @param operationParam the operation indication
	 * @param oldScales the old scales
	 * @param newScales the new scales
	 */
	public HistoryNode(ShapePicaso shape, int operationParam,
			HorizontalAndVerticalScales newScales,
			HorizontalAndVerticalScales oldScales) {
		this(shape, operationParam);
		this.setOldScales(oldScales);
		this.newScales = newScales;
	}

	/**
	 * @return the operation
	 */
	public int getOperation() {
		return operation;
	}

	public HorizontalAndVerticalScales getNewScales() {
		return newScales;
	}

	public void setNewScales(HorizontalAndVerticalScales newScales) {
		this.newScales = newScales;
	}

	public void setNewScene(SceneCoordinates newScene) {
		this.newScene = newScene;
	}

	public HorizontalAndVerticalScales getOldScales() {
		return oldScales;
	}

	public void setOldScales(HorizontalAndVerticalScales oldScales) {
		this.oldScales = oldScales;
	}
}
