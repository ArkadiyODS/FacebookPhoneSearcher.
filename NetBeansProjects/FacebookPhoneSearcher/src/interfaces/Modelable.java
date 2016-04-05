package interfaces;

import facebookphonesearcher.Person;
import java.util.List;

public interface Modelable {
    List<Person> getPhoneCollection();

    public String getAvatarName();
}
