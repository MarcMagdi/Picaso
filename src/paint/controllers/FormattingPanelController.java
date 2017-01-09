package paint.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import paint.DTO.FormatingData;
/**.
 * @author Marc Magdi
 */
public class FormattingPanelController implements Initializable{

    @FXML
	private ColorPicker fillColorChooser;

	@FXML
	private ColorPicker strokeColorChooser;

	@FXML
	private ScrollBar strokeWidthChooser;

	@FXML
	private Label labelShowStrokeWidth;

	private FormatingData formattingSettings;

    /**
     * Reference to the parent of the drawing area.
     * (i.e) border pane controller
     */
    private BorderPaneController borderPaneController;

    /**.
     * set the controller to the main controller
     * @param borderPaneController the main border controller
     */
    public final void init(final BorderPaneController borderPaneController) {
        this.borderPaneController = borderPaneController;
    }

	@Override
	public void initialize(final URL location,
					final ResourceBundle resources) {

		strokeColorChooser.setValue(Color.BLACK);
		String val = Integer.toString(
    			(int) strokeWidthChooser.getValue());
		labelShowStrokeWidth.setText(val);
		strokeWidthChooser.valueProperty().addListener(
				new ChangeListener<Number>() {
			@Override public void changed(
				final ObservableValue<? extends Number> value,
				final Number oldValue, final Number newValue) {
            	String val = Integer.toString(
            			(int) strokeWidthChooser.getValue());
				labelShowStrokeWidth.setText(val);
			}
        });
		formattingSettings = new FormatingData();
	}

	public FormatingData getFormatingData() {
		formattingSettings.setFillColor(fillColorChooser.getValue());
		formattingSettings.setStrokeColor(strokeColorChooser.getValue());
		formattingSettings.setStrokeSize((int) strokeWidthChooser.getValue());
		return formattingSettings;
	}

}
