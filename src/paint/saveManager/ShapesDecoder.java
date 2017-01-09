package paint.saveManager;

import java.awt.Shape;
import java.lang.reflect.Constructor;

import javafx.scene.paint.Color;
import paint.DTO.FormatingData;
import paint.models.ShapePicaso;
import paint.services.ClassesFetchingService;

public class ShapesDecoder {
	public static ShapePicaso getShapeFromSavable(SavableShape savable) {
		ShapePicaso shape = null;
		Class<? extends ShapePicaso> currentlyShapeClass =
				(Class<? extends ShapePicaso>) ClassesFetchingService
				.getClassForDecoding("paint.models", savable.getClassName());
		Constructor<? extends ShapePicaso>[] constructors =
    			(Constructor<? extends ShapePicaso>[])
				currentlyShapeClass.getConstructors();
        Constructor<? extends ShapePicaso> constructor = constructors[0];
        try {
            shape = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        shape.setFormats(new FormatingData());
        shape.getFormats().fillColor = Color.web(savable.getFillColor());
        shape.getFormats().strokeColor = Color.web(savable.getStrokeColor());
        shape.getFormats().strokeSize = savable.getStrokeSize();
        shape.setSavedPoints(savable.getPoints());
		return shape;
	}
}
