package DataClasses;

public class Person {
    private String _name;
    private String _phone;
    
    public Person(){}
    
    public Person(String name, String phone ){
    _name = name;
    _phone = phone;
    }
    
    public String getName() {
        return _name;
    }
 
    public String getPhone() {
        return _phone;
    } 
    
}
