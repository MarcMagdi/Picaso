package paint.historyManager;

import java.util.Stack;

import paint.models.ShapePicaso;

/**.
 * The history manager for the paint, working in any steps in O(1)
 * @author Bishoy Nader & Marc Magdi
 *
 */
public class HistoryManager {

	/**.
	 * The undo stack
	 */
	private Stack<HistoryNode> undoStack;

	/**.
	 * The redo stack
	 */
	private Stack<HistoryNode> redoStack;

	/**.
	 * Constructor to initialize the used stacks
	 */
	public HistoryManager() {
		this.undoStack = new Stack<HistoryNode>();
		this.redoStack = new Stack<HistoryNode>();
	}

	public void undo() {
		if (this.undoStack.size() > 0) {
			HistoryNode node = this.undoStack.pop();
			this.redoStack.push(node);

			switch (node.getOperation()) {
				case Operations.MOVE:
					this.undoMove(node);
					break;
				case Operations.DELETE:
					this.undoDelete(node);
					break;
				case Operations.DRAW:
					this.redoDelete(node);
					break;
				case Operations.RESIZE:
					this.undoResize(node);
					break;
			}
		}
	}

	public void redo() {
		if (this.redoStack.size() > 0) {
			HistoryNode node = this.redoStack.pop();
			this.undoStack.push(node);

			switch (node.getOperation()) {
				case Operations.MOVE:
					this.redoMove(node);
					break;
				case Operations.DELETE:
					this.redoDelete(node);
					break;
				case Operations.DRAW:
					this.undoDelete(node);
					break;
				case Operations.RESIZE:
					this.redoResize(node);
					break;
			}
		}
	}

	private void undoResize(HistoryNode node) {
		ShapePicaso shape = node.getShape();
		shape.rescale(node.getOldScales().getScaleX(),
				node.getOldScales().getScaleY());
	}

	private void redoResize(HistoryNode node) {
		ShapePicaso shape = node.getShape();
		shape.rescale(node.getNewScales().getScaleX(),
				node.getNewScales().getScaleY());
	}

	private void undoDelete(HistoryNode node) {
		node.getShape().unDelete();
	}

	private void redoDelete(HistoryNode node) {
		node.getShape().delete();
	}

	private void undoMove(HistoryNode node) {
		ShapePicaso shape = node.getShape();
		shape.setSceneCoordinates(node.getNewScene());
		shape.move(node.getOldScene());
	}

	private void redoMove(HistoryNode node) {
		ShapePicaso shape = node.getShape();
		shape.setSceneCoordinates(node.getOldScene());
		shape.move(node.getNewScene());
	}

	public void addNewRecord(HistoryNode node) {
		this.undoStack.push(node);
		this.redoStack.clear();
	}
}
