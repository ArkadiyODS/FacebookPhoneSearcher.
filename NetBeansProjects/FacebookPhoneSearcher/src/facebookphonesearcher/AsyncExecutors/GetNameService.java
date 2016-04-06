package facebookphonesearcher.AsyncExecutors;
 
import interfaces.Modelable;
import javafx.concurrent.*;

public class GetNameService extends Service { 
    private Modelable model;
    
    public GetNameService(Modelable m){
        model = m;
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
        } 
      };
    } 
    @Override
    public void succeeded(){
        super.succeeded();
        this.reset();
    }
    
    
}
