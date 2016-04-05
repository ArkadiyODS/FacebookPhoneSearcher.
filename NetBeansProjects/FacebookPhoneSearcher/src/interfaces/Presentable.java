package interfaces;

import facebookphonesearcher.Person;
import javafx.scene.image.Image;


public interface Presentable {
    void setName(String name);
    void setAvatar(Image ava);
    void addItemToMainCollection(Person item);
    
}
