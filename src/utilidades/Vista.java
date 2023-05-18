
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
     
         JOptionPane.showMessageDialog(null, "El árbol tiene "+super.ContarHojas(this.getRaiz())+" hojas");
     }
     public void VistaContarPadres()
     {
         JOptionPane.showMessageDialog(null, "El árbol tiene "+super.ContarPadres(this.getRaiz())+" padres");
     }
     public void VistaRegistroscon1Hijo()
     {
          JOptionPane.showMessageDialog(null, "El árbol tiene "+super.ContarRegistrosCon1Hijo(this.getRaiz())+" registros con un sólo hijo");
     }
    public void VistaHermanos()
    {
        Validar v= new Validar();
        char c=v.ValidarChar("¿De qué dato deseas hallar su hermano? ");
        if(super.BuscarDato(this.getRaiz(), c))
        {
            super.Hermano(this.getRaiz(), c, null);
        }else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }
        
    }
    public void VistaPrimosHermanos()
    {
        
    }
    public void VistaAncestros() {
        String s;
        Validar v= new Validar();
        StringBuilder sb = new StringBuilder();
        char c=v.ValidarChar("¿De qué dato deseas hallar sus ancestros? ");
        Ancestros(this.getRaiz(), c, null, true, sb);
        s = sb.toString();
        if(super.BuscarDato(this.getRaiz(), c))
        {
            JOptionPane.showMessageDialog(null,"Los ancestros de "+ c +" son: " +s);
        }else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }
        

    }
     public void VistaAltura()
    {
        Validar v= new Validar();
        char c=v.ValidarChar("Ingresa el dato del que quieres saber su altura");
        if(super.BuscarDato(this.getRaiz(), c))
        {
            JOptionPane.showMessageDialog(null,"La altura de "+ c +" es: " +super.Altura(super.Buscar(this.getRaiz(), c)));
        }else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }
    }
     public void VistaNivel()
     {   
        Validar v= new Validar();
        char c=v.ValidarChar("Ingresa el dato del que quieres saber el nivel");
        if(super.BuscarDato(this.getRaiz(), c))
        {
            JOptionPane.showMessageDialog(null,"El nivel de "+ c +" es: " +super.Nivel(this.getRaiz(), c));
        }else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }

         
     }
    
}
