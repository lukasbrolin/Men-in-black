/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

/*
* H�ller information om den inloggade individen f�r att kunna anv�nda information vid �ndringar och h�mtning av information
*/

/**
 *
 * @author Laptop
 */
public class Inloggad {
    
    private static String typeInloggad;
    private static String IDinloggad;
    private static String nameInloggad;
    
    public Inloggad(String typeInloggad, String IDinloggad, String nameInloggad)
    {
        this.typeInloggad = typeInloggad;
        this.IDinloggad = IDinloggad;
        this.nameInloggad = nameInloggad;
    }
    
    public static String getTypeInloggad()
    {
        return typeInloggad;
    }
    
    public static String getIDInloggad()
    {
        return IDinloggad;
    }
    
    public static String getNameInloggad()
    {
        return nameInloggad;
    }
    
}
