/**
 * 
 */
package model.ui;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Locale;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.database.DBHandler;
import model.model.user;

/**
 * @author ok
 *
 */
public class login{
	
	private static final int HEIGHT = 705;
	private static final int WIDTH = 1024;
	private AnchorPane mainPane;
	private subScene mainSubScene;
	private Stage mainStage;
	private Scene mainScene;
	/**
	 * @return the mainScene
	 */
	public Scene getMainScene() {
		return mainScene;
	}

	/**
	 * @param mainScene the mainScene to set
	 */
	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

	/**
	 * @return the mainStage
	 */
	public Stage getMainStage() {
		return mainStage;
	}

	/**
	 * @param mainStage the mainStage to set
	 */
	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	
	public login()
	{
		mainPane = new AnchorPane();
		createBackground();
		//HBox layout
		HBox box = new HBox(12);
		DropShadow shadow = new DropShadow();
		shadow.setOffsetX(5);
		shadow.setOffsetY(5);
		Text text = new Text("Car Suppliers Easy Access");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setStyle("-fx-fill: linear-gradient(orange, orangered)");
		text.setEffect(shadow);
		box.setLayoutX(403);
		box.setLayoutY(150);
		box.getChildren().add(text);
		mainPane.getChildren().add(box);
		
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setTitle("UCL_Desktop_APP");
		mainStage.setScene(mainScene);
		mainStage.getIcons().add(new Image("file:./data/icons/app.png"));
		
		
		
		
		
		createSubscenes();
	}
	
	private void createBackground()
	{
		//164834015-tesla-wallpapers.jpg
		Image backImage = new Image("file:./data/makes_bg.jpg", 1924, 1024, false, true);
		BackgroundImage background = new BackgroundImage(backImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createSubscenes()
	{
		mainSubScene = new subScene();
		IntegerProperty x = new SimpleIntegerProperty(mainScene.widthProperty().intValue());
		IntegerProperty y = new SimpleIntegerProperty((int)mainScene.heightProperty().intValue());
		IntegerProperty x1 = new SimpleIntegerProperty();
		IntegerProperty y1 = new SimpleIntegerProperty();
		x1.bind(x.divide(2));
		y1.bind(y.divide(2));
		mainSubScene.setLayoutX(x1.getValue()-150);
		mainSubScene.setLayoutY(y1.getValue()-170);
		mainPane.getChildren().add(mainSubScene);
		
		HBox hbox = new HBox(4);
		VBox vbox = new VBox(7);
		vbox.setLayoutX(mainSubScene.getLayoutX()/2-100);
		vbox.setLayoutY(mainSubScene.getLayoutY()/2);
		CustomeLabbel lblEmail = new CustomeLabbel("Email:");
		TextField txtEmail = new TextField("Email address");
		HBox hbox1 = new HBox(4);
		CustomeLabbel lblPasword = new CustomeLabbel("Password:");
		PasswordField txtPass = new PasswordField();
		hbox1.getChildren().addAll(lblPasword, txtPass);
		txtPass.setPromptText("Password");
		hbox.getChildren().addAll(lblEmail, txtEmail);
		vbox.getChildren().addAll(hbox, hbox1);
		customizeButton btnLogin = new customizeButton("Login");
		btnLogin.setOnAction(e->{
			String query = "SELECT * FROM dealerships";
			//DBHandler db = new DBHandler();
			ResultSet rs = DBHandler.execQuery(query);
			boolean check = false;
			try {
				while(rs.next())
				{
					String name = rs.getString("DEAL_EMAIL");
					String pass = rs.getString("DEAL_PASSWORD");
					
					if(txtEmail.getText().equals(name) && txtPass.getText().equals(pass))
					{
						Date date = rs.getDate("Date");
						String dateString  = new SimpleDateFormat("yyyy-MM-dd").format(date);
						LocalDate from = LocalDate.parse(dateString);
						
						if(ChronoUnit.DAYS.between(from, LocalDateTime.now())<=21) {
							
						user new_user = new user(rs.getShort("DEAL_ID"), rs.getString("DEAL_NUM"), rs.getString("DEAL_EMAIL"),
								rs.getString("DEAL_ADDRESS"), rs.getString("DEAL_NAME"), rs.getString("DEAL_OWNER"), 
								rs.getString("DEAL_PASSWORD"), rs.getString("DEAL_OWNER_NUM"), date);
						AdminView view = new AdminView(new_user, this.mainStage);
						this.mainStage.setScene(view.getMainScene());
						this.mainStage.setMaximized(true);
						check=true;
						
						DBHandler.closeConnection();
						}
						else {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Free Lincense Expired: Contact software admin on 0656528813");
							alert.showAndWait();
							check=true;
						}
					}
				}
				if(!check) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Email or Password not correct");
				alert.showAndWait();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtEmail.clear();
			txtPass.clear();
		});
		HBox hbox2 = new HBox();
		hbox2.setLayoutX(mainSubScene.getLayoutX()-170);
		hbox2.setLayoutY(mainSubScene.getLayoutY());
		hbox2.getChildren().add(btnLogin);
		mainSubScene.getAnchorPane().getChildren().addAll(vbox, hbox2);
		//mainPane.getChildren().add(hbox);
		
	}

}
