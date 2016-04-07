
package Model.Interfaces.Implementation;
 
import Model.Interfaces.Storagable;
import java.sql.*; 
import java.io.IOException;

public class DbStorage implements Storagable {

    String connectionUrl =  "jdbc:sqlserver://localhost;integratedSecurity=true;";
    
    public DbStorage(){
     try{ 
            
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   Connection con = DriverManager.getConnection(connectionUrl);
        String SQL = "use TestBD; SELECT TOP 10 * FROM [posts];";
			Statement stmt = con.createStatement();
			ResultSet  rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " 
						+ rs.getString(3));
			}
        }
        catch (Exception e) {e.printStackTrace();}
      
    }
    
    public DbStorage(String connectionString){ 
        connectionUrl = connectionString;
    } 
    
    
    @Override
    public void push(String data){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String popup(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean openConnection(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isStorageEmtpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
