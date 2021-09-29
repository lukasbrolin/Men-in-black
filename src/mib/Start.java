/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
*   Main-class som startar systemet genom att skapa en DataBaseConnection och en Inloggnings-ruta
*/

/**
 *
 * @author Lukas
 */
package mib;


public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           DataBaseConnection db = new DataBaseConnection();
           new Inloggning(DataBaseConnection.getDB()).setVisible(true);
    }
}
