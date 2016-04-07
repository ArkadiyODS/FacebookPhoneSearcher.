package QA;

import DataClasses.Person;
import DataClasses.PersonFoundEvent;
import interfaces.Modelable;
import interfaces.PersonFindListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
 
public class TestModel implements Modelable {

    public TestModel() {
    }
    
    private List<PersonFindListener> _listeners = new LinkedList<PersonFindListener>();

    public synchronized void addListener(PersonFindListener listener){
        _listeners.add(listener);
    }
    
    public synchronized void removeListener(PersonFindListener listener){
        _listeners.remove(listener);
    }
    
    public synchronized void peopleSearch(){
        for (int i = 0; i < 20; i++) { 
             for (int j = 0; j < 10000; j++) {
                int[] a = new int[10000];
            }
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) { 
                System.out.println("Task is canceled"); 
                return;
            }
            for(PersonFindListener l: _listeners)
                l.personFound(new PersonFoundEvent(this, new Person("Some guy", 
                        String.valueOf(i))));
        }
    }
    
    
    @Override
    public List<Person> getPhoneCollection() {
        
            List<Person> list = new LinkedList();
        try {

            Thread.sleep(1000);
            list.add(new Person("Va va", "0503335555"));
            list.add(new Person("Fa va", "0503335555"));
            list.add(new Person("Da va", "0503335555"));
            list.add(new Person("Ga va", "0503335555"));            
        } catch (InterruptedException ex) {
          //  Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Collection" + ex.getMessage());
        throw new CancellationException();
        }
        catch (CancellationException ex) {
            Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
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
