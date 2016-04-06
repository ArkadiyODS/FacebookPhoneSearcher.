package facebookphonesearcher.AsyncExecutors;
 
import interfaces.Modelable;
import javafx.concurrent.*;

public class StartSearchService extends Service { 
    private Modelable model;
    
    public StartSearchService(Modelable m){
        model = m;
    }
    
    @Override
    protected Task createTask() {
      return new Task<Void>(){
          
            @Override
        protected Void call() throws Exception { 
            if(model == null) { 
                
            } 
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
