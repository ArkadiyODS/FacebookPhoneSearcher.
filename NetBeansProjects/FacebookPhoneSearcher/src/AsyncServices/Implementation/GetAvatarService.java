package AsyncServices.Implementation;
 
import AsyncServices.GetModelInfoService;
import interfaces.Modelable;
import javafx.concurrent.*;
import javafx.scene.image.Image;

public class GetAvatarService extends GetModelInfoService {  

    public GetAvatarService(Modelable m) {
        super(m);
    }
    
    @Override
    protected Task<Image> createTask() {
      return new Task<Image>(){
            @Override
        protected Image call() throws Exception { 
            if(model != null) { 
                return model.getAvatarImage(); 
            }
            else
                return null;
        } 
      };
    }  
}
