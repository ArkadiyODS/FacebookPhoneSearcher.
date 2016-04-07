package interfaces;

import DataClasses.Person;
import javafx.scene.image.Image;


public interface Presentable {
    void setName(String name);
    void setAvatar(Image ava);
    void addItemToMainCollection(Person item);
    
}
