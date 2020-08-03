import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import java.util.Optional;			
import javafx.geometry.Insets;
import javafx.scene.control.Alert;				
import javafx.scene.control.Alert.AlertType;
		
public class LibraryGUI extends Application	{
	
	private Library LibraryObj = new Library();	
	
	ListView <MediaItem> lv = new ListView <MediaItem>();		
		
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		//refreshViewList();
		
		BorderPane bPane = new BorderPane();	
		GridPane gPane = new GridPane();			
		
		lv.setPrefSize(400, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setStyle("-fx-font-size: 20px; -fx-font-family: mono-spaced");
		
		bPane.setCenter(lv);			
		bPane.setBottom(gPane);		
		
		gPane.setPadding(new Insets(15,15,15,15));	
		gPane.setVgap(10);							
		gPane.setHgap(10);							
		
		AddHandler aHandler = new AddHandler();						
		CheckOutHandler coHandler = new CheckOutHandler();			
		CheckInHandler ciHandler = new CheckInHandler();
		DeleteHandler dHandler = new DeleteHandler();
		
		Button btAdd = new Button("Add");													
		btAdd.setPrefSize(200, 40);																				
		gPane.add(btAdd, 0, 0);												
		btAdd.setOnAction(aHandler);	
		
		Button btCheckOut = new Button ("Check Out");
		btCheckOut.setPrefSize(200, 40);
		btCheckOut.setDisable(true);
		gPane.add(btCheckOut, 1, 0);
		btCheckOut.setOnAction(coHandler);
		
		Button btCheckIn = new Button("Check In");
		btCheckIn.setPrefSize(200, 40);
		btCheckIn.setDisable(true);
		gPane.add(btCheckIn, 2, 0);
		btCheckIn.setOnAction(ciHandler);
		
		Button btDelete = new Button("Delete");		
		btDelete.setPrefSize(200, 40);
		btDelete.setDisable(true);
		gPane.add(btDelete, 3, 0);
		btDelete.setOnAction(dHandler);
		
		lv.setOnMouseReleased((event) ->{
			ObservableList<MediaItem> button = lv.getSelectionModel().getSelectedItems();
			
			if(button.size() <= 0) {
				btCheckOut.setDisable(true);
				btCheckIn.setDisable(true);
				btDelete.setDisable(true);
			}
			else {
				btCheckOut.setDisable(false);
				btCheckIn.setDisable(false);
				btDelete.setDisable(false);
			}
		});
		
		Scene scene = new Scene (bPane,500,500);			
		primaryStage.setTitle("My Library");				
		primaryStage.setScene(scene);								
		primaryStage.show();										
	}
	
	public void refreshViewList() {
		ObservableList<MediaItem> arrayList = lv.getItems();																			
        arrayList.clear();												
        																	 
        for (MediaItem mediaItem : LibraryObj.listOfMediaItems)	{																		
           	arrayList.add(mediaItem);
        }
    }
	
	public String getInput(String contentText) {
	    TextInputDialog db = new TextInputDialog();
	    db.setTitle("Input");
	    db.setHeaderText("");
	    db.setContentText(contentText);
	       
	    Optional<String> result = db.showAndWait();
	           
	    if(result.isPresent()) {
	        return result.get();
	    }
	    else {
	        return "";
	    }    
	}
	
	public static void displayError(Exception ex, String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(errorMessage);
	}
	
	class AddHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			String title = getInput("Title:");
			String format = getInput ("Format:");
			
			if(title.equals("") && !format.equals("")) {
				return;
			}
			else {
				LibraryObj.addNewItem(title, format);
				refreshViewList();
			}
		}
	}
	
	class CheckOutHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			String name = getInput("Who did you loan this to?");
			String date = getInput("When did you loan it(data)?");
			
			 for (MediaItem mediaItem : lv.getSelectionModel().getSelectedItems()) {
				 try {
					 LibraryObj.markItemOnLoan(mediaItem, name, date);
				 }
				 catch (RuntimeException ex) {
					 Alert alert = new Alert(AlertType.ERROR);
					 alert.setTitle("Message");
					 alert.setHeaderText("");
					 alert.setContentText("This item is already loaned out.");
					 alert.showAndWait();
				 } 
	         }
			refreshViewList();
		}
	}
	
	class CheckInHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			
			for(MediaItem mediaItem: lv.getSelectionModel().getSelectedItems()) {
				try {
					LibraryObj.markItemReturned(mediaItem);
				}
				catch (RuntimeException ex) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Message");
					alert.setHeaderText("");
					alert.setContentText("This item is already checked in.");
					alert.showAndWait();
				}
			}
			refreshViewList();
		}
	}
	
	class DeleteHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {

			for(MediaItem mediaItem: lv.getSelectionModel().getSelectedItems()) {
				LibraryObj.delete(mediaItem);
			}
			refreshViewList();
		}
	}
}