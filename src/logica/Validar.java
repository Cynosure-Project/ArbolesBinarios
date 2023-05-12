
package logica;

import javax.swing.JOptionPane;
public class Validar {
    
    public String ValidarString(String t){
        String s = "";
        
        while (s.equals(""))
        {
            s = JOptionPane.showInputDialog(t);

            if (!s.matches("^[A-Z]+")) 
            if (!s.matches("^[A-Z]+$")) 
            {
                s = "";

                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
            }
        }
        
        return s;
    }

    
    public char ValidarChar(String t){
        String s = "";
        boolean b = false;

        while (s.equals(""))
        while (!b)
        {
            s = JOptionPane.showInputDialog(t);

            if (!s.matches("^[A-Z]")) 
            if(s.matches("[A-Z]{1}"))
            {
                s = "";

                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validar", 0);
                return s.charAt(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un dato válido", "Validación", 0);
            }
        }

        
        return '\0';
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