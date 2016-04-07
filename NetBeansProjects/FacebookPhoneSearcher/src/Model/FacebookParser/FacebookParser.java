package Model.FacebookParser;

import DataClasses.Person;
import DataClasses.PersonFoundEvent;
import Model.Interfaces.Implementation.FileStorage;
import PhoneNumberGenerator.*;
import QA.TestModel;
import interfaces.Modelable;
import interfaces.PersonFindListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class FacebookParser implements Modelable {
    private Facebook facebook; 
    private List<PersonFindListener> _listeners = new LinkedList<PersonFindListener>();

    public synchronized void addListener(PersonFindListener listener){
        _listeners.add(listener);
    }
    
    public synchronized void removeListener(PersonFindListener listener){
        _listeners.remove(listener);
    }
    
    public FacebookParser() { 
        facebook = new Facebook(); 
	facebook.login("akakov.akakiy.akakovich@gmail.com", "akakov.akakiy");
               
         /*       try{ 
                DataInputStream dataIn = new DataInputStream(new FileInputStream("storage.txt"));       
      
                    while(dataIn.available()>0){ 
                 String k = dataIn.readLine();
                 
                facebook.search(k);
                    }
      
   }catch (Exception e) {e.printStackTrace();}
                
                */
               
            //    FileStorage dataBase = new FileStorage();
             //   UA_MobilePhoneNumbers mbn =  new UA_MobilePhoneNumbers(dataBase); 
             //   mbn.GeneratePhoneNumbers();
    }

    
    public synchronized void peopleSearch(){
        
        List<String> numbers = new LinkedList();
                numbers.add("+380932419740");
                numbers.add("+380672434324");
                numbers.add("+380674894289");
                numbers.add("+380630635769");
                numbers.add("+380506572154");
                numbers.add("+380503333064");
                numbers.add("+380504207658");
        
        String name;
        
        for (String n: numbers) {  
            name = facebook.search(n);
            
            if(name != null)
                NotifyListeners(name, n);
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) { 
                System.out.println("Task is canceled"); 
                return;
            }
           
        }
    }
    
    public synchronized void NotifyListeners(String personName, String telNumber){
         for(PersonFindListener l: _listeners)
                l.personFound(new PersonFoundEvent(this, new Person(personName, 
                        telNumber)));
    }
    
    
    
    @Override
    public List<Person> getPhoneCollection() {
        
            List<Person> list = new LinkedList();
        try {

            Thread.sleep(500);
            list.add(new Person("Va va", "0503335555"));
            list.add(new Person("Fa va", "0503335555"));
            list.add(new Person("Da va", "0503335555"));
            list.add(new Person("Ga va", "0503335555"));            
        } catch (InterruptedException ex) {
          //  Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Collection" + ex.getMessage()); 
        }
        return list;
    }

    @Override
    public String getAvatarName() { 
            for (int i = 0; i < 1000000; i++) {
                int[] a = new int[10000];
            }
        return "Akakiy Akakiv";
    }

    @Override
    public Image getAvatarImage() { 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
           Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
         }
       return new Image("https://scontent-frt3-1.xx.fbcdn.net/hprofile-xtp1/v/t1.0-1/p50x50/11752566_824057744358805_6624847018844291316_n.jpg?oh=6aee705d918a0a37244162559eb8e935&oe=578BEDA6");
    }

    @Override
    public void Close() {
        System.out.println("Model closed");
    }
}
