package GUI;

import GUI.FXMLDocumentController;
import Model.FacebookParser.FacebookParser;
import QA.TestModel;
import interfaces.Modelable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class FacebookPhoneSearcher extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       Modelable model = new FacebookParser();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
       loader.setController(new FXMLDocumentController(model, stage));
       Parent root =  (Parent)loader.load();
       Scene scene = new Scene(root);
       stage.setTitle("FacebookPeopleFinder");
       stage.setScene(scene);
       stage.setMinWidth(800);
       stage.setMinHeight(600);
       stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
