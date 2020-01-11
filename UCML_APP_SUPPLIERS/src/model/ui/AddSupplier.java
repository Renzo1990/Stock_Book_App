/**
 * 
 */
package model.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.database.DBHandler;
import model.model.user;

/**
 * @author ok
 *
 */
public class AddSupplier extends VBox {
	
	private user User;
	public AddSupplier(user User)
	{
		this.User = User;
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
		
		this.setPrefHeight(650);
		topHeader();
		topheader1();
		content();
	}

	private void topHeader()
	{
		HBox header = new HBox(10);
		this.setPadding(new Insets(20,20,0,20));
		//Region r = new Region();
		//r.setPrefWidth(20);
		ImageView icon = new ImageView(new Image("file:./data/add.png"));
		icon.setFitHeight(35);
		icon.setFitWidth(30);
		header.getChildren().addAll(icon);
		Text iconText = new Text("ADD");
		iconText.setLayoutY(15);
		iconText.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-font-family: Courier new; -fx-fill: grey;");
		header.getChildren().add(iconText);
		this.getChildren().add(header);
	}
	private void topheader1()
	{
		this.setSpacing(20);
		FlowPane header1 = new FlowPane();
		header1.setAlignment(Pos.CENTER_LEFT);
		header1.setPadding(new Insets(5,0,10,0));
		header1.setStyle("-fx-background-color: white");
		//header1.setMaxHeight(4);
		//header1.setPadding(new Insets(10, 0, 0, 0));
		Image img = new Image("file:./data/home.png");
		Image img1 = new Image("file:./data/add.png");
		Label lblHome = new Label("Home");
		ImageView view = new ImageView(img);
		view.setFitHeight(18);
		view.setFitWidth(15);
		lblHome.setGraphic(view);
		lblHome.setTextFill(Color.SKYBLUE);
		lblHome.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblHome);
		Label slash = new Label("  /  ");
		header1.getChildren().add(slash);
		Label lblDash = new Label("ADD");
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(18);
		view1.setFitWidth(15);
		lblDash.setGraphic(view1);
		lblDash.setTextFill(Color.GREY);
		lblDash.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblDash);
		
		Image stockImg = new Image("file:./data/add-user.png");
		Label slash1 = new Label("  /  ");
		header1.getChildren().add(slash1);
		Label lblAddStock = new Label("ADD SUPPLIER");
		ImageView AddStock = new ImageView(stockImg);
		AddStock.setFitHeight(18);
		AddStock.setFitWidth(15);
		lblAddStock.setGraphic(AddStock);
		lblAddStock.setTextFill(Color.GREY);
		lblAddStock.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblAddStock);
		
		
		this.getChildren().add(header1);
		
	}
	private void content()
	{
		VBox content1 = new VBox(5);
		content1.prefHeight(450);
		content1.setPadding(new Insets(5,5,5,5));
		content1.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		HBox box = new HBox(350);
		box.prefHeight(100);
		box.setStyle("-fx-background-color: #797971");
		
		Region r = new Region();
		Region r1 = new Region();
		HBox.setHgrow(r, Priority.ALWAYS);
		HBox.setHgrow(r1, Priority.ALWAYS);
		
		Text txtInfo1 = new Text("    ENTER SUPPLIER DETAILS    ");
		txtInfo1.setStyle("-fx-font-weight: Bold; -fx-font-size: 24; -fx-font-family: courier new; -fx-fill: #ffffcd");
		
		box.getChildren().addAll(r, txtInfo1, r1);
		
		VBox box1 = new VBox(20);
		box1.setPadding(new Insets(20,20,5,20));
		box1.setAlignment(Pos.CENTER);
		box1.setBorder(new Border(new BorderStroke(Color.DARKKHAKI, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		//Suppliers name
		HBox nameBox = new HBox(10);
		Label lblName = new Label("Suppliers Name");
		lblName.setPrefWidth(100);
		TextField txtName = new TextField();
		txtName.setPromptText("Name");
		
		nameBox.getChildren().addAll(lblName, txtName);
		box1.getChildren().add(nameBox);
		
		//suppliers number
		HBox numBox = new HBox(10);
		Label lblNum = new Label("Phone Number");
		lblNum.setPrefWidth(100);
		TextField txtNum = new TextField();
		txtNum.setPromptText("mobile number");
		
		numBox.getChildren().addAll(lblNum, txtNum);
		box1.getChildren().add(numBox);
		
		
		// alternative number
		HBox num1Box = new HBox(10);
		Label lblNum1 = new Label("Alternative Number");
		lblNum.setPrefWidth(100);
		TextField txtNum1 = new TextField();
		txtNum1.setPromptText("Number");
		num1Box.getChildren().addAll(lblNum1, txtNum1);
		box1.getChildren().add(num1Box);
		
		//save supplier details
		customizeButton save = new customizeButton("SAVE NOW");
		save.setAlignment(Pos.BOTTOM_RIGHT);
		save.setOnAction(e->{
			Text num = new Text();
			HBox nuBox = new HBox();
			HBox nuBox1 = new HBox();
			if(this.validateNumber(txtNum.getText()) && this.validateNumber(txtNum1.getText()))
			{
				nuBox.getChildren().clear();
				 num.setText("Valid Number Format");
				num.setStyle("-fx-fill: green");
				nuBox.getChildren().add(num);
				numBox.getChildren().add(nuBox);
				Text num1 = new Text();
					nuBox1.getChildren().clear();
					num1.setText("Valid Numer Format");
					num1.setStyle("-fx-fill: green");
					nuBox1.getChildren().add(num1);
					num1Box.getChildren().add(nuBox1);
					if(DBHandler.execAction("INSERT INTO supplier(SUP_NAME, SUP_NUM, DEAL_ID, SUP_NUM1) VALUES('"+txtName.getText()+"',"
							+ "'"+txtNum.getText()+"',"
									+ "'"+this.User.getUserId()+"',"
									+ "'"+txtNum1.getText()+"')", txtName.getText()+" successfully added"))
							
					{
						txtName.clear();
						txtNum.clear();
						txtNum1.clear();
					     DBHandler.closeConnection();
					}
				
			}
			else
			{
				nuBox.getChildren().clear();
				num = new Text("Invalid Number Format");
				num.setStyle("-fx-fill: red");
				nuBox.getChildren().add(num);
				numBox.getChildren().add(nuBox);
			}
		});
		box1.getChildren().add(save);
		
		content1.getChildren().addAll(box, box1);
		this.getChildren().add(content1);
		
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
