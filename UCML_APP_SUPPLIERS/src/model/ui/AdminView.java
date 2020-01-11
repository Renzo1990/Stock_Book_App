/**
 * 
 */
package model.ui;

import java.util.function.Predicate;

import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.model.Car;
import model.model.user;

/**
 * @author ok
 *
 */
public class AdminView{
 
	private BorderPane mainPane;
	private Scene mainScene;
	private user New_user;
	private Stage mainStage;
	private boolean answer;
	
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

	public AdminView(user user, Stage window)
	{
		mainPane = new BorderPane();
		mainScene = new Scene(mainPane);
		mainStage = window;
		this.New_user = user;
		Dashboard dash = new Dashboard(user);
		mainPane.setPrefHeight(dash.getHeight());
		mainPane.setCenter(dash);
		mainStage.getIcons().add(new Image("file:./data/app.png"));
		ScrollPane sideBarScroller = new ScrollPane(dash);
		sideBarScroller.setFitToWidth(true);

		mainPane.setCenter(sideBarScroller);
		
		HBox footer = new HBox(10);
		Region r = new Region();
		footer.setStyle("-fx-background-color: steelblue");
		HBox.setHgrow(r, Priority.ALWAYS);
		Text designer = new Text("Designed and Distributed By: DukeWare");
		designer.setStyle("-fx-font-weight: bold; -fx-fill: red;");
		footer.getChildren().addAll(r, designer);
		mainPane.setBottom(footer);
		
		String css =this.getClass().getResource("/model/ui/main.css").toExternalForm();
		mainScene.getStylesheets().add(css);
		createLeftSidear();
		topBar();
		mainStage.setOnCloseRequest(e->{
			e.consume();
			this.closeProgram();
		});
	}
	
