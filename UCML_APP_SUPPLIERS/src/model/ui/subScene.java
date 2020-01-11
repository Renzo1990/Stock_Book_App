/**
 * 
 */
package model.ui;

import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * @author ok
 *
 */
public class subScene extends SubScene {

	
	//private final String BACKGROUND_IMAGE  = "file:./data/blue_panel.png";
	public subScene() {
		super(new AnchorPane(), 500, 370);
		// TODO Auto-generated constructor stub
		prefWidth(600);
		prefHeight(400);
	
		/*BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 500, 370, false, true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);*/
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setOpacity(0.75);
		this.setFill(Color.TRANSPARENT);
		//root2.setBackground(new Background(image));
		//setLayoutX(withd);
		//setLayoutY(height);
	}
	
	public AnchorPane getAnchorPane()
	{
		return (AnchorPane) this.getRoot();
	}

}
