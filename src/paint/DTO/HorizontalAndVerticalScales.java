package paint.DTO;
/**.
 * @author Marc Magdi
 */
public class HorizontalAndVerticalScales {

	private double scaleX;

	private double scaleY;

	public HorizontalAndVerticalScales() {

	}

	public HorizontalAndVerticalScales(double scaleX, double scaleY) {
		super();
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}

	public double getScaleX() {
		return scaleX;
	}
	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}
	public double getScaleY() {
		return scaleY;
	}
	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}
}
