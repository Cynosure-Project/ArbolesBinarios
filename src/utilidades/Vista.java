
package utilidades;
import javax.swing.JOptionPane;
import logica.Arbol;
import logica.Validar;
import utilidades.*;

public class Vista extends Arbol{
    
    public String VistaCrear(){
        Validar v = new Validar();
        
        return v.ValidarString("Ingrese letras a agregar en arbol binario (Mayusculas y sin espacios)");
    }
    
    public void VistaRecorrerPosorden(Arbol a){
    }
}
