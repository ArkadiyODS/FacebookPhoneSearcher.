package facebookphonesearcher.AsyncExecutors;
 
import interfaces.Modelable;
import javafx.concurrent.*;
import javafx.scene.image.Image;

public class GetAvatarService extends Service { 
    private Modelable model;
    
    public GetAvatarService(Modelable m){
        model = m;
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
    @Override
    public void succeeded(){
        super.succeeded();
        this.reset();
    }
    
    
}
