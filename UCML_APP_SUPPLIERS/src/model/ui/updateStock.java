/**
 * 
 */
package model.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
import model.model.Car;
import model.model.user;

/**
 * @author ok
 *
 */
public class updateStock {

	private Car car;
	@SuppressWarnings("unused")
	private user User;
	private VBox mainPane;
	private Scene mainScene;
	private Stage mainWindow;
	public updateStock(user User, Car car)
	{
		this.car = car;
		this.User = User;
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
		Text heading = new Text("UPDATE CAR DETAILS");
		heading.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		heading.setStyle("-fx-fill: orange");
		//heading.setEffect(new Shadow());
		mainPane.getChildren().add(heading);
		
		HBox details = new HBox(5);
		Label carDetails = new Label("Car Details: ");
		carDetails.setPrefWidth(100);
		Label carD = new Label(car.getColour()+" "+car.getYearModel()+" "+car.getMake()+" "+car.getModel());
		details.getChildren().addAll(carDetails, carD);
		mainPane.getChildren().add(details);
		
		HBox yearBox = new HBox(5);
		Label lblYear = new Label("Year Model");
		lblYear.setPrefWidth(100);
		TextField year = new TextField();
		year.setText(Integer.toString(this.car.getYearModel()));
		yearBox.getChildren().addAll(lblYear, year);
		mainPane.getChildren().add(yearBox);
		
		HBox milBox = new HBox(5);
		Label lblMil = new Label("Mileage");
		lblMil.setPrefWidth(100);
		TextField Mileage = new TextField();
		Mileage.setText(Integer.toString(this.car.getMileage()));
		milBox.getChildren().addAll(lblMil, Mileage);
		mainPane.getChildren().add(milBox);
		
		HBox priceBox = new HBox(5);
		Label lblPrice = new Label("Price");
		lblPrice.setPrefWidth(100);
		TextField price = new TextField();
		price.setText(Integer.toString(this.car.getMileage()));
		priceBox.getChildren().addAll(lblPrice, price);
		mainPane.getChildren().add(priceBox);
		
		HBox transBox = new HBox(5);
		Label lblTrans = new Label("Trasmission");
		lblTrans.setPrefWidth(100);
		ComboBox<String> trans = new ComboBox<>();
		//System.out.println(car.getTransmission());
		if(car.getTransmission().contains("Automatic"))
		{
			trans.getItems().addAll("Automatic", "Manual");
			trans.getSelectionModel().selectFirst();
		}else
		{
			trans.getItems().addAll("Manual", "Automatic");
			trans.getSelectionModel().selectFirst();
		}
	    transBox.getChildren().addAll(lblTrans, trans);
		mainPane.getChildren().add(transBox);
		
		
		HBox statBox = new HBox(5);
		Label lblStat = new Label("Status");
		lblStat.setPrefWidth(100);
		ComboBox<String> status = new ComboBox<>();
		if(car.isStatus())
		{
			status.getItems().addAll("Available","Unavailable");
			status.getSelectionModel().selectFirst();
		}else {
			status.getItems().addAll("Unavailable", "Available");
			status.getSelectionModel().selectFirst();
		}
		statBox.getChildren().addAll(lblStat, status);
		mainPane.getChildren().add(statBox);
		
		TextArea desc = new TextArea();
		desc.setPrefHeight(100);
		desc.setText(this.car.getDesc());
		mainPane.getChildren().add(desc);
		
		HBox box = new HBox(10);
		Region r = new Region();
		HBox.setHgrow(r, Priority.ALWAYS);
		box.getChildren().add(r);
		customizeButton update = new customizeButton("UPDATE");
		update.setOnAction(e->{
			if(trans.getValue()!=null && status.getValue()!=null && this.validate("[12][09][01289][0-9]", year.getText()) 
					&& this.validate("[1-9]{1}[0-9]{2,7}", Mileage.getText()) && validate("[1-9]{1}[0-9]{4,7}", price.getText()))
			{
				int status1 = 0;
				if(status.getValue() == "Available")
					status1 = 1;
				
				if(DBHandler.execAction("UPDATE car SET CAR_TRANS='"+trans.getValue()+"', "
						+ "CAR_DESC='"+desc.getText()+"',"
								+ "CAR_STATUS="+status1+","
										+ "CAR_MILEAGE="+Integer.parseInt(Mileage.getText())+","
												+ "CAR_YEAR="+Integer.parseInt(year.getText())+","
														+ "CAR_PRICE="+Integer.parseInt(price.getText())+
														" WHERE CAR_ID="+car.getId(), "Car details updated"))
				{
					DBHandler.closeConnection();
				}
				else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Update failed");
					alert.showAndWait();
				}
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Check fields probably");
				alert.showAndWait();
			}
		});
		box.getChildren().add(update);
		mainPane.getChildren().add(box);
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
