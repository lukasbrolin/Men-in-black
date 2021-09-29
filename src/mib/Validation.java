/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;
import java.util.HashMap;
import java.util.ArrayList;
import  javax.swing.*;

/*
*   H�ller valideringar som beh�ver uppfyllas f�r att genomf�ra specifika aktioner
*/

/**
 *
 * @author Lukas Brolin, Daniel Antonsson & Jonatan Angerg�rd
 */
public class Validation 
{
    public static boolean isNotEmpty(JTextField textField)
    {
        boolean result = true;
        if(textField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Inmatningsrutan �r tom");
            result = false;
        }
        return result;
    }
        
    public static boolean isNotSelected(JList jlist)
    {
        boolean result = true;
        if(jlist.isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingenting i listan �r markerat!");
            result = false;
        }
        return result;
    }
    
    public static boolean isNotSelectedjTable(JTable jtable)
    {
        boolean result = true;
        if(jtable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingenting i listan �r markerat!");
            result = false;
        }
        return result;        
    }
       
    public static boolean isCorrectDateFormat(JTextField textfield)
    {
        boolean checkFormat;
        if (textfield.getText().matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"))
        {
            checkFormat=true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Fel format p� datum! Anv�nd: YYYY-MM-DD");
            checkFormat=false;
        }
        return checkFormat;
    }
    
    public static boolean isHeltal(JTextField textfield)
    {
        boolean result = true;
        
        try
        {
            String aString = textfield.getText();
            Integer.parseInt(aString);
            textfield.requestFocus();
            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Var god ange ett heltal!");
            result = false;
            
        }
        return result;
    }
    
    public static boolean isNotHelTal(JTextField textfield)
    {
        boolean result = true;
        
       
        String aString = textfield.getText();
        if(aString.matches("^[a-�A-�]*$"))
        {
            textfield.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Var god ange bokst�ver!");
            result = false;
        }
        
        return result;
    }
    
    public static boolean startsWithString(JList jlist, String aString)
    {
        boolean result = true;
        if(!jlist.getSelectedValue().toString().startsWith(aString))
        {       
            result = false;
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "V�nligen markera en utrustning!");
        }
        
        return result;    
    }
    
    public static boolean containsWithString(JList jlist, String aString)
    {
        boolean result = true;
        if(!jlist.getSelectedValue().toString().contains(aString))
        {       
            result = false;
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "V�nligen markera en utrustning!");
        }
        
        return result;    
    }
    
    public static boolean passwordCheck(JTextField textfield)
    {
        boolean result = true;
        String aString = textfield.getText();
        textfield.requestFocus();

        if(aString.length() >6)
        {
        result = false;
        JOptionPane.showMessageDialog(null, "Ditt l�senord f�r inte vara l�ngre �n 6 tecken!");
        }

        return result;
    }
    
    public static boolean isRas(JTextField textfield)
    {
        boolean result = true;
        String aString = textfield.getText().toLowerCase();
        textfield.requestFocus();
        

        if(aString.equals("boglodite") || aString.equals("worm") || aString.equals("squid"))
        {
            result = true;
        }
        else
        {
            result = false;
            JOptionPane.showMessageDialog(null, "Var v�nlig ange en existerande ras!");
        }
        return result;
    }

    public static boolean isPlats(JTextField textfield)
    {
        boolean result = true;
        String aString = textfield.getText().toLowerCase();
        textfield.requestFocus();

        if(aString.equals("�rebro") ||  aString.equals("v�ster�s") || aString.equals("vilhelmina") || aString.equals("bor�s"))
        {
            result = true;
        }

        else
        {
            result = false;
            JOptionPane.showMessageDialog(null, "Var v�nlig ange en existerande plats!");
        }
        return result;
    }
    
    public static boolean isOmrade(JTextField textfield)
    {
        boolean result = true;
        String aString = textfield.getText().toLowerCase();
        textfield.requestFocus();

        if(aString.equals("svealand") || aString.equals("g�taland") || aString.equals("norrland"))
        {
            result = true;
        }

        else
        {
            result = false;
            JOptionPane.showMessageDialog(null, "Var v�nlig ange ett existerande omr�de!");
        }
        return result;
    }

    public static boolean isTelefon(JTextField textfield)
    {
        boolean result;
        if (textfield.getText().matches("^[a-�A-�]$"))
        {
            result=false;
            JOptionPane.showMessageDialog(null, "V�nligen anv�nd bara siffror skiljda med bindestreck i telefonnumret!");
        }

        else if (textfield.getText().matches(".[a-zA-Z].") && textfield.getText().matches(".[0-9].*"))

        {
            result=false;
            JOptionPane.showMessageDialog(null, "V�nligen anv�nd bara siffror skiljda med bindestreck i telefonnumret!");
        }

        else
        {
            result=true;
        }
        return result;
    }
    
    public static boolean isAgent(JTextField textfield)
    {
        boolean result = false;
        try
        {
            String fraga = "SELECT NAMN FROM AGENT";
            ArrayList<HashMap<String, String>> svar = DataBaseConnection.getDB().fetchRows(fraga);
            for(HashMap<String, String> map : svar)
            {
                for(String enStrang : map.keySet())
                {
                    String ettSvar = map.get(enStrang);
                    String ettSvar2 = textfield.getText();
               
                    if(ettSvar.equals(ettSvar2))
                    {
                        result = true;
                        break;
                    }
                }
            }
        }
        
        catch (Exception e)
                {
                    
                }
        if (result == false)
        {
            JOptionPane.showMessageDialog(null, "V�nligen ange en existerande agent!");
        }
        return result;
    }
    
    public static boolean existingID(JTextField textfield, String strang)
    {
        boolean result = false;
        try
        {
            String fraga = "SELECT " + strang + "_ID FROM " + strang;
            ArrayList<HashMap<String, String>> svar = DataBaseConnection.getDB().fetchRows(fraga);
            for(HashMap<String, String> map : svar)
            {
                for(String enStrang : map.keySet())
                {
                    String ettSvar = map.get(enStrang);
                    String ettSvar2 = textfield.getText();
               
                    if(ettSvar.equals(ettSvar2))
                    {
                        result = true;
                        JOptionPane.showMessageDialog(null, "Det angivna " + strang + "-idt finns redan i systemet!");
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            
        }
        return result;
        
       
    }
    
    public static boolean isSame(int enInt)
    {
        boolean resultat = false;
        if(enInt == Integer.parseInt(Inloggad.getIDInloggad()))
        {
            JOptionPane.showMessageDialog(null, "Du kan inte radera dig sj�lv!");
        }
        else
        {
            resultat = true;
        }
        return resultat;
    }
}


