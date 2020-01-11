/**
 * 
 */
package model.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class AddCar extends VBox {

	private user User;
	private ObservableList<String> mode;
	public AddCar(user User)
	{
		this.User = User;
		this.mode = FXCollections.observableArrayList();
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
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
		
		Image stockImg = new Image("file:./data/carAdd.png");
		Label slash1 = new Label("  /  ");
		header1.getChildren().add(slash1);
		Label lblAddStock = new Label("ADD VEHICLE");
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
		Text txtInfo = new Text("       ENTER CAR DETAILS ");
		txtInfo.setStyle("-fx-font-weight: Bold; -fx-font-size: 24; -fx-font-family: courier new; -fx-fill: #ffffcd");
		
		Text txtInfo1 = new Text("        SUPPLIER DETAILS");
		txtInfo1.setStyle("-fx-font-weight: Bold; -fx-font-size: 24; -fx-font-family: courier new; -fx-fill: #ffffcd");
		
		box.getChildren().addAll(txtInfo, txtInfo1);
		
		HBox box1 = new HBox(10);
		box1.setPadding(new Insets(5,5,5,5));
		
		//container for adding car
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(20,0,0,80));
		
		
		//make
		ComboBox<String> cbMake = new ComboBox<>();
		HBox mk = new HBox(10);
		Label make = new Label("Make");
		make.setPrefWidth(80);
		cbMake.setPromptText("Select car Make");
		for(String make1: make("SELECT make FROM make ORDER BY make"))
		{
			cbMake.getItems().add(make1);
		}
		mk.getChildren().addAll(make, cbMake);
		vBox.getChildren().add(mk);
		
		//model
		ComboBox<String> cbModel = new ComboBox<>();
		HBox md = new HBox(10);
		Label model = new Label("Model");
		model.setPrefWidth(80);
		cbModel.setPromptText("Select car Model");
		cbMake.setOnAction(e->{
			
			mode = model(cbMake.getValue());
			
				cbModel.setItems(mode);
			
		});
		
		md.getChildren().addAll(model, cbModel);
		vBox.getChildren().add(md);
		
		//engine size
		HBox engineBox = new HBox(10);
		Label lblEngine = new Label("Engine Size");
		lblEngine.setPrefWidth(80);
		TextField txtEngine = new TextField();
		txtEngine.setPromptText("Engine Size");
		engineBox.getChildren().addAll(lblEngine, txtEngine);
		vBox.getChildren().add(engineBox);
		
		//colour and string validation
		HBox colorBox = new HBox(10);
		Label lblColor = new Label("Colour");
		lblColor.setPrefWidth(80);
		TextField txtColor = new TextField();
		txtColor.setPromptText("Colour");
		colorBox.getChildren().addAll(lblColor, txtColor);
		vBox.getChildren().add(colorBox);
		
		//year Model and validation
		HBox yearBox = new HBox(10);
		Label lblYear = new Label("Year");
		lblYear.setPrefWidth(80);
		TextField txtYear = new TextField();
		txtYear.setPromptText("Year Model");
		yearBox.getChildren().addAll(lblYear, txtYear);
		vBox.getChildren().add(yearBox);
		
		//Mileage
		HBox milBox = new HBox(10);
		Label lblMil = new Label("Mileage");
		lblMil.setPrefWidth(80);
		TextField txtMil = new TextField();
		txtMil.setPromptText("KM");
		milBox.getChildren().addAll(lblMil, txtMil);
		vBox.getChildren().add(milBox);
		
		//Status
		ComboBox<String> stModel = new ComboBox<>();
		HBox stBox = new HBox(10);
		Label lblModel = new Label("Status");
		lblModel.setPrefWidth(80);
		stModel.setPromptText("Status");
		stModel.getItems().addAll("Available", "UnAvailale");
		stBox.getChildren().addAll(lblModel, stModel);
		vBox.getChildren().add(stBox);
		
		//Transmission
		ComboBox<String> cbTrans = new ComboBox<>();
		HBox transBox = new HBox(10);
		Label lblTrans = new Label("Trasnmission");
		lblTrans.setPrefWidth(80);
		cbTrans.setPromptText("Transmission");
		cbTrans.getItems().addAll("Manual", "Automatic");
		transBox.getChildren().addAll(lblTrans, cbTrans);
		vBox.getChildren().add(transBox);
		
		//body Type
		ComboBox<String> cbBody = new ComboBox<>();
		HBox bodyBox = new HBox(10);
		Label lblBody = new Label("Body Type");
		lblBody.setPrefWidth(80);
		cbBody.setPromptText("Body Type");
		cbBody.getItems().addAll("Hatchback", "Sedane", "SUV", "Convertible", "Bakkie");
		bodyBox.getChildren().addAll(lblBody, cbBody);
		vBox.getChildren().add(bodyBox);
		
		//Price
		HBox priceBox = new HBox(10);
		Label lblPrice = new Label("Price");
		lblPrice.setPrefWidth(80);
		TextField txtPrice = new TextField();
		txtPrice.setPromptText("Price");
		priceBox.getChildren().addAll(lblPrice, txtPrice);
		vBox.getChildren().add(priceBox);
		
		//description
		HBox descBox = new HBox(10);
		Label lblDesc = new Label("Description");
		lblDesc.setPrefWidth(80);
		TextArea desc = new TextArea();
		desc.setPrefHeight(60);
		descBox.getChildren().addAll(lblDesc, desc);
		vBox.getChildren().add(descBox);
		
		//Images
		
		
		VBox vBox1 = new VBox(20);
		vBox1.setPadding(new Insets(20,0,0,20));
		vBox1.setAlignment(Pos.CENTER);
		//supplier's name field 
		ComboBox<String> cbName = new ComboBox<>();
		HBox nameBox = new HBox(10);
		Label lblName = new Label("Supplier's Name");
		lblName.setPrefWidth(100);
		cbName.setPromptText("Name");
		for(String sup: supplierName())
		{
			cbName.getItems().add(sup);
		}
		nameBox.getChildren().addAll(lblName, cbName);
		vBox1.getChildren().add(nameBox);
		
		//Suppliers Number
		HBox numBox = new HBox(10);
		Label lblNum = new Label("Phone Number: ");
		lblNum.setPrefWidth(100);
		Label txtNum = new Label();
		numBox.getChildren().addAll(lblNum, txtNum);
		vBox1.getChildren().add(numBox);
		
		HBox numBox1 = new HBox(10);
		Label lblNum1 = new Label("Alternative: ");
		lblNum.setPrefWidth(100);
		Label txtNum1 = new Label();
		cbName.setOnAction(e->{
			txtNum1.setText(SupplierNum(cbName.getValue()));
			txtNum.setText(SupplierNum(cbName.getValue()));
		});
		numBox1.getChildren().addAll(lblNum1, txtNum1);
		vBox1.getChildren().add(numBox1);
		
		
		Region r = new Region();
		HBox sub = new HBox(10);
		HBox.setHgrow(r, Priority.ALWAYS);
		
		//Submit Button
		customizeButton submit = new customizeButton("SAVE VEHICLE");
		submit.setOnAction(e->{
			HBox errBox = new HBox();
			if(cbMake.getValue()!=null && cbModel.getValue()!=null&&this.validate("[12][09][01289][0-9]", txtYear.getText())&& 
					stModel.getValue()!=null&&this.validate("[1-9]{1}[0-9]{4,7}", txtPrice.getText())&& cbName.getValue()!=null &&
					this.validate("[1-9]{1}[0-9]{2,7}", txtMil.getText()))
			{
				int makeId = 0, modelId = 0, supId = 0, status;
				ResultSet mkResult = DBHandler.execQuery("SELECT makeId FROM make WHERE make ='"+cbMake.getValue()+"'");
				try {
					mkResult.next();
					makeId = mkResult.getInt("makeId");
					ResultSet mdResult = DBHandler.execQuery("SELECT modelId FROM model WHERE model='"+cbModel.getValue()+"' AND makeId="+makeId);
					mdResult.next();
					ResultSet supResult=DBHandler.execQuery("SELECT SUP_ID FROM supplier WHERE SUP_NAME='"+cbName.getValue()+"' AND DEAL_ID="+
					this.User.getUserId()+" AND SUP_NUM ='"+txtNum.getText()+"'");
					supResult.next();
					supId = supResult.getInt("SUP_ID");
					modelId = mdResult.getInt("modelId");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(stModel.getValue()=="Available")
					status = 1;
				else 
					status = 0;
				
				if(DBHandler.execAction("INSERT INTO car(CAR_ENGINE, CAR_TRANS, CAR_COLOR, CAR_PRICE, CAR_DESC, CAR_STATUS, CAR_MAKEID, CAR_MODELID,"
						+ "CAR_SUPID, CAR_DEALID, CAR_YEAR, CAR_MILEAGE, CAR_BODY_TYPE) VALUES('"+txtEngine.getText()+"',"
						+ "'"+cbTrans.getValue()+"',"
						+ "'"+txtColor.getText()+"',"
						+ "'"+txtPrice.getText()+"',"
						+ "'"+desc.getText()+"',"
						+ "'"+status+"',"
						+ "'"+makeId+"',"
						+ "'"+modelId+"',"
						+ "'"+supId+"',"
						+ "'"+this.User.getUserId()+"',"
						+ "'"+txtYear.getText()+"',"
						+ "'"+txtMil.getText()+"',"
                        + "'"+cbBody.getValue()+"')",
                        "New Stock Successfully added"))
				{
					txtEngine.clear();
					txtColor.clear();
					txtPrice.clear();
					txtYear.clear();
					txtMil.clear();
					errBox.getChildren().clear();
					mk.getChildren().removeAll(errBox);
					DBHandler.closeConnection();
				}
				else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("unsuccessfull, check your entries");
					alert.showAndWait();
				}
			}
			else {
				errBox.getChildren().clear();
				mk.getChildren().removeAll(errBox);
				Text errText = new Text("Error: Check Year model, Price, status and make");
				errText.setStyle("-fx-fill: red");
				errBox.getChildren().add(errText);
				mk.getChildren().add(errBox);
			}
		});
		sub.getChildren().addAll(r, submit);
		
		box1.getChildren().addAll(vBox, vBox1);
		
		content1.getChildren().addAll(box, box1, sub);
		this.getChildren().add(content1);
		
	}
	
	private ObservableList<String> make(String query)
	{
		ObservableList<String> make = FXCollections.observableArrayList();
		ResultSet result = DBHandler.execQuery("SELECT make FROM make ORDER BY make");
		try {
			while(result.next())
			{
				make.add(result.getString("make"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return make;
	}
	private ObservableList<String> model(String make)
	{
		ObservableList<String> models = FXCollections.observableArrayList();
		int makeId = 0;
		ResultSet result = DBHandler.execQuery("SELECT makeId FROM make WHERE make='"+make+"'");
		try {
			result.next();
			makeId = result.getInt("makeId");
			ResultSet rs = DBHandler.execQuery("SELECT model FROM model WHERE makeId ="+makeId+" ORDER BY model");
			while(rs.next())
			{
				models.add(rs.getString("model"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return models;
	}
	private String SupplierNum(String str)
	{
		String num = null;
		ResultSet result = DBHandler.execQuery("SELECT SUP_NUM, SUP_NUM1 FROM supplier WHERE SUP_NAME ='"+str+"'AND DEAL_ID="+this.User.getUserId());
		try {
			result.next();
			num = result.getString("SUP_NUM");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
	}
	private ObservableList<String> supplierName()
	{
		ObservableList<String> name = FXCollections.observableArrayList();
		ResultSet result = DBHandler.execQuery("SELECT SUP_NAME FROM supplier WHERE DEAL_ID ="+this.User.getUserId()+" ORDER BY "
				+ "SUP_NAME");
		try {
			while(result.next())
			{
				name.add(result.getString("SUP_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return name;
	}
	
	private boolean validate(String reg, String text)
	{
		boolean valid = true;
		final Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(text);
		
		if(!matcher.matches())
			valid = false;
		
		return valid;
	}
}
