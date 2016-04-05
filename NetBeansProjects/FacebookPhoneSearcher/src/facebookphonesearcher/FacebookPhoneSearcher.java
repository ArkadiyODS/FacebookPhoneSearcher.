package facebookphonesearcher;

import interfaces.Modelable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Arkadiy
 */
public class FacebookPhoneSearcher extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Modelable model = new TestModel();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
      loader.setController(new FXMLDocumentController(model));
        Parent root =  (Parent)loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
