package GUI;

import DataClasses.PersonFoundEvent;
import DataClasses.Person;
import AsyncServices.Implementation.GetAvatarService;
import AsyncServices.Implementation.GetPhoneCollectionService;
import AsyncServices.Implementation.StartSearchService;
import AsyncServices.Implementation.GetNameService;
import interfaces.Modelable;
import interfaces.PersonFindListener; 
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle; 
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLDocumentController implements Initializable, PersonFindListener {
    
    private final Modelable mainModel; 
    private final Stage mainStage;
    private ObservableList<Person> personsCollection; 
    
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
    private Service startSearchService;
    
    private void handleButtonActionStart(ActionEvent event) { 
         
        System.out.println("Start search");  
        startSearchService.start();
    }  
    
    private void handleButtonActionStop(ActionEvent event) {
        startSearchService.cancel();
        System.out.println("Stop search");  
    }
    
    public FXMLDocumentController(Modelable model, Stage stage){
        this.mainModel = model; 
        this.mainStage = stage; 
        
        mainModel.addListener(this);
        
        getAvatarNameService = new GetNameService(mainModel);
        getAvatarImageService = new GetAvatarService(mainModel);
        getCollectionService = new GetPhoneCollectionService(mainModel);
        startSearchService = new StartSearchService(mainModel);
        
        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
               getAvatarNameService.cancel();
               getAvatarImageService.cancel();
               getCollectionService.cancel(); 
               startSearchService.cancel(); 
               mainModel.Close();
            }
        });
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
        getAvatarImageService.setOnSucceeded((w)->{
            avatarImage.setImage((Image)getAvatarImageService.getValue());  
        });  
        getAvatarNameService.start(); 
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

    @Override
    public synchronized void personFound(PersonFoundEvent personEvent) {
        if(personsCollection != null)
            personsCollection.add(personEvent.getPerson());
    }
    
}
