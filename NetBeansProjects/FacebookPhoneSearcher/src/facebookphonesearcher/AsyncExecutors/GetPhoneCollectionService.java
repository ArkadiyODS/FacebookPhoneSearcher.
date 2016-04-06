package facebookphonesearcher.AsyncExecutors;
 
import facebookphonesearcher.Person;
import interfaces.Modelable;
import java.util.List; 
import javafx.concurrent.*;

public class GetPhoneCollectionService extends Service { 
    private Modelable model;
    
    public GetPhoneCollectionService(Modelable m){
        model = m;
    }
    
    @Override
    protected Task<List<Person>> createTask() {
      return new Task<List<Person>>(){
            @Override
        protected List<Person> call() throws Exception { 
            if(model != null) { 
                return model.getPhoneCollection();
            }
            else
                return null;
        } 
      };
    } 
    @Override
    public void succeeded(){
        super.succeeded();
        this.reset();
    }
    
    
}
