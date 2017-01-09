package paint.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import paint.DTO.FormatingData;
import paint.models.ShapePicaso;
/**.
 * @author Marc Magdi
 */
public class BorderPaneController implements Initializable {

	@FXML
	MenuController menuController;

	@FXML
	ShapesPanelController shapesPanelController;

	@FXML
	DrawingAreaController drawingAreaController;

	@FXML
	ControllersController controllersController;

	@FXML
	FormattingPanelController formatingPanelController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shapesPanelController.init(this);
		drawingAreaController.init(this);
		controllersController.init(this);
		formatingPanelController.init(this);
		menuController.init(this);
	}

	public void setActiveClass(Class currentlyBeingDrawed) throws Exception {
		drawingAreaController.setCurrentlyDrawnShape(currentlyBeingDrawed);
	}

	public void passCurrentState(int currentState) {
		drawingAreaController.setCurrentState(currentState);
	}

	public FormatingData getFormatingDataFromFormatingPanel() {
		return formatingPanelController.getFormatingData();
	}

	public void undo() {
		drawingAreaController.undo();
	}

	public void redo() {
		drawingAreaController.redo();
	}

	public void addNewClasses(List<Class<?>> newShapeClasses) {
		this.shapesPanelController.addShapes(newShapeClasses);
	}

	/**.
	 * Get the all shapes for saving them
	 * @return list of all current shapes
	 */
	public List<ShapePicaso> getAllShapes() {
		return this.drawingAreaController.getAllShapes();
	}

	public void loadShapes(List<ShapePicaso> shapes) {
		drawingAreaController.loadShapesFromFile(shapes);
	}
}
