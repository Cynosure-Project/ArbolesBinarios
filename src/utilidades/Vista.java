
package utilidades;
import javax.swing.JOptionPane;
import logica.Arbol;
import logica.Validar;
import utilidades.*;

public class Vista extends Arbol{
    
    public void VistaCrear(){
        Validar v = new Validar();
        String s=v.ValidarString("Ingrese letras a agregar en arbol binario (Mayúsculas, sin espacios)");
        super.Crear(s);
        StringBuilder sb=new StringBuilder();
        
        super.MostrarArbol(this.getRaiz(),sb);
        JOptionPane.showMessageDialog(null, sb.toString());
        
                
        
    }
    
    
}
