
package paint.historyManager;

/**.
 * The operations class containing a static
 * variables indicating which operation is done.
 * @author Bishoy Nader & Marc Magdi
 *
 */

public abstract class Operations {

	/**.
	 * Move a shape
	 */
	public static final int MOVE = 0;

	/**.
	 * Draw a shape
	 */
	public static final int DRAW = 1;

	/**.
	 * Delete a shape
	 */
	public static final int DELETE = 2;

	/**.
	 * Resize a shape
	 */
	public static final int RESIZE = 3;
}
