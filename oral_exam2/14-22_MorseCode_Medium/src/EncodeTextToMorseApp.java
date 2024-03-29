import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EncodeTextToMorseApp extends Application {

    public static void main(String[] args){
        Application.launch(args); //launch the NumeralConverter application
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EncodeTextToMorse.fxml")); //load fxml file

            Scene scene = new Scene(root); //create new scene object with the loaded fxml of the scene builder design

            //set parameters of the stage which is the window that will show our application, and show it
            stage.setTitle("Morse Code app");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
