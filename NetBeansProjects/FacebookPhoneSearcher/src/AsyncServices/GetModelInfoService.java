package AsyncServices;

import interfaces.Modelable;
import javafx.concurrent.Service;
 
public abstract class GetModelInfoService  extends Service { 
    protected Modelable model;
    
    public GetModelInfoService(Modelable m){
        model = m;
    }
     
              
    @Override
    public void succeeded(){
        super.succeeded();
        this.reset();
    }
    
    @Override
    public void cancelled(){
        super.cancelled(); 
        this.reset();
    }
    
    
    
}
