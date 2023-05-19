
package utilidades;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import logica.Arbol;
import logica.Validar;
import utilidades.*;
import java.awt.Dimension;

public class Vista {
    public Arbol a = new Arbol();
    
    public void VistaCrear(){
        Validar v = new Validar();
        String s = v.ValidarString("Ingrese letras a agregar en arbol binario (Mayúsculas, sin espacios, no ingresar Ñ)");
        char [] c = s.toCharArray() ;
        
        a.Crear(c,0,a.getRaiz());
    }
    
    public void VistaMostrar()
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ArbolBinarioGrafico(a);
                frame.setSize(400, 400);
                frame.setVisible(true);
            }
        });
    }
    
    public void VistaInsertar()
    {
        Validar v = new Validar();
        char c = v.ValidarChar("Ingrese letra a ingresar");
        
        a.Insertar(a.getRaiz(), c);
    }
    
    public void VistaInorden()
    {
        StringBuilder sb = new StringBuilder();
        
        a.RecorrerInorden(a.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public void VistaPosorden()
    {
        StringBuilder sb = new StringBuilder();
        
        a.RecorrerPosorden(a.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public void VistaPreorden()
    {
        StringBuilder sb = new StringBuilder();
        
        a.RecorrerPreorden(a.getRaiz(), sb);
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public void VistaContarHojas()
    {
        JOptionPane.showMessageDialog(null, "El árbol tiene " + a.ContarHojas(a.getRaiz()) + " hojas");
    }
    
    public void VistaContarPadres()
    {
        JOptionPane.showMessageDialog(null, "El árbol tiene " + a.ContarPadres(a.getRaiz()) + " padres");
    }
    
    public void VistaRegistroscon1Hijo()
    {
         JOptionPane.showMessageDialog(null, "El árbol tiene " + a.ContarRegistrosCon1Hijo(a.getRaiz()) + " registros con un sólo hijo");
    }
    
    public void VistaHermanos()
    {
        Validar v = new Validar();
        char c = v.ValidarChar("¿De qué dato deseas hallar su hermano? ");
        
        if(a.BuscarDato(a.getRaiz(), c))
        {
            a.Hermano(a.getRaiz(), c, null);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        } 
    }
    
    public void VistaPrimosHermanos() {
        Validar v = new Validar();
        char c = v.ValidarChar("¿De qué dato deseas hallar sus primos hermanos?: ");
        boolean[] sw = new boolean[1];
        sw[0] = true;
        Nodo n = a.PrimosHermanos(a.getRaiz(), null, null, c, sw);
        
        if(n == null)
            JOptionPane.showMessageDialog(null,"El nodo no posee primos hermanos");
        else if(n.getLigaI()==null && n.getLigaD()==null)
            JOptionPane.showMessageDialog(null,"El nodo no posee primos hermanos");
        else if(n.getLigaI()==null)
            JOptionPane.showMessageDialog(null,"El primo hermano de " + c + " es: " + n.getLigaD().getDato());
        else if(n.getLigaD()==null)
            JOptionPane.showMessageDialog(null,"El primo hermano de " + c + " es: " + n.getLigaI().getDato());
        else
            JOptionPane.showMessageDialog(null,"Los primos hermanos de " + c + " son: " + n.getLigaI().getDato() + " y " + n.getLigaD().getDato());
    }
    
    public void VistaAncestros() {
        String s;
        Validar v = new Validar();
        StringBuilder sb = new StringBuilder();
        char c = v.ValidarChar("¿De qué dato deseas hallar sus ancestros?: ");
        
        a.Ancestros(a.getRaiz(), c, null, true, sb);
        
        s = sb.toString();
        
        if(a.BuscarDato(a.getRaiz(), c))
        {
            JOptionPane.showMessageDialog(null,"Los ancestros de "+ c +" son: " +s);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }
    }
    
    public void VistaAltura()
    {
        Validar v = new Validar();
        char c = v.ValidarChar("Ingresa el dato del que quieres saber su altura");
        
        if(a.BuscarDato(a.getRaiz(), c))
        {
            JOptionPane.showMessageDialog(null,"La altura de " + c + " es: " + a.Altura(a.Buscar(a.getRaiz(), c)));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
        }
    }
    
    public void VistaNivel()
    {   
       Validar v = new Validar();
       char c = v.ValidarChar("Ingresa el dato del que quieres saber el nivel");
       
       if(a.BuscarDato(a.getRaiz(), c))
       {
           JOptionPane.showMessageDialog(null,"El nivel de " + c + " es: " + a.Nivel(a.getRaiz(), c));
       }
       else
       {
           JOptionPane.showMessageDialog(null,"El dato no está en el arbol","Dato no encontrado",0);
       }
    }
    
}
