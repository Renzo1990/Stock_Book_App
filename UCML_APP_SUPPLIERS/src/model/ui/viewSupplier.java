/**
 * 
 */
package model.ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.database.DBHandler;
import model.model.Supplier;
import model.model.user;

/**
 * @author ok
 *
 */
public class viewSupplier extends VBox {

	private ObservableList<Supplier> Suppliers;
	private user User;
	private FilteredList<Supplier> filterData;
	private TableView<Supplier> table;
	@SuppressWarnings("static-access")
	public viewSupplier(user User)
	{
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
		
		this.User = User;
		Suppliers = FXCollections.observableArrayList();
		Suppliers = this.createTable(this.User);
		filterData = new FilteredList<>(Suppliers, e->true);
	    table = new TableView<>();
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
		ImageView icon = new ImageView(new Image("file:./data/viewSup.png"));
		icon.setFitHeight(35);
		icon.setFitWidth(30);
		header.getChildren().addAll(icon);
		Text iconText = new Text("VIEW");
		iconText.setLayoutY(15);
		iconText.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-font-family: Courier new; -fx-fill: grey;");
		TextField search = new TextField();
		search.setPromptText("search suppliers by name or number");
		search.setPadding(new Insets(10,0,10,10));
		
		search.setOnKeyReleased(e->{
			search.textProperty().addListener((observableValue, oldValue, newValue)->{
				
				filterData.setPredicate((Predicate<? super Supplier>) Supplier->{
					if(newValue==null|| newValue.isEmpty()) {
						return true;
					}
					String lowerCaseFilter = newValue.toLowerCase();
					if(Supplier.getName().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}
					else if(Supplier.getNumber().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Supplier> sortedData = new SortedList<>(this.filterData);
			sortedData.comparatorProperty().bind(this.table.comparatorProperty());
			table.setItems(sortedData);
		});
		
		Image img = new Image("file:./data/search.png");
		ImageView viewImg = new ImageView(img);
		viewImg.setFitHeight(40);
		viewImg.setFitWidth(30);
		
		header.getChildren().addAll(iconText, search, viewImg);
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
		Image img1 = new Image("file:./data/supplier.png");
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
		Label lblDash = new Label("VIEW");
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(18);
		view1.setFitWidth(15);
		lblDash.setGraphic(view1);
		lblDash.setTextFill(Color.GREY);
		lblDash.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblDash);
		
		Image stockImg = new Image("file:./data/viewSup.png");
		Label slash1 = new Label("  /  ");
		header1.getChildren().add(slash1);
		Label lblAddStock = new Label("VIEW SUPPLIERS");
		ImageView AddStock = new ImageView(stockImg);
		AddStock.setFitHeight(18);
		AddStock.setFitWidth(15);
		lblAddStock.setGraphic(AddStock);
		lblAddStock.setTextFill(Color.GREY);
		lblAddStock.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblAddStock);
		
		
		this.getChildren().add(header1);
		
	}
	
	@SuppressWarnings("unchecked")
	private void content()
	{
		VBox content1 = new VBox(5);
		content1.prefHeight(100);
		content1.setPadding(new Insets(5,5,5,5));
		content1.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HBox header = new HBox(5);
		header.setStyle("-fx-border-color: DARKGRAY; -fx-background-color: LIGHTGRAY;");
		Image img1 = new Image("file:./data/viewSup.png");
		ImageView imgView = new ImageView(img1);
		Label address = new Label("SUPPLIERS DETAILS");
		address.setGraphic(imgView);
		imgView.setFitHeight(25);
		imgView.setFitWidth(20);
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
		
		content1.getChildren().addAll(header);
		
		//DEALER INFO TABLE
		//table.setPrefHeight(80);
		//create column
		
		this.table.setItems(Suppliers);
		
		TableColumn<Supplier, String> tbDealName = new TableColumn<>("SUPPLIER'S NAME ");
		tbDealName.setMinWidth(250);
		tbDealName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		TableColumn<Supplier, String> tbDetails = new TableColumn<>("SUPPLIER'S MOBILE ");
		tbDetails.setMinWidth(200);
		tbDetails.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		TableColumn<Supplier, String> tbNumbber = new TableColumn<>("SUPPLIER'S MOBILE1 ");
		tbNumbber.setMinWidth(200);
		tbNumbber.setCellValueFactory(new PropertyValueFactory<>("number1"));
		
		TableColumn<Supplier, String> tbOwner = new TableColumn<>("SUPPLIER'S NATIONALITY ");
		tbOwner.setMinWidth(250);
		//tbOwner.setCellValueFactory(new PropertyValueFactory<>("userDealName"));
		table.getColumns().addAll(tbDealName, tbDetails, tbNumbber, tbOwner);
		addButtonTotable();
		
		
		//table.setItems(arg0);
		
		content1.getChildren().add(table);
		this.getChildren().add(content1);
		
	}

	public static ObservableList<Supplier> createTable(user User)
	{
		ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
		ResultSet result = DBHandler.execQuery("SELECT * FROM supplier WHERE DEAL_ID="+User.getUserId());
		try {
			while(result.next())
			{
				suppliers.add(new Supplier(result.getString("SUP_NAME"), result.getString("SUP_NUM"), result.getString("SUP_NUM1"),
						result.getInt("SUP_ID")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHandler.closeConnection();
		return suppliers;
	}
	
	private void addButtonTotable() {
		TableColumn<Supplier, Void> colBtn = new TableColumn<Supplier, Void>("Action");
		Callback<TableColumn<Supplier, Void>, TableCell<Supplier, Void>>
		cellFactory = new Callback<TableColumn<Supplier, Void>, TableCell<Supplier, Void>>()
		{

			@Override
			public TableCell<Supplier, Void> call(final TableColumn<Supplier, Void> param) {
				final TableCell<Supplier, Void> cell = new TableCell<Supplier, Void>(){
					private final Button btn = new Button("Edit");
					{
						btn.setOnAction(e->{
						 Supplier supply = getTableView().getItems().get(getIndex());
						 @SuppressWarnings("unused")
						updateSupplier update = new updateSupplier(User, supply);
						 System.out.println("SelectedData: "+ supply.getName());
						});
					}
					     @Override
					     public void updateItem(Void item, boolean empty) {
					    	 super.updateItem(item, empty);
					    	 if(empty) {
					    		 setGraphic(null);
					    	 }else {
					    		 setGraphic(btn);
					    	 }
					     }
					};
				return cell;
			}
			
		};
		colBtn.setCellFactory(cellFactory);
		table.getColumns().add(colBtn);
	}

}
