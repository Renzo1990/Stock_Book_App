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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
import model.model.Car;
import model.model.Supplier;
import model.model.user;

/**
 * @author ok
 *
 */
public class ViewStock extends VBox {
	
	private user User;
	private int numOfPage;
	private Pagination pagination;
	private int pageIndex;
	private TableView<Car> table;
	private ObservableList<Car> cars;
	private FilteredList<Car> filterData;
	/**
	 * @return the filterData
	 */
	public FilteredList<Car> getFilterData() {
		return filterData;
	}

	/**
	 * @param filterData the filterData to set
	 */
	public void setFilterData(FilteredList<Car> filterData) {
		this.filterData = filterData;
	}

	/**
	 * @return the cars
	 */
	public ObservableList<Car> getCars() {
		return cars;
	}

	/**
	 * @param cars the cars to set
	 */
	public void setCars(ObservableList<Car> cars) {
		this.cars = cars;
	}
	/**
	 * @return the table
	 */
	public TableView<Car> getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(TableView<Car> table) {
		this.table = table;
	}
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the numOfPage
	 */
	public int getNumOfPage() {
		return numOfPage;
	}

	/**
	 * @param numOfPage the numOfPage to set
	 */
	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}
	
	@SuppressWarnings("static-access")
	public ViewStock(user User)
	{
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
		this.User = User;
		cars = FXCollections.observableArrayList();
		cars = this.createTable(this.User);
		this.pageIndex = 0;
		this.numOfPage = cars.size()/20 +1;
		this.pagination = new Pagination(this.numOfPage);
		 filterData = new FilteredList<>(cars, e->true);
		table = new TableView<>();
		topHeader();
		topheader1();
		content();
		this.getChildren().add(pagination);
	}
	
	private void topHeader()
	{
		HBox header = new HBox(10);
		this.setPadding(new Insets(20,20,0,20));
		//Region r = new Region();
		//r.setPrefWidth(20);
		ImageView icon = new ImageView(new Image("file:./data/car1.png"));
		icon.setFitHeight(35);
		icon.setFitWidth(30);
		header.getChildren().addAll(icon);
		Text iconText = new Text("VIEW");
		iconText.setLayoutY(15);
		iconText.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-font-family: Courier new; -fx-fill: grey;");
		
		Image img = new Image("file:./data/search.png");
		ImageView viewImg = new ImageView(img);
		viewImg.setFitHeight(40);
		viewImg.setFitWidth(30);
		
		
		TextField search = new TextField();
		search.setPromptText("make, model or suppliers name");
		search.setPadding(new Insets(10,0,10,10));
		
		search.setOnKeyReleased(e->{
			search.textProperty().addListener((v, oldValue, newValue)->{
				this.filterData.setPredicate((Predicate<? super Car>) Car->{
					if(newValue== null || newValue.isEmpty())
					{
						return true;
					}
					String lowerCaseFilter = newValue.toLowerCase();
					if(Car.getMake().toLowerCase().contains(lowerCaseFilter))
					{
						return true;
					}
					String details = Car.getMake().toLowerCase()+" "+Car.getModel().toLowerCase();
					if(details.contains(lowerCaseFilter))
					{
						return true;
					}
					else if(Car.getModel().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}
					else if(Car.getOwner().getName().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Car> sortedData = new SortedList<>(this.filterData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);
		});
		
		header.getChildren().addAll(iconText, search,viewImg);
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
		Image img1 = new Image("file:./data/car.png");
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
		
		Image stockImg = new Image("file:./data/addStock.png");
		Label slash1 = new Label("  /  ");
		header1.getChildren().add(slash1);
		Label lblAddStock = new Label("VIEW VEHICLE");
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
		Image img1 = new Image("file:./data/car.png");
		ImageView imgView = new ImageView(img1);
		Label address = new Label("CAR INFORMATION TABLE");
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
		this.table.setItems(this.cars);
		TableColumn<Car, String> tbDealName = new TableColumn<>("CAR DETAILS");
		tbDealName.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14;");
		tbDealName.setMinWidth(380);
		tbDealName.setCellValueFactory(new PropertyValueFactory<>("carDetails"));
		
		TableColumn<Car, String> tbOwner = new TableColumn<>("MILEAGE");
		tbOwner.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 18;");
		tbOwner.setMinWidth(120);
		tbOwner.setCellValueFactory(new PropertyValueFactory<>("mileage"));
		
		/*TableColumn<Car, String> tbStatus = new TableColumn<>("STATUS");
		tbStatus.setStyle("-fx-text-fill: white");
		tbStatus.setMinWidth(90);
		tbStatus.setCellValueFactory(new PropertyValueFactory<>("status"));*/
		
		TableColumn<Car, Integer> tbPrice = new TableColumn<>("CAR PRICE");
		tbPrice.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 18;");
		tbDealName.setMinWidth(175);
		tbPrice.setCellValueFactory(new PropertyValueFactory<>("carPrice"));
		
		TableColumn<Car, String> tbAddr = new TableColumn<>("SUPPLIER'S DETAILS");
		tbAddr.setStyle("-fx-text-fill: yellow; -fx-font-weight: bold; -fx-font-size: 16;");
		tbAddr.setMinWidth(310);
		tbAddr.setCellValueFactory(new PropertyValueFactory<>("supplierDetails"));
		
		table.setRowFactory(tv -> new TableRow<Car>() {
			@Override
			protected void updateItem(Car item, boolean empty)
			{
				super.updateItem(item, empty);
				if(item == null)
				{
					setStyle("");
				}
				else if(!item.isStatus())
				{
					setTextFill(Color.WHITE);
					setStyle("-fx-background-color: red");
				}
				else if(item.isStatus())
				{
				setTextFill(Color.WHITE);
					setStyle("-fx-background-color: green");
				}
			}
		});
	    
		/*TableColumn<Car, String> tbPrice = new TableColumn<>("SUPPLIER'S DETAILS");
		tbAddr.setMinWidth(350);
		tbAddr.setCellValueFactory(new PropertyValueFactory<>("supplierDetails"));*/
		//table.setItems(arg0);
		table.setItems(this.cars);
		table.getColumns().addAll(tbDealName, tbOwner, tbPrice, tbAddr);
		addButtonTotable("EDIT CAR", "Edit");
		addButtonTotable("DELETE CAR", "Delete");
		content1.getChildren().add(table);
		this.getChildren().add(content1);
		
	}
	
	private void addButtonTotable(String actionName, String typeAction) {
		TableColumn<Car, Void> colBtn = new TableColumn<Car, Void>(actionName);
		Callback<TableColumn<Car, Void>, TableCell<Car, Void>>
		cellFactory = new Callback<TableColumn<Car, Void>, TableCell<Car, Void>>()
		{

			@Override
			public TableCell<Car, Void> call(final TableColumn<Car, Void> param) {
				final TableCell<Car, Void> cell = new TableCell<Car, Void>(){
					private final Button btn = new Button(typeAction);
					{
						btn.setOnAction(e->{
						 Car car = getTableView().getItems().get(getIndex());
						 
						 if(typeAction.equals(new String("Edit"))) {
							 @SuppressWarnings("unused")
						     updateStock stock = new updateStock(User, car);
						 }
						 else if(typeAction.equals(new String("Delete")))
						 {
							 if(AlertBox.display("Delet Window", "Deleting "+car.getCarDetails()))
							 {
								 if(DBHandler.execAction("DELETE FROM car WHERE CAR_ID="+car.getId(), "Succefully deleted"))
								 {
									 DBHandler.closeConnection();
								 }
							 }
						 }
						 //System.out.println("SelectedData: "+ car.isStatus());
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
	
	public static ObservableList<Car> createTable(user User)
	{
		ObservableList<Car> cars = FXCollections.observableArrayList();
		String query = "SELECT * FROM car WHERE CAR_DEALID ="+User.getUserId();
		ResultSet result = DBHandler.execQuery(query);
		ResultSet supResult = null, make = null, model = null;
		try {
			while(result.next())
			{
				supResult = DBHandler.execQuery("SELECT * FROM supplier WHERE SUP_ID ="+result.getInt("CAR_SUPID"));
				supResult.next();
				String name = supResult.getString("SUP_NAME");
				String num = supResult.getString("SUP_NUM");
				String num1 = supResult.getString("SUP_NUM1");
				int id = supResult.getInt("SUP_ID");
				Supplier supplier = new Supplier(name, num, num1, id);
				make = DBHandler.execQuery("SELECT make FROM make WHERE makeId ="+result.getInt("CAR_MAKEID"));
				make.next();
				model = DBHandler.execQuery("SELECT model FROM model WHERE modelId ="+result.getInt("CAR_MODELID"));
				model.next();
				Car car = new Car(result.getInt("CAR_ID"), make.getString("make"), model.getString("model"), 
						result.getString("CAR_TRANS"),result.getString("CAR_ENGINE"), result.getString("CAR_COLOR"), result.getInt("CAR_PRICE"),
						result.getString("CAR_DESC"), result.getInt("CAR_YEAR"), result.getInt("CAR_MILEAGE"), result.getString("CAR_BODY_TYPE"), result.getString("CAR_ENGINE"));
				car.setSupplierDetails(supplier.getName() + " : "+ supplier.getNumber()+" / "+supplier.getNumber1());
				car.setCarDetails(car.getColour()+" "+car.getYearModel()+" "+car.getMake()+" "+car.getModel()+" "
				+car.getVariants()+" "+car.getTransmission()+" "+car.getBodyType()
				+"\n"+car.getDesc()+"\n\n");
				car.setStatus(result.getBoolean("CAR_STATUS"));
				car.setDesc(result.getString("CAR_DESC"));
				car.setOwner(supplier);
				cars.add(car);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("erorrsssssssssssss");
			e.printStackTrace();
		}
		/*try {
			supResult.close();
			make.close();
			model.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		DBHandler.closeConnection();
		return cars;
	}
  
}
