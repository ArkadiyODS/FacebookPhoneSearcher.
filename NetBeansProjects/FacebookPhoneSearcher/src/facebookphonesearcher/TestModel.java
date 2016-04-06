package facebookphonesearcher;

import interfaces.Modelable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
 
class TestModel implements Modelable {

    public TestModel() {
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
            Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public String getAvatarName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Akakiy Akakiv";
    }

    @Override
    public Image getAvatarImage() { 
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       return new Image("https://scontent-frt3-1.xx.fbcdn.net/hprofile-xtp1/v/t1.0-1/p50x50/11752566_824057744358805_6624847018844291316_n.jpg?oh=6aee705d918a0a37244162559eb8e935&oe=578BEDA6");
    }
    
}
