/**
 * 
 */
package model.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author ok
 *
 */
public class AlertBox {
	
	private static boolean answer;
	public static boolean display(String title, String message)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label msgLabel = new Label(message);
		Button xBtn = new Button("_Yes");
		xBtn.setOnAction(e->{
			answer=true;
			window.close();
		});
		Button quit = new Button("_No");
		quit.setOnAction(e->{
			answer = false;
			window.close();
		});
		
		HBox box1 = new HBox(10);
		box1.getChildren().addAll(xBtn, quit);
		box1.setAlignment(Pos.CENTER);
		VBox box = new VBox(10);
		box.getChildren().addAll(msgLabel, box1);
		box.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(box, 350, 150);
		window.setScene(scene);
		window.setTitle(title);
		window.showAndWait();
		
		return answer;
		
	}

}
