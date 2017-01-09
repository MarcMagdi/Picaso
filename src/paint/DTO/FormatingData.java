package paint.DTO;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
import javafx.scene.paint.Color;
 
/**.
 * @author Marc Magdi
 */
@XmlRootElement
public class FormatingData {
 
    /**.
     * The size of the stroke around the shape
     */
    public int strokeSize;
 
    /**.
     * The color of the stroke around the shape
     */
    public Color strokeColor;
 
    /**.
     * The color of the shape.
     */
    public Color fillColor;
 
    public int getStrokeSize() {
        return strokeSize;
    }
 
    @XmlElement
    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }
 
    public Color getStrokeColor() {
        return strokeColor;
    }
 
    @XmlElement
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }
 
    public Color getFillColor() {
        return fillColor;
    }
 
    @XmlElement
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
