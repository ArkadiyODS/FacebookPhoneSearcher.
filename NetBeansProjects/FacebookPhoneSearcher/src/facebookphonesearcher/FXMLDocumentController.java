/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookphonesearcher;

import facebookphonesearcher.AsyncExecutors.ModelAsyncService;
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
     
    private Service service;
    
    private void handleButtonActionStart(ActionEvent event) {
        System.out.println("You clicked me!");
        Image img = new Image("img/j.png");
        avatarImage.setImage(img); 
        System.out.println("You Start");
        service.start();
        service.setOnSucceeded((w)->{
            avatarName.setText((String)service.getValue());  
        });
    }  
    
    private void handleButtonActionStop(ActionEvent event) {
        Image img = new Image("https://scontent-frt3-1.xx.fbcdn.net/hprofile-xtp1/v/t1.0-1/p50x50/11752566_824057744358805_6624847018844291316_n.jpg?oh=6aee705d918a0a37244162559eb8e935&oe=578BEDA6");
        avatarImage.setImage(img);  
        System.out.println("You Stop");  
    }
    
    public FXMLDocumentController(Modelable model){
        this.mainModel = model;
        service = new ModelAsyncService(model);
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        personsCollection = FXCollections.observableList(mainModel.getPhoneCollection());
        startButton.setOnAction((e)->{  
                this.handleButtonActionStart(e); 
        });
        stopButton.setOnAction((e)->{  
                this.handleButtonActionStop(e); 
        });
    }    
    
}
