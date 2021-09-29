/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @ author Jonte
 */
package mib;

import java.io.IOException;
import java.net.URI;

import java.awt.Desktop;
import javax.swing.JOptionPane;
import oru.inf.InfException;

public class Mail {
    public static void main(String[] args) {
        // Get an instance of Desktop. If the platform doesn't support Desktop API an 
        // UnsupportedOperationException will be thrown.
        Desktop desktop = Desktop.getDesktop();
        String namn = Inloggad.getNameInloggad();

        try {
            // Open user-default mail client application.
            desktop.mail();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String fraga = "select namn from agent where agent_id =(select agent_id from omradeschef where omrade =(select plats from alien where namn = '" + namn + "'))";
            String svar = DataBaseConnection.getDB().fetchSingle(fraga);
            String agent = svar.replaceAll("\\W", ""); //Tar bort alla mellanslag och osynliga karaktärer från namnet
            
            // Open user-default mail client with the email message fields information.
            String message = "mailto:" +agent + "@mib.spy?subject=Jag%20är%20kränkt!%3F";
            URI uri = URI.create(message);
            desktop.mail(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InfException ettUndantag){
            JOptionPane.showMessageDialog(null, ettUndantag);
        }
            
    }
}
