package facebookphonesearcher;

import interfaces.Modelable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
class TestModel implements Modelable {

    public TestModel() {
    }

    @Override
    public List<Person> getPhoneCollection() {
       return new LinkedList();
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
    
}
