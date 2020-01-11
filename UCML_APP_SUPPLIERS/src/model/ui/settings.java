/**
 * 
 */
package model.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import model.model.user;

/**
 * @author ok
 *
 */
public class settings {

	private user User;
	private Stage mainWindow;
	private VBox mainPane;
	private Scene mainScene;
	private Stage mainStage;
	public settings(user User, Stage stage) {
		this.User = User;
		this.mainStage = stage;
		mainPane = new VBox(10);
		mainPane.setPadding(new Insets(20,50,0,50));
		mainScene = new Scene(mainPane, 550, 450, Color.DIMGRAY);
		mainWindow = new Stage();
		content();
		mainWindow.setScene(mainScene);
		mainWindow.initModality(Modality.APPLICATION_MODAL);
		mainWindow.setTitle("Settings");
		mainWindow.showAndWait();
	}
	
	private void content()
	{
		Text heading = new Text("UPDATE YOUR DETAILS HERE!!");
		heading.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		heading.setStyle("-fx-fill: orange");
		//heading.setEffect(new Shadow());
		mainPane.getChildren().add(heading);
		
		HBox nameBox = new HBox(5);
		Label lblName = new Label("Dealership Name");
		lblName.setPrefWidth(105);
		TextField name = new TextField();
		name.setText(this.User.getUserName());
		nameBox.getChildren().addAll(lblName, name);
		mainPane.getChildren().add(nameBox);
		
		HBox dealBox = new HBox(5);
		Label lblDeal = new Label("Dealership Nubmer");
		lblDeal.setPrefWidth(105);
		TextField deal = new TextField();
		deal.setText(""+this.User.getUserNumber());
		dealBox.getChildren().addAll(lblDeal, deal);
		mainPane.getChildren().add(dealBox);
		
		HBox ownerBox = new HBox(5);
		Label lblOwner = new Label("Owner's Name");
		lblOwner.setPrefWidth(105);
		TextField Owner = new TextField();
		Owner.setText(this.User.getUserDealName());
		ownerBox.getChildren().addAll(lblOwner, Owner);
		mainPane.getChildren().add(ownerBox);
		
		HBox numBox = new HBox(5);
		Label lblNum = new Label("Owner's Number");
		lblNum.setPrefWidth(105);
		TextField num = new TextField();
		num.setText(this.User.getOwnerNum());
		numBox.getChildren().addAll(lblNum, num);
		mainPane.getChildren().add(numBox);
		
		HBox emailBox = new HBox(5);
		Label lblEmail = new Label("Dealership Email");
		lblEmail.setPrefWidth(105);
		TextField email = new TextField();
		email.setText(this.User.getUserEmail());
		emailBox.getChildren().addAll(lblEmail, email);
		mainPane.getChildren().add(emailBox);
		
		HBox oldBox = new HBox(5);
		Label lblOld = new Label("Old Password");
		lblOld.setPrefWidth(105);
		PasswordField oldPass = new PasswordField();
		oldPass.setPromptText("OLD PASSWORD");
		oldBox.getChildren().addAll(lblOld, oldPass);
		mainPane.getChildren().add(oldBox);
		
		HBox newBox = new HBox(5);
		Label lblNew = new Label("Owner's Number");
		lblNew.setPrefWidth(105);
		TextField newPass = new TextField();
		newPass.setPromptText("NEW PASSWORD");
		newBox.getChildren().addAll(lblNew, newPass);
		mainPane.getChildren().add(newBox);
		
		HBox box = new HBox(10);
		Region r = new Region();
		HBox.setHgrow(r, Priority.ALWAYS);
		box.getChildren().add(r);
		customizeButton update = new customizeButton("UPDATE");
		update.setOnAction(e->{
			if(name.getText()!=null && email.getText()!=null)
			{
				if(oldPass.getText().contains(this.User.getPassword()) && newPass.getText() != null)
				{
					if(DBHandler.execAction("UPDATE dealerships SET DEAL_NAME='"+name.getText()+"',"
							+ " DEAL_NUM='"+deal.getText()+"',"
							+ " DEAL_OWNER='"+Owner.getText()+"',"
							+ " DEAL_OWNER_NUM='"+num.getText()+"',"
							+ " DEAL_EMAIL='"+email.getText()+"'"
							+ ", DEAL_PASSWORD ='"+newPass.getText()+"'"
							+ " WHERE DEAL_ID="+this.User.getUserId(), "Settings Updated")) {
						login log = new login();
						this.mainStage.close();
						log.getMainStage().show(); 
						
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
					alert.setContentText("Incorrect Password or new Password field is blank");
					alert.showAndWait();
				}
				
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Name or Emaild filed is empty");
				alert.showAndWait();
			}
		});
		box.getChildren().add(update);
		mainPane.getChildren().add(box);
	}
}
