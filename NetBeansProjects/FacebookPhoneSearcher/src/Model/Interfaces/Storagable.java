package Model.Interfaces;

import java.io.IOException;

public interface Storagable {
    boolean isStorageEmtpty();
    void push(String data);
    String popup();
    boolean openConnection(); 
    void closeConnection();
}
