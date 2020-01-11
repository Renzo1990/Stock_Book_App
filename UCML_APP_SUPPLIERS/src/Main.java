import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.ui.login;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Car_Stock_Book_App");
		login newLogin = new login();
		primaryStage = newLogin.getMainStage();
		primaryStage.getIcons().add(new Image("file:./data/app.png"));
		primaryStage.show();
		
	}

}
