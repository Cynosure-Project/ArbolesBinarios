
package logica;

import javax.swing.JOptionPane;

public class Validar {
    
    public String ValidarString(String t){
        String s = "";
        
        while (s.equals(""))
        {
            s = JOptionPane.showInputDialog(t);
            
            if (!s.matches("[A-Z]")) 
            {
                s = "";
                
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return s;
    }
    
    public int ValidarInt(String t){
        int i = 0;
        boolean b = false;
        
        while (!b)
        {
            try
            {
                i = Integer.parseInt(JOptionPane.showInputDialog(null,t, "Ingreso",3));
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
