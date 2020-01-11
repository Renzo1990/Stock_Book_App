/**
 * 
 */
package model.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.database.DBHandler;
import model.model.Supplier;
import model.model.user;

/**
 * @author ok
 *
 */
public class updateSupplier {

	private Supplier supplier;
	@SuppressWarnings("unused")
	private user User;
	private VBox mainPane;
	private Scene mainScene;
	private Stage mainWindow;
	public updateSupplier(user User, Supplier supplier)
	{
		this.supplier = supplier;
		this.User = User;
		mainPane = new VBox(10);
		mainPane.setPadding(new Insets(20,50,0,50));
		mainScene = new Scene(mainPane, 550, 350, Color.DIMGRAY);
		mainWindow = new Stage();
		content();
		mainWindow.setScene(mainScene);
		mainWindow.initModality(Modality.APPLICATION_MODAL);
		mainWindow.setTitle("Settings");
		mainWindow.showAndWait();
	}
	private void content()
	{
		Text heading = new Text("UPDATE YOUR DETAILS FOR "+this.supplier.getName());
		heading.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		heading.setStyle("-fx-fill: orange");
		//heading.setEffect(new Shadow());
		mainPane.getChildren().add(heading);
		
		TextField name = new TextField();
		name.setText(this.supplier.getName());
		mainPane.getChildren().add(name);
		
		TextField num = new TextField();
		num.setText(this.supplier.getNumber());
		mainPane.getChildren().add(num);
		
		TextField num1 = new TextField();
		num1.setPromptText(this.supplier.getNumber1());
		mainPane.getChildren().add(num1);
		
		HBox box = new HBox(10);
		Region r = new Region();
		HBox.setHgrow(r, Priority.ALWAYS);
		box.getChildren().add(r);
		customizeButton update = new customizeButton("UPDATE");
		update.setOnAction(e->{
			if(name.getText()!=null && this.validateNumber(num.getText()) && this.validateNumber(num1.getText()))
			{
				
					if(DBHandler.execAction("UPDATE supplier SET SUP_NAME='"+name.getText()+"', SUP_NUM='"+num.getText()+"'"
							+ ", SUP_NUM1 ='"+num1.getText()+"' WHERE SUP_ID="+this.supplier.getSupId(), 
							this.supplier.getName()+" Succefully Updated")) {
						DBHandler.closeConnection();
						
					}else
					{
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Update failed");
						alert.showAndWait();
					}
				
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Name or number filed is empty");
				alert.showAndWait();
			}
		});
		box.getChildren().add(update);
		mainPane.getChildren().add(box);
	}
	private boolean validateNumber(String message)
	{
		boolean valid = true;
		final Pattern numPattern = Pattern.compile("0[5-9]{1}[0-9]{8}");
		Matcher numMatcher = numPattern.matcher(message);
		if(!numMatcher.matches())
			valid = false;
		
		return valid;
	}
}
