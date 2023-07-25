
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;



public class BTView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double vGap = 100; // Gap between two levels in a tree

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 6);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> root,
            double x, double y, double hGap) {
    	int yTranslate = 250;
    	
    	
        if (root.left != null) {
            // Draw a line to the left node
        	Line line = new Line(x - hGap, y + vGap, x, y);
        	line.getTransforms().add(new Rotate(-90, x, y));
            line.setTranslateX(-(getWidth() / 3));
            line.setTranslateY(yTranslate);
            getChildren().add(line);           
            // Draw the left subtree recursively
            displayTree(root.left, x + vGap, y + hGap, hGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right node
        	Line line = new Line(x + hGap, y + vGap, x, y);
        	line.getTransforms().add(new Rotate(-90, x, y));
            line.setTranslateX(-(getWidth() / 3));
            line.setTranslateY(yTranslate);
            getChildren().add(line);
            // Draw the right subtree recursively
            displayTree(root.right, x + vGap, y - hGap, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(-(getWidth() / 3));
        circle.setTranslateY(yTranslate);
        circle.getTransforms().add(new Rotate(0, 0, 90));
        Text number =  new Text(x - 4, y + 4, root.element + "");
        number.setTranslateX(-(getWidth() / 3));
        number.setTranslateY(yTranslate);
        
        getChildren().addAll(circle, number);
    }
}
