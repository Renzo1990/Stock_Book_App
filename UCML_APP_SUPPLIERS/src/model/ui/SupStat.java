/**
 * 
 */
package model.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.model.Car;
import model.model.user;

/**
 * @author ok
 *
 */
public class SupStat extends VBox {

	@SuppressWarnings("unused")
	private user User;
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	public SupStat(user User)
	{
		Image back = new Image("file:./data/back.jpg");
		BackgroundImage background = new BackgroundImage(back, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
		
		this.User = User;
		this.xAxis = new CategoryAxis();
		this.yAxis = new NumberAxis();
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
		ImageView icon = new ImageView(new Image("file:./data/stat.png"));
		icon.setFitHeight(35);
		icon.setFitWidth(30);
		header.getChildren().addAll(icon);
		Text iconText = new Text("STATISTICS");
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
		Image img1 = new Image("file:./data/stat.png");
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
		Label lblDash = new Label("STATISTICS");
		ImageView view1 = new ImageView(img1);
		view1.setFitHeight(18);
		view1.setFitWidth(15);
		lblDash.setGraphic(view1);
		lblDash.setTextFill(Color.GREY);
		lblDash.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblDash);
		
		Image stockImg = new Image("file:./data/money.png");
		Label slash1 = new Label("  /  ");
		header1.getChildren().add(slash1);
		Label lblAddStock = new Label("SUPPLIER STATISTICS");
		ImageView AddStock = new ImageView(stockImg);
		AddStock.setFitHeight(18);
		AddStock.setFitWidth(15);
		lblAddStock.setGraphic(AddStock);
		lblAddStock.setTextFill(Color.GREY);
		lblAddStock.setStyle("-fx-font-weight: bold");
		header1.getChildren().add(lblAddStock);
		
		
		this.getChildren().add(header1);
		
	}
	
	@SuppressWarnings("rawtypes")
	private void content()
	{
		VBox content = new VBox(10);
		content.setPadding(new Insets(15, 5, 5, 10));
		content.setStyle("-fx-background-color: white");
		content.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HBox header = new HBox(10);
		header.setPadding(new Insets(5,0,5,10));
		header.setStyle("-fx-background-color: Silver");
		Text txtChart = new Text("Charts");
		txtChart.setFill(Color.LIGHTSLATEGRAY);
		txtChart.setStyle("-fx-font-family: Sanserif; -fx-font-weight: bold; -fx-font-size: 22;");
		header.getChildren().add(txtChart);
		content.getChildren().add(header);
		
		HBox hBox = new HBox(5);
		
		
		VBox box = new VBox(10);
		box.setPrefHeight(450);
		@SuppressWarnings({ "unchecked" })
		BarChart chart = new BarChart(this.xAxis, this.yAxis, getChartData());
		box.getChildren().add(chart);
		hBox.getChildren().add(box);
		
		VBox box1 = new VBox(10);
		box1.setPrefHeight(450);
		@SuppressWarnings({ "unchecked", "unused" })
		AreaChart chart1 = new AreaChart(this.xAxis, this.yAxis, getChartData());
		box1.getChildren().add(chart1);
		hBox.getChildren().add(box1);
		
		content.getChildren().add(hBox);
		this.getChildren().add(content);
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	private ObservableList<Series<String, Integer>> getChartData()
	{
		//int bmwValue = 17;
		ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();
		for(Car car: ViewStock.createTable(User))
		{
			if(!data.contains(car.getMake()))
			{
			Series<String, Integer> bmw = new Series<>();
			bmw.setName(car.getMake());
			bmw.getData().add(new XYChart.Data<String, Integer>(Integer.toString(car.getYearModel()), this.countNumOfCars(car.getMake())));
			//bmwValue = (int)(bmwValue + 4*Math.random() - 0.2);
			
			data.addAll(bmw);
			}
		}
		
		
		return data;
		
	}
	
	private int countNumOfCars(String make)
	{
		int count = 0;
		for(Car car: ViewStock.createTable(User))
		{
			if(car.getMake().contains(make))
			{
				count++;
			}
		}
		return count;
	}
}