	private void createLeftSidear()
	{
		//create titlePane
		Button tpDashboard = new Button("DashBoard");
		tpDashboard.setPrefWidth(190);
		tpDashboard.setOnAction(e->{
			if(this.New_user.validDate())
			{
			Dashboard dash = new Dashboard(this.New_user);
			ScrollPane sideBarScroller = new ScrollPane(dash);
			sideBarScroller.setFitToWidth(true);
			mainPane.setCenter(sideBarScroller);
			}
			else {
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		tpDashboard.setStyle("-fx-background-color: #c0c0c0; -fx-border-color: grey; -fx-hovered-background: blue;"
				+ " -fx-font-weight: Bold; -fx-font-size: 18; -fx-font-family: Courier New;");
		tpDashboard.setPrefHeight(40);
		tpDashboard.setOnMousePressed(e->{
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				tpDashboard.setStyle("-fx-background-color: #c0c0c0; -fx-border-color: grey; -fx-hovered-background: blue;"
						+ " -fx-font-weight: Bold; -fx-font-size: 18; -fx-font-family: Courier New;");
			tpDashboard.setPrefHeight(35);
			tpDashboard.setLayoutY(tpDashboard.getLayoutY() + 4);
			}
		});
		tpDashboard.setOnMouseReleased(e->{
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				tpDashboard.setStyle("-fx-background-color: #c0c0c0; -fx-border-color: grey; -fx-hovered-background: blue;"
						+ " -fx-font-weight: Bold; -fx-font-size: 18; -fx-font-family: Courier New;");
			tpDashboard.setPrefHeight(45);
			tpDashboard.setLayoutY(tpDashboard.getLayoutY() - 4);
			}
		});
		tpDashboard.setOnMouseEntered(e->{
			tpDashboard.setEffect(new DropShadow());
		});
		tpDashboard.setOnMouseExited(e->{
			tpDashboard.setEffect(null);
		});
		//content of the titlePane)
		//#394a59  shineparkmotors@gmail.com
		
		TitledPane View = new TitledPane();
		View.setPrefHeight(40);
		View.setText("View");
		View.setStyle("-fx-font-weight: bold");
		mainButton viewStock = new mainButton("View Stock");
		viewStock.setOnAction(e->{
			if(this.New_user.validDate())
			{
			ViewStock Stock = new ViewStock(this.New_user);
			ScrollPane sideBarScroller = new ScrollPane(Stock);
			sideBarScroller.setFitToWidth(true);
			mainPane.setCenter(sideBarScroller);
			}
			else {
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		mainButton viewSup = new mainButton("View Supplier");
		viewSup.setOnAction(e->{
			if(this.New_user.validDate())
			{
			viewSupplier Sup = new viewSupplier(this.New_user);
			ScrollPane sideBarScroller = new ScrollPane(Sup);
			sideBarScroller.setFitToWidth(true);
			mainPane.setCenter(sideBarScroller);
			}
			else {
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		//content of the titlePane
		VBox vbStock = new VBox(5);
		vbStock.getChildren().addAll(viewStock, viewSup);
		View.setContent(vbStock);
		
		View.setExpanded(true);
		
		TitledPane addStock = new TitledPane();
		addStock.setPrefHeight(40);
		addStock.setText("ADD");
		mainButton addStocck = new mainButton("Add Stock");
		addStocck.setOnAction(e->{
			if(this.New_user.validDate())
			{
			AddCar add = new AddCar(this.New_user);
			ScrollPane sideBarScroller = new ScrollPane(add);
			sideBarScroller.setFitToWidth(true);
			mainPane.setCenter(sideBarScroller);
			}
			else {
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		mainButton addSupplier = new mainButton("Add Supplier");
		addSupplier.setOnAction(e->{
			if(this.New_user.validDate())
			{
			AddSupplier addSup = new AddSupplier(this.New_user);
			ScrollPane sideBarScroller = new ScrollPane(addSup);
			sideBarScroller.setFitToWidth(true);
			mainPane.setCenter(sideBarScroller);
			}
			else {
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		//content of the titlePane
		VBox vbAdd = new VBox(5);
		vbAdd.getChildren().addAll(addStocck, addSupplier);
		addStock.setContent(vbAdd);
		
		addStock.setExpanded(true);
		
		TitledPane stat = new TitledPane();
		stat.setPrefHeight(40);
		stat.setText("Statistics");
		mainButton carStat = new mainButton("Car Statistics");
		carStat.setOnAction(e->{
			CarStat carS = new CarStat(this.New_user);
			mainPane.setCenter(carS);
		});
		mainButton supStat = new mainButton("Supplier Statistics");
		supStat.setOnAction(e->{
			SupStat supS = new SupStat(this.New_user);
			mainPane.setCenter(supS);
		});
		//content of the titlePane
		VBox vbStati = new VBox(5);
		vbStati.getChildren().addAll(carStat, supStat);
		stat.setContent(vbStati);
		
		stat.setExpanded(true);
		
		TitledPane invoice = new TitledPane();
		invoice.setPrefHeight(40);
		invoice.setText("Invoices");
		mainButton createInvoice = new mainButton("Create Invoice");
		createInvoice.setOnAction(e->{
			
		});
		mainButton viewInvoices = new mainButton("View Invoice");
		viewInvoices.setOnAction(e->{
			
		});
		//content of the titlePane
		VBox vbInvoice = new VBox(5);
		vbInvoice.getChildren().addAll(createInvoice, viewInvoices);
		invoice.setContent(vbInvoice);
		
		invoice.setExpanded(false);
		
		VBox sideBar = new VBox();
		sideBar.setStyle("-fx-background-color: SteelBlue");
		sideBar.setPadding(new Insets(5));
		sideBar.setPrefWidth(200);
		sideBar.prefHeight(1670);
		sideBar.getChildren().addAll(tpDashboard, View, addStock, stat, invoice);
		mainPane.setLeft(sideBar);
	}
	
	
	private void topBar()
	{
		//imageView.setFitWidth(10);
		HBox topBar = new HBox(6);
		topBar.setPrefHeight(50);
		topBar.setPadding(new Insets(12,12,30,5));
		
		Image image = new Image("file:./data/holl.JPG");
		ImageView imageView = new ImageView(image);
		
		topBar.getChildren().add(imageView);
		
		DropShadow shadow = new DropShadow();
		shadow.setOffsetX(5);
		shadow.setOffsetY(5);
		
		//getting string from user
		int count = 0;
		String[] strArr = this.New_user.getUserName().split("\\s+");
		for(String token: strArr)
		{
			if(count>=1)
			{
				Text dealName = new Text(token);
				dealName.setStyle("-fx-fill: White");
				dealName.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
				dealName.setEffect(shadow);
				topBar.getChildren().add(dealName);
			}
			else
			{
				Text dealName1 = new Text(token);
				dealName1.setStyle("-fx-fill: Orange");
				dealName1.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
				dealName1.setEffect(shadow);
				topBar.getChildren().add(dealName1);
			}
			
			count++;
		}
		
		TextField searchCar = new TextField();
		searchCar.setPromptText("Car Model");
		Button btnSearch = new Button("Search Car");
		btnSearch.setStyle("-fx-background-color: #F43A23;	-fx-font-weight: bold; -fx-text-fill: white;");
		btnSearch.setOnMousePressed(e->{
			if(e.getButton().equals(MouseButton.PRIMARY))
			{
				btnSearch.setStyle("-fx-background-color: #F43A23;	-fx-font-weight: bold; -fx-text-fill: white;");
				btnSearch.setPrefHeight(10);
				btnSearch.setLayoutY(btnSearch.getLayoutY()+4);
			}
		});
		btnSearch.setOnMouseReleased(e->{
			if(e.getButton().equals(MouseButton.PRIMARY))
			{
				btnSearch.setStyle("-fx-background-color: #F43A23;	-fx-font-weight: bold; -fx-text-fill: white;");
				btnSearch.setPrefHeight(23);
				btnSearch.setLayoutY(btnSearch.getLayoutY()-4);
			}
		});
		btnSearch.setOnMouseEntered(e->{
			btnSearch.setEffect(new DropShadow());
		});
		btnSearch.setOnMouseExited(e->{
			btnSearch.setEffect(null);
		});
		btnSearch.setOnAction(e->{
			ViewStock stock = new ViewStock(this.New_user);
			searchCar.textProperty().addListener((v, oldValue, newValue)->{
				stock.getFilterData().setPredicate((Predicate<? super Car>) Car->{
					if(newValue==null || newValue.isEmpty())
					{
						return true;
					}
					String lowerCaseFilter = newValue.toLowerCase();
					if(Car.getMake().toLowerCase().contains(lowerCaseFilter))
					{
						return true;
					}
					else if(Car.getModel().toLowerCase().contains(lowerCaseFilter))
					{
						return true;
					}
					else if(Car.getOwner().getName().toLowerCase().contains(lowerCaseFilter))
					{
						return true;
					}
					return false;
				});
			});
			SortedList<Car> sortedData = new SortedList<>(stock.getFilterData());
			sortedData.comparatorProperty().bind(stock.getTable().comparatorProperty());
			stock.getTable().setItems(sortedData);
			this.mainPane.setCenter(stock);
		});
		topBar.setStyle("-fx-background-color: Navy");
		MenuBar mBar = new MenuBar();
		mBar.setStyle("-fx-background-color: Navy");
		Menu mProfile = new Menu(this.New_user.getUserDealName());
		mProfile.setStyle("-fx-font-weight: Bold; -fx-background-color: Navy; -fx-font-size: 18; -fx-fill: white;");
		ImageView profImg = new ImageView(new Image("file:./data/profile.png"));
		profImg.setFitHeight(32);
		profImg.setPreserveRatio(true);
		mProfile.setGraphic(profImg);
		MenuItem logout = new MenuItem("Logout");
		logout.setOnAction(e->{
			boolean result = AlertBox.display("Alert Window", "ARE YOU SURE YOU WANT TO CLOSE THIS PROGRAM?");
			if(result)
			{
				login log = new login();
				this.mainStage.close();
				log.getMainStage().showAndWait();
			}
		});
		MenuItem settings = new MenuItem("Settings");
		settings.setOnAction(e->{
			@SuppressWarnings("unused")
			settings set = new settings(this.New_user, this.mainStage);
		});
		mProfile.getItems().addAll(settings, logout);
		mBar.getMenus().add(mProfile);
		Region r = new Region();
		HBox.setHgrow(r, Priority.ALWAYS);
		topBar.getChildren().addAll(searchCar, btnSearch, r, mBar);
		mainPane.setTop(topBar);
	}
	
	private void closeProgram()
	{
		this.answer = AlertBox.display("Windows Alert Box", "Are you sure you want to exit?");
		if(answer) {
			login log = new login();
			this.mainStage.close();
			log.getMainStage().showAndWait();
			
		}
	}
}
