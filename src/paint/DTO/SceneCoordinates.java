
package paint.DTO;
/**.
 * @author Marc Magdi
 */
public class SceneCoordinates {

    /**
     * horizontal coordinate of the shape.
     */
    private double sceneX;

	/**
	 * vertical coordinate of the shape.
	 */
	private double sceneY;

    /**
     * horizontal translate of the shape.
     */
    private double translateX;

	/**
	 * vertical coordinate of the shape.
	 */
	private double translateY;

	public SceneCoordinates() {

	}

	public SceneCoordinates(double sceneX, double sceneY) {
		super();
		this.sceneX = sceneX;
		this.sceneY = sceneY;
	}

	public double getSceneX() {
		return sceneX;
	}

	public void setSceneX(double sceneX) {
		this.sceneX = sceneX;
	}

	public double getSceneY() {
		return sceneY;
	}

	public void setSceneY(double sceneY) {
		this.sceneY = sceneY;
	}

	public double getTranslateX() {
		return translateX;
	}

	public void setTranslateX(double translateX) {
		this.translateX = translateX;
	}

	public double getTranslateY() {
		return translateY;
	}

	public void setTranslateY(double translateY) {
		this.translateY = translateY;
	}
	
	/**.
	 * Get a copy from this object
	 */
	@Override
	public SceneCoordinates clone() {
		SceneCoordinates sc = new SceneCoordinates(this.sceneX, this.sceneY);
		sc.setTranslateX(this.translateX);
		sc.setTranslateY(this.translateY);

		return sc;
	}

}
