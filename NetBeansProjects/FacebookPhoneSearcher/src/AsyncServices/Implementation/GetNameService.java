package AsyncServices.Implementation;
 
import AsyncServices.GetModelInfoService;
import interfaces.Modelable; 
import javafx.concurrent.*;

public class GetNameService extends GetModelInfoService {  
    
    public GetNameService(Modelable m){
        super(m);
    }
    
    @Override
    protected Task createTask() {
      return new Task(){
            @Override
        protected String call() throws Exception {  
              if(model != null) { 
                return model.getAvatarName();  
            }
            else
                return null; 
        }; 
      };
    } 
}
