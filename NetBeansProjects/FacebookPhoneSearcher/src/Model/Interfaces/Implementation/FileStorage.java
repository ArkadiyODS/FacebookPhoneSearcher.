package Model.Interfaces.Implementation;
 
import Model.Interfaces.Storagable;
import java.io.*;
import java.sql.*;

public class FileStorage  implements Storagable   {
    private FileWriter _fw;
    private FileReader _fr;
    private String _storageFilePath = "storage.txt"; 
    private String _iteratorFilePath = "itr.bin";

    public FileStorage(){ 
    }
    
    public FileStorage(String fileName){
        _storageFilePath = fileName;
    }
    
    @Override
    public boolean isStorageEmtpty() {
        try{
            File f = new File(_storageFilePath);
        if (f.getTotalSpace() != 0)  
            return false;
        } catch (SecurityException e) {
            e.printStackTrace(); 
        }
        return true;
    } 

    @Override
    public void push(String data){
         try {
           if(_fw != null){
              _fw.write(data);
              _fw.flush();       
            }
       }catch (IOException e){
           e.printStackTrace(); 
       }    
    }
 
    @Override
    public boolean openConnection(){
       try {
           if(_fw == null)
            _fw = new FileWriter(_storageFilePath, true);
           if(_fr == null)
            _fr = new FileReader(_storageFilePath);
           return true;
       }catch (IOException e){
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public void closeConnection(){
       try{
           if(_fw != null) _fw.close(); 
       } catch (IOException e) {
           e.printStackTrace();
       }
       try{
           if(_fr != null) _fr.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Override
    @SuppressWarnings("all") 
    public String popup(){
        DataOutputStream tempWriter = null;
        DataInputStream tempReader = null;
        String result = null;
        long size = 0;
        try {
            tempWriter = new DataOutputStream (new FileOutputStream(_iteratorFilePath));
            tempReader = new DataInputStream ( new FileInputStream(_iteratorFilePath));
            
            if(tempReader != null)
                size = tempReader.readLong();
            
            _fr.skip(size);
           // _fr.read(chars)
                   
        }catch (IOException e){
           e.printStackTrace(); 
       } finally {
            try {
                if(tempWriter != null)
                        tempWriter.close(); 
            }catch (Exception x) {}
             try {
                if(tempReader != null)
                        tempReader.close();
            }catch (Exception x) {} 
             
         return result;
        }
       
    }
    
}
