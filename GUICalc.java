import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class GUICalc extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {
	
		TextField tField = new TextField("0.0");
		
		tField.setEditable(false);
		
		Button bt7 = new Button("7");
		Button bt8 = new Button("8");
		Button bt9 = new Button("9");
		Button btDivide = new Button("/");
		
		Button bt4 = new Button("4");
		Button bt5 = new Button("5");
		Button bt6 = new Button("6");
		Button btMultiply = new Button("*");
		
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button btSubtract = new Button("-");
		
		Button btClear = new Button("C");
		Button bt0 = new Button("0");
		Button btDecimal = new Button(".");
		Button btAddition = new Button("+");
		
		Button btEquals = new Button("=");
		
		BorderPane bPane = new BorderPane();
		
		bPane.setTop(tField);
		
		GridPane gPane = new GridPane();
		
		gPane.add(bt7,0,0);
		gPane.add(bt8,1,0);
		gPane.add(bt9,2,0);
		gPane.add(btDivide,3,0);

		gPane.add(bt4,0,1);
		gPane.add(bt5,1,1);
		gPane.add(bt6,2,1);
		gPane.add(btMultiply ,3,1);

		gPane.add(bt1,0,2);
		gPane.add(bt2,1,2);
		gPane.add(bt3,2,2);
		gPane.add(btSubtract,3,2);
		
		gPane.add(btClear,0,3);
		gPane.add(bt0,1,3);
		gPane.add(btDecimal,2,3);
		gPane.add(btAddition,3,3);

		bPane.setCenter(gPane);
		
		bPane.setBottom(btEquals);
		
		tField.setMinWidth(300);
		tField.setMinHeight(75);
		tField.setStyle("-fx-font-weight: bold; -fx-font: 20pt Courier");
		
		btDivide.setMinWidth(75);
		btDivide.setMinHeight(75);
		
		btMultiply.setMinWidth(75);
		btMultiply.setMinHeight(75);
		
		btAddition.setMinWidth(75);
		btAddition.setMinHeight(75);
		
		btSubtract.setMinWidth(75);
		btSubtract.setMinHeight(75);
		
		btClear.setMinWidth(75);
		btClear.setMinHeight(75);
		
		btDecimal.setMinWidth(75);
		btDecimal.setMinHeight(75);
		
		bt0.setMinWidth(75);
		bt0.setMinHeight(75);
		
		bt1.setMinWidth(75);
		bt1.setMinHeight(75);
		
		bt2.setMinWidth(75);
		bt2.setMinHeight(75);
		
		bt3.setMinWidth(75);
		bt3.setMinHeight(75);
		
		bt4.setMinWidth(75);
		bt4.setMinHeight(75);
		
		bt5.setMinWidth(75);
		bt5.setMinHeight(75);
		
		bt6.setMinWidth(75);
		bt6.setMinHeight(75);
		
		bt7.setMinWidth(75);
		bt7.setMinHeight(75);
		
		bt8.setMinWidth(75);
		bt8.setMinHeight(75);
		
		bt9.setMinWidth(75);
		bt9.setMinHeight(75);
		
		btEquals.setMinWidth(300);			
		btEquals.setMinHeight(75);
		
	
		Scene scene = new Scene(bPane,300,450);
		
		primaryStage.setTitle("GUI Calc");
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
}
