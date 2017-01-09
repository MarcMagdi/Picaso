
package paint.controllers;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import paint.models.ShapePicaso;
import paint.saveManager.SaveLoadHelper;
import paint.services.ClassesFetchingService;

/**.
 * The Menu controller
 * @author Bishoy Nader & Marc Magdi
 *
 */
public class MenuController implements Initializable {

	/**.
	 * The menu bar object in the FXML file
	 */
    @FXML
    private MenuBar menuBar;

    /**.
     * Save and Load module
     */
    private SaveLoadHelper saveLoadHelper;
    /**.
     * The primary stage
     */
    private Stage stage;

    /**
     * Reference to the parent of the drawing area.
     * (i.e) border pane controller
     */
    private BorderPaneController borderPaneController;

    /**.
     * Default Constructor
     */
    public MenuController() {
    	this.saveLoadHelper = new SaveLoadHelper();
    }

    /**.
     * set the controller to the main controller
     * @param borderPaneParam the main border controller
     */
    public final void init(final BorderPaneController borderPaneParam) {
        this.borderPaneController = borderPaneParam;
    }

    /**
     * Handle action related to "About" menu item.
     * @param event
     * Event on "About" menu item.
     */
    @FXML
    private void handleAboutAction(final ActionEvent event) {
        provideAboutFunctionality();
    }

    /**
     * Handle action related to input (in this case specifically only responds
     * to keyboard event CTRL-A).
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
                provideAboutFunctionality();
            }
        }
    }

    /**.
     * Save current shapes
     */
    public final void saveAll() {
    	 FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Save Paint");
         fileChooser.getExtensionFilters().addAll(
                 new FileChooser.ExtensionFilter("XML", "*.xml"),
                 new FileChooser.ExtensionFilter("Json", "*.json")
             );

         File file = fileChooser.showSaveDialog(stage);
         List<ShapePicaso> shapes = this.borderPaneController.getAllShapes();

         if (file != null) {
             try {
            	 this.saveLoadHelper.save(file, shapes);
             } catch (Exception ex) {
                 System.out.println(ex.getMessage());
             }
         }
    }

    /**.
     * Load all the shapes from xml or json file
     */
    public final void loadAll() {
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Paint");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XML", "*.xml"),
                new FileChooser.ExtensionFilter("Json", "*.json")
            );

        File file = fileChooser.showOpenDialog(stage);
        List<ShapePicaso> shapes = this.saveLoadHelper.load(file);
        borderPaneController.loadShapes(shapes);
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality() {
        // out.println("You clicked on About!");
    }

    /**.
     * Load a dynamic class
     */
    public final void loadDynamicClass() throws Exception {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	File file = fileChooser.showOpenDialog(stage);
    	System.out.println(file.getAbsolutePath());
    	List<Class<?>> classesObjects = ClassesFetchingService.getModelClasses(file);
    	this.borderPaneController.addNewClasses(classesObjects);
    }

    /**.
     * the first invoked method
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        // menuBar.setFocusTraversable(true);
    }
}
