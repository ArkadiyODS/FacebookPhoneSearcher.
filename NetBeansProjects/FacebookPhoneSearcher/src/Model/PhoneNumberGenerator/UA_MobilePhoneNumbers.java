package PhoneNumberGenerator;

import Model.Interfaces.Storagable;
import java.io.IOException;
import java.util.*;

public class UA_MobilePhoneNumbers {

    private  final String UA_COUNTRY_CODE = "+38";
    private  final String[] UA_VODAPHONE = new String[]{ "050", "066", "095", "099" };
    private  final String[] UA_KIEVSTAR = new String[]{ "067", "068", "096", "097", "098"};     
    private  final String[] UA_LIFECELL = new String[]{ "063", "093", "068"};   
    private  final String[] UA_UTEL = new String[]{ "091"};   
    private  final int _maxDigitCode =  9999999;
     
    private Storagable _storage;
    
    public UA_MobilePhoneNumbers(Storagable storage){ 
           _storage = storage;
    } 
           
    private void NumberGenerator(String[] operator) {
        try{
            if(_storage != null) {
            _storage.openConnection();
            for(String item:operator)
                       for(int i = 0; i <= _maxDigitCode ; i++) { 
                          _storage.push(String.format("%s%s%07d\n",UA_COUNTRY_CODE, item, i));
                          // System.out.print(String.format("%s%s%07d\n",UA_COUNTRY_CODE, item, i));
                        }   
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
        _storage.closeConnection();
        }
    } 

    public void GeneratePhoneNumbers() {
          //        NumberGenerator(UA_VODAPHONE);
   //        NumberGenerator(UA_KIEVSTAR);
           NumberGenerator(UA_LIFECELL);
    //       NumberGenerator(UA_UTEL);
    }
    
    
}

      