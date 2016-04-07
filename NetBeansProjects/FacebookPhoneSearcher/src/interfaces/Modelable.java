package interfaces;

import DataClasses.Person;
import java.util.List;
import javafx.scene.image.Image;

public interface Modelable {
    List<Person> getPhoneCollection(); 
    public String getAvatarName();
    public Image getAvatarImage();
    public void Close();    
    public void addListener(PersonFindListener listener);
    public void removeListener(PersonFindListener listener); 
    public void peopleSearch();
}
