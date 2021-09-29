package mib;
import javax.swing.JOptionPane;
import oru.inf.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
* Skapar en connection till databasen som sedan används frekvent genom programmet
*/

/**
 *
 * @author Lukas
 */
public class DataBaseConnection {
    
    private static InfDB idb;
    
    public DataBaseConnection()
    {
        try
        {
            String aktuellMap = System.getProperty("user.dir");
            
            String sokvag = aktuellMap + ("\\db\\MIBDB.FDB");
            System.out.println(sokvag);
            this.idb = new InfDB(sokvag);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static InfDB getDB()
    {
        return idb;
    }  
}
