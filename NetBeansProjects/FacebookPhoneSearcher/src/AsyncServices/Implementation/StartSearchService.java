package AsyncServices.Implementation;
 
import AsyncServices.GetModelInfoService;
import interfaces.Modelable;
import javafx.concurrent.*;

public class StartSearchService extends GetModelInfoService {  
    
    public StartSearchService(Modelable m){
        super(m);
    }
    
    @Override
    protected Task createTask() {
      
        return new Task(){
            @Override
        protected String call() throws Exception { 
            if(model != null) { 
                model.peopleSearch();
            } 
            return null;
        } 
      };  
    } 
}
