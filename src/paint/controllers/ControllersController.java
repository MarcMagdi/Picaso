package paint.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import paint.utilities.Constants;
/**.
 * @author Marc Magdi
 */
public class ControllersController implements Initializable {

	@FXML
	private VBox topMenu;

	@FXML
	private Button drawButton;

	@FXML
	private Button moveButton;

	@FXML
	private Button resizeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button undoButton;

	@FXML
	private Button redoButton;

    /**.
     * Reference to the parent controller, the Border Pane Controller
     */
    private BorderPaneController borderPaneController;

    /**.
     * set the controller to the main controller
     * @param borderPaneParam the main border controller
     */
    public final void init(final BorderPaneController borderPaneParam) {
        this.borderPaneController = borderPaneParam;
    }

	@Override
	public void initialize(final URL location,
			final ResourceBundle resources) {
		drawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.passCurrentState(Constants.STATE_DRAWING);
            }
        });
		moveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.passCurrentState(Constants.STATE_MOVING);
            }
        });
		resizeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.passCurrentState(Constants.STATE_RESIZING);
            }
        });
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.passCurrentState(Constants.STATE_DELETING);
            }
        });
		undoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.undo();
            }
        });
		redoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                borderPaneController.redo();
            }
        });
	}
}
