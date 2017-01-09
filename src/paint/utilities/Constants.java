
package paint.utilities;

/**.
 *
 * @author Bishoy Nader & Marc Magdi
 * The constants used through all the application
 *
 */
public abstract class Constants {
	/**
	 * Drawing area state: drawing
	 */
	public static final int STATE_DRAWING = 1;

	/**
	 * Drawing area state: moving
	 */
	public static final int STATE_MOVING = 2;

	/**.
	 * Drawing area state: resizing
	 */
	public static final int STATE_RESIZING = 3;

	/**
	 * Drawing area state: deleting
	 */
	public static final int STATE_DELETING = 4;
}
