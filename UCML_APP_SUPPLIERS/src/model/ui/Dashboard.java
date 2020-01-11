/**
 * 
 */
package model.ui;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.model.Car;
import model.model.user;

/**
 * @author ok
 *
 */
public class Dashboard extends StackPane {

	private user user1;
	/**
	 * @return the user1
	 */
	public user getUser1() {
		return user1;
	}

	private VBox box;
	public Dashboard(user user1)
	{
		box = new VBox(5);
		this.user1 = user1;
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.box.setBackground(new Background(background));
		this.setBackground(new Background(background));
		topHeader();
		topheader1();
		content();
		content1();
		content2();
		this.getChildren().add(box);
	}
	
	private void topHeader()
	{
		HBox header = new HBox(10);
		this.setPadding(new Insets(20,5,0,5));
		//Region r = new Region();
		//r.setPrefWidth(20);
		ImageView icon = new ImageView(new Image("file:./data/icon.png"));
		icon.setFitHeight(35);
		icon.setFitWidth(30);
		header.getChildren().addAll(icon);
		Text iconText = new Text("Dashboard");
		iconText.setLayoutY(15);
		iconText.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-font-family: Courier new; -fx-fill: grey;");
		header.getChildren().add(iconText);
		this.box.getChildren().add(header);
	}
	private void topheader1()
	{
		this.box.setSpacing(20);
		FlowPane header1 = new FlowPane();
		header1.setAlignment(Pos.CENTER_LEFT);
		header1.setPadding(new Insets(5,0,10,0));
		header1.setStyle("-fx-background-color: white");
		//header1.setMaxHeight(4);
		//header1.setPadding(new Insets(10, 0, 0, 0));
		Image img = new Image("file:./data/home.png");
		Image img1 = new Image("file:./data/dash.png");
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
		Label lblDash = new Label("DashBoard");
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(18);
		view1.setFitWidth(15);
		lblDash.setGraphic(view1);
		lblDash.setTextFill(Color.GREY);
		lblDash.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblDash);
		this.box.getChildren().add(header1);
		
		
	}
	
	private void content()
	{
		HBox content = new HBox(41);
		//Rectangle 1
		Rectangle rect = new Rectangle(250, 150);
		rect.setFill(Color.BLUEVIOLET);
		HBox set = new HBox(50);
		set.setPadding(new Insets(35,10,10,10));
		Image stock = new Image("file:./data/stocks.png");
		ImageView stockView = new ImageView(stock);
		set.getChildren().add(stockView);
		
		//total number of stock
		VBox box = new VBox(7);
		Text numStock = new Text(" "+ViewStock.createTable(this.user1).size());
		numStock.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 28");
		box.getChildren().add(numStock);
		Text strStock = new Text("STOCK");
		strStock.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 24");
		box.getChildren().add(strStock);
		set.getChildren().add(box);
		
		StackPane stack = new StackPane(rect);
		stack.getChildren().add(set);
		content.getChildren().add(stack);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Rectangle 2
		Rectangle rect1 = new Rectangle(250, 150);
		HBox set1 = new HBox(50);
		set1.setPadding(new Insets(35,10,10,10));
		rect1.setFill(Color.LIMEGREEN);
		Image supplier = new Image("file:./data/supplier.png");
		ImageView supplierView = new ImageView(supplier);
		set1.getChildren().add(supplierView);
		
		//total number of suppliers
		VBox box1 = new VBox(7);
		Text numSupply = new Text(" "+viewSupplier.createTable(this.user1).size());
		numSupply.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 28");
		box1.getChildren().add(numSupply);
		Text strSupplier = new Text("SUPPLIER");
		strSupplier.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 24");
		box1.getChildren().add(strSupplier);
		set1.getChildren().add(box1);
		
		StackPane stack1 = new StackPane(rect1);
		stack1.getChildren().add(set1);
		content.getChildren().add(stack1);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Rectangle 3
		Rectangle rect2 = new Rectangle(250, 150);
		rect2.setFill(Color.RED);
		HBox set2 = new HBox(50);
		set2.setPadding(new Insets(35,10,10,10));
		Image invoice = new Image("file:./data/invoice.png");
		ImageView invoiceView = new ImageView(invoice);
		set2.getChildren().add(invoiceView);
		
		//total number of suppliers
		VBox box2 = new VBox(7);
		Text numInvoice = new Text("00.00");
		numInvoice.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 28");
		box2.getChildren().add(numInvoice);
		Text strInv = new Text("INVOICE");
		strInv.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 24");
		box2.getChildren().add(strInv);
		set2.getChildren().add(box2);
		
		StackPane stack2 = new StackPane(rect2);
		stack2.getChildren().add(set2);
		content.getChildren().add(stack2);
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Rectangle 4
		Rectangle rect3 = new Rectangle(250, 150);
		rect3.setFill(Color.DARKCYAN);
		HBox set3 = new HBox(40);
		set3.setPadding(new Insets(35,10,10,10));
		Image avail = new Image("file:./data/car.png");
		ImageView viewAv = new ImageView(avail);
		set3.getChildren().add(viewAv);
		
		//total number of suppliers
		VBox box3 = new VBox(7);
		Text numAv = new Text(" "+this.availableCars(ViewStock.createTable(this.user1)));
		numAv.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 28");
		box3.getChildren().add(numAv);
		Text strAv = new Text("AVAILABLE");
		strAv.setStyle("-fx-fill: linear-gradient(white, Silver); -fx-font-weight: bold; -fx-font-family: courier new; -fx-font-size: 24");
		box3.getChildren().add(strAv);
		set3.getChildren().add(box3);
		
		StackPane stack3 = new StackPane(rect3);
		stack3.getChildren().add(set3);
		content.getChildren().add(stack3);
		
		this.box.getChildren().add(content);
	}
	
	private void content1()
	{
		VBox content1 = new VBox(5);
		content1.setPrefHeight(350);
		content1.setPadding(new Insets(5,5,5,5));
		content1.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HBox header = new HBox(5);
		header.setStyle("-fx-border-color: DARKGRAY; -fx-background-color: LIGHTGRAY;");
		Image img1 = new Image("file:./data/location.png");
		ImageView imgView = new ImageView(img1);
		Label address = new Label("Address");
		address.setGraphic(imgView);
		imgView.setFitHeight(20);
		imgView.setFitWidth(18);
		address.setTextFill(Color.BLACK);
		address.setStyle("-fx-font-weight: bold");
		Region r = new Region();
		Image delete = new Image("file:./data/delete.png");
		ImageView deleteView = new ImageView(delete);
		deleteView.setFitHeight(20);
		deleteView.setFitWidth(18);
		HBox.setHgrow(r, Priority.ALWAYS);
		header.getChildren().add(address);
		header.getChildren().add(r);
		Image ref = new Image("file:./data/reload.png");
		ImageView refView = new ImageView(ref);
		refView.setFitHeight(20);
		refView.setFitWidth(18);
        header.getChildren().add(refView);
        Image up = new Image("file:./data/arrow.png");
		ImageView upView = new ImageView(up);
		upView.setFitHeight(20);
		upView.setFitWidth(18);
		upView.setRotate(180);
		header.getChildren().add(upView);
		header.getChildren().add(deleteView);
		
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		final URL urlGoogleMaps = getClass().getResource("home.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
		
		content1.getChildren().addAll(header, webView);
		this.box.getChildren().add(content1);
		
		
	}
	@SuppressWarnings("unchecked")
	private void content2()
	{
		VBox content1 = new VBox(5);
		content1.prefHeight(100);
		content1.setPadding(new Insets(5,5,5,5));
		content1.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HBox header = new HBox(5);
		header.setStyle("-fx-border-color: DARKGRAY; -fx-background-color: LIGHTGRAY;");
		Image img1 = new Image("file:./data/location.png");
		ImageView imgView = new ImageView(img1);
		Label address = new Label("DEALERSHIP DETAILS");
		address.setGraphic(imgView);
		imgView.setFitHeight(20);
		imgView.setFitWidth(18);
		address.setTextFill(Color.BLACK);
		address.setStyle("-fx-font-weight: bold");
		Region r = new Region();
		Image delete = new Image("file:./data/icons/delete.png");
		ImageView deleteView = new ImageView(delete);
		deleteView.setFitHeight(20);
		deleteView.setFitWidth(18);
		HBox.setHgrow(r, Priority.ALWAYS);
		header.getChildren().add(address);
		header.getChildren().add(r);
		Image ref = new Image("file:./data/icons/reload.png");
		ImageView refView = new ImageView(ref);
		refView.setFitHeight(20);
		refView.setFitWidth(18);
        header.getChildren().add(refView);
        Image up = new Image("file:./data/icons/arrow.png");
		ImageView upView = new ImageView(up);
		upView.setFitHeight(20);
		upView.setFitWidth(18);
		upView.setRotate(180);
		header.getChildren().add(upView);
		header.getChildren().add(deleteView);
		
		content1.getChildren().addAll(header);
		
		//DEALER INFO TABLE
		ObservableList<user> Users = FXCollections.observableArrayList();
		Users.add(this.user1);
		TableView<user> table = new TableView<>();
		table.setPrefHeight(80);
		//create column
		TableColumn<user, String> tbDealName = new TableColumn<>("Dealership Name ");
		tbDealName.setMinWidth(200);
		tbDealName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
		TableColumn<user, String> tbDetails = new TableColumn<>("Dealership Email ");
		tbDetails.setMinWidth(200);
		tbDetails.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
		
		TableColumn<user, String> tbNumbber = new TableColumn<>("Dealership Number ");
		tbNumbber.setMinWidth(100);
		tbNumbber.setCellValueFactory(new PropertyValueFactory<>("userNumber"));
		
		TableColumn<user, String> tbOwner = new TableColumn<>("Dealership Owner ");
		tbOwner.setMinWidth(100);
		tbOwner.setCellValueFactory(new PropertyValueFactory<>("userDealName"));
		
		TableColumn<user, String> tbAddr = new TableColumn<>("Dealership Address ");
		tbAddr.setMinWidth(250);
		tbAddr.setCellValueFactory(new PropertyValueFactory<>("userAddress"));
		//table.setItems(arg0);
		table.setItems(Users);
		table.getColumns().addAll(tbDealName, tbDetails, tbNumbber, tbOwner, tbAddr);
		content1.getChildren().add(table);
		this.box.getChildren().add(content1);
		
	}
	
	private int availableCars(ObservableList<Car> cars)
	{
		int num = 0;
		for(Car car: cars)
		{
			if(car.isStatus())
				num++;
		}
		return num;
	}
}
