package AsyncServices.Implementation;
 
import AsyncServices.GetModelInfoService;
import DataClasses.Person;
import interfaces.Modelable;
import java.util.List; 
import javafx.concurrent.*;

public class GetPhoneCollectionService extends GetModelInfoService {  
    
    public GetPhoneCollectionService(Modelable m){
        super(m);
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
}
