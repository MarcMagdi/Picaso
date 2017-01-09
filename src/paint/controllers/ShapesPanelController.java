package paint.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import paint.services.ClassesFetchingService;

/**
 * . The controller of the panel of the left containing all the shapes
 * 
 * @author Bishoy Nader & Marc Magdi
 *
 */
public class ShapesPanelController implements Initializable {

	/**
	 * . The VBox containing the shapes buttons
	 */
	@FXML
	private VBox leftMenu;

	/**
	 * . Reference to the parent controller, the Border Pane Controller
	 */
	private BorderPaneController borderPaneController;

	/**
	 * . set the controller to the main controller
	 * 
	 * @param borderPaneController
	 *            the main border controller
	 */
	public final void init(final BorderPaneController borderPaneController) {
		this.borderPaneController = borderPaneController;
	}

	/**
	 * . Load all the available shapes Creates their buttons, and assign them
	 * event handlers
	 */
	@Override
	public final void initialize(final URL arg, final ResourceBundle arg1) {
		List<Class<?>> nonAbstractClasses = ClassesFetchingService.getModelClasses();
		this.addShapes(nonAbstractClasses);
	}

	public final void addShapes(List<Class<?>> nonAbstractClasses) {
		for (int i = 0; i < nonAbstractClasses.size(); i++) {
			Button btn = this.createButtonAndSetHandler(nonAbstractClasses.get(i));
			leftMenu.getChildren().add(btn);
		}
	}

	/**
	 * . Create a button with the text of the class name text
	 * 
	 * @param classObject
	 *            the class object containing the button name
	 * @return the button object after it's creation
	 */
	private Button createButtonAndSetHandler(final Class<?> classObject) {
		Button btn = new Button(classObject.getSimpleName());
		this.setButtonClickHandler(btn, classObject);
		return btn;
	}

	/**
	 * . Set a click event handler for the button that update the border pane
	 * controller active class to the current shape
	 * 
	 * @param btn
	 *            the button to assign the event handler
	 * @param classObject
	 *            the class to assign to the border controller as active class
	 */
	private void setButtonClickHandler(final Button btn, final Class<?> classObject) {
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				try {
					borderPaneController.setActiveClass(classObject);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
