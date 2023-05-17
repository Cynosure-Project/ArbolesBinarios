
package utilidades;
import javax.swing.JOptionPane;
import logica.Arbol;
import logica.Validar;
import utilidades.*;

public class Vista extends Arbol{
    
    public void VistaCrear(){
        Validar v = new Validar();
        String s=v.ValidarString("Ingrese letras a agregar en arbol binario (Mayúsculas, sin espacios, no ingresar Ñ)");
        char [] c=s.toCharArray() ;
        super.Crear(c,0,this.getRaiz());
        
        
                
        
    }
    public void VistaMostrar()
    {
        StringBuilder sb=new StringBuilder();
        
        super.MostrarArbol(this.getRaiz(),sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    public void VistaInsertar()
    {
        Validar v= new Validar();
        char c=v.ValidarChar("Ingrese letra a ingresar");
        super.Insertar(this.getRaiz(), c);
    }
    public void VistaInorden()
    {
        StringBuilder sb=new StringBuilder();
        
        super.RecorrerInorden(this.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
     public void VistaPosorden()
    {
        StringBuilder sb=new StringBuilder();
        
        super.RecorrerPosorden(this.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
     public void VistaPreorden()
    {
        StringBuilder sb=new StringBuilder();
        
        super.RecorrerPreorden(this.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
     public void VistaContarHojas()
     {
      int c=0;
         super.contar(this.getRaiz(), c);
         JOptionPane.showMessageDialog(null, c);
     }
    public void VistaHermanos()
    {
        
    }
    public void VistaPrimosHermanos()
    {
        
    }
    public void VistaAncestros()
    {
        
    }
     public void VistaAltura()
    {
        
    }
     public void VistaNivel()
     {   
        Validar v= new Validar();
        char c=v.ValidarChar("Ingresa el dato del que quieres saber el nivel");
        

         JOptionPane.showMessageDialog(null,"El nivel de "+ c +" es: " +super.Nivel(this.getRaiz(), c));
     }
    
}
