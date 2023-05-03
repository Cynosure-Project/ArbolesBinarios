
package logica;

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
    
    public int ValidarInt(String t){
        int i;
        boolean b;
        
        i = 0;
        b = false;
        
        while (!b)
        {
            try
            {
                i = Integer.parseInt(JOptionPane.showInputDialog(null,t, "Opciones del Menú",3));
                b = true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validación", 0);
            }
        }
        
        return i;
    }
     
    
}
