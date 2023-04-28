
package Utilidades;

import javax.swing.JOptionPane;

public class Validar {
    
    public String ValidarString(String t){
        String s;
        
        s = "";
        
        while (s.equals(""))
        {
            s = JOptionPane.showInputDialog(t);
            
            if (!s.matches("^[A-Za-z ]+$")) 
            {
                s = "";
                
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return s;
    }
    
    
    public int Validarint(String t){
        int i;
        boolean B;
        
        i = 0;
        B = false;
        
        while (!B)
        {
            try
            {
                i = Integer.parseInt(JOptionPane.showInputDialog(null,t, "Opciones del Menú",3));
                B = true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validación", 0);
            }
        }
        
        return i;
    }
     
    
}
