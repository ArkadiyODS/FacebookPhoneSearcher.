/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookphonesearcher;

import facebookphonesearcher.AsyncExecutors.*;
import interfaces.Modelable;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.List;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {
    
    private Modelable mainModel;    
    private ObservableList personsCollection; 
    
    @FXML
    private Button startButton; 
    
    @FXML
    private Label avatarName;
    
    @FXML
    private Button stopButton; 
    
    @FXML
    private ImageView avatarImage;
    
    @FXML
    private TableView<Person> mainTable;
    
    @FXML
    private TableColumn<Person,String> phoneColumn;
    
     @FXML
    private TableColumn<Person,String> personColumn;
    
     
    private Service getAvatarNameService;
    private Service getAvatarImageService;
    private Service getCollectionService;
    
    private void handleButtonActionStart(ActionEvent event) {
        System.out.println("You clicked me!");
        Image img = new Image("img/j.png");
        avatarImage.setImage(img); 
        System.out.println("You Start");
        
    }  
    
    private void handleButtonActionStop(ActionEvent event) {
        Image img = new Image("https://scontent-frt3-1.xx.fbcdn.net/hprofile-xtp1/v/t1.0-1/p50x50/11752566_824057744358805_6624847018844291316_n.jpg?oh=6aee705d918a0a37244162559eb8e935&oe=578BEDA6");
        avatarImage.setImage(img);  
        System.out.println("You Stop");  
    }
    
    public FXMLDocumentController(Modelable model){
        this.mainModel = model; 
        getAvatarNameService = new GetNameService(mainModel);
        getAvatarImageService = new GetAvatarService(mainModel);
        getCollectionService = new GetPhoneCollectionService(mainModel);
    }
    
    private void getCollection() {  
             getCollectionService.setOnSucceeded((w)->{
                personsCollection = FXCollections.observableList((List<Person>)getCollectionService.getValue());
                mainTable.setItems(personsCollection);
             }); 
            getCollectionService.start(); 
    }
    
    private void getAvatar() {  
            getAvatarNameService.setOnSucceeded((w)->{
            avatarName.setText((String)getAvatarNameService.getValue());  
        }); 
        getAvatarNameService.start();
        
        getAvatarImageService.setOnSucceeded((w)->{
            avatarImage.setImage((Image)getAvatarImageService.getValue());  
        }); 
        getAvatarImageService.start();
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        startButton.setOnAction((e)->{  
                this.handleButtonActionStart(e); 
        });
        stopButton.setOnAction((e)->{  
                this.handleButtonActionStop(e); 
        });
        
        personColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
  
        getCollection();
        getAvatar();
    }    
    
}
