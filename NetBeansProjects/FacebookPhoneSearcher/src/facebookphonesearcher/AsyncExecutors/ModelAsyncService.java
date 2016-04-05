package facebookphonesearcher.AsyncExecutors;
 
import interfaces.Modelable;
import javafx.concurrent.*;

public class ModelAsyncService extends Service { 
    private Modelable model;
    
    public ModelAsyncService(Modelable m){
        model = m;
    }
    
    @Override
    protected Task createTask() {
        return new GetAvatarNameTask(model);
    } 
    @Override
    public void succeeded(){
        super.succeeded();
        this.reset();
    }
    
    
}
