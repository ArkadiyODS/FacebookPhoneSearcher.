package DataClasses;
 
import DataClasses.Person;
import java.util.EventObject;

public class PersonFoundEvent extends EventObject {
    private final Person _person;
    
    public PersonFoundEvent(Object sourse, Person person) {
        super(sourse);
        _person = person;
    }
    
    public synchronized Person getPerson(){
        return _person;
    }
    
}
