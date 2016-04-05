package facebookphonesearcher.AsyncExecutors;
  
import interfaces.Modelable;
import javafx.concurrent.*;

public class GetAvatarNameTask extends Task {

    private Modelable model;
    
    public GetAvatarNameTask(Modelable m){
        model = m;
    }
 
    @Override
    protected String call() throws Exception { 
        if(model != null) { 
            return model.getAvatarName(); 
        }
        else
            return null;
    } 
}
