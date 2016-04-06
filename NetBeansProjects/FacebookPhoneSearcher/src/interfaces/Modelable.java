package interfaces;

import facebookphonesearcher.Person;
import java.util.List;
import javafx.scene.image.Image;

public interface Modelable {
    List<Person> getPhoneCollection();

    public String getAvatarName();

    public Image getAvatarImage();
}
