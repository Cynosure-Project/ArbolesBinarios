
package logica;

import arbolesbinarios.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import utilidades.Nodo;

public class Arbol extends JPanel {
    
    private Nodo Raiz;
    
    public Arbol(){
        Raiz = null;
    }

    public Nodo getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.Raiz = Raiz;
    }
    
    public void Crear(char[] v, int i, Nodo p){
        Nodo x;
        boolean b;
        
        b = false;
        
        if(i < v.length)
        {
            x = new Nodo(v[i]);
            
            if(i == 0)
            {
                Raiz = x;
                Crear(v, i+1, Raiz);
            }
            else if(x.getDato() < p.getDato())
            {
                if(p.getLigaI() != null)
                    Crear(v, i, p.getLigaI());
                else
                {
                    p.setLigaI(x);
                    
                    b = true;
                }
            }
            else if(x.getDato() > p.getDato())
            {
                if(p.getLigaD() != null)
                    Crear(v, i, p.getLigaD());
                else
                {
                    p.setLigaD(x);
                    
                    b = true;
                }
            }
        }
        
        if(b)
            Crear(v, i+1, Raiz);
    }
 
    public void Insertar(char l){
        Nodo p, x;
        boolean b;
        
        x = new Nodo(l);
        b = true;
        
        if(Raiz == null)
            Raiz = x;
        else
        {
            p = Raiz;
            
            while(b)
            {
                if(l<p.getDato() && p.getLigaI()!=null)
                    p = p.getLigaI();
                else
                {
                    if(l < p.getDato())
                        b = false;
                }
                
                if(l>p.getDato() && p.getLigaD()!=null)
                    p = p.getLigaD();
                else
                {
                    if(l > p.getDato())
                        b = false;
                }
                
                if(l == p.getDato())
                    b = false;
            }
            
            if(l < p.getDato())
                p.setLigaI(x);
            else
                if(l > p.getDato())
                    p.setLigaD(x);
                else
                    System.out.println("Ya existe el dato en el árbol");
        }
    }
    
    public void RecorrerInorden(Nodo r, StringBuilder s){
        if(r != null)
        {
            RecorrerInorden(r.getLigaI(), s);
            s.append(r.getDato()).append(" ");
            RecorrerInorden(r.getLigaD(), s);
        }
    }
    
    public void RecorrerPreorden(Nodo r, StringBuilder s){
        if(r != null)
        {
            s.append(r.getDato()).append(" ");
            RecorrerPreorden(r.getLigaI(), s);
            RecorrerPreorden(r.getLigaD(), s);
        }
    }
    
    public void RecorrerPosorden(Nodo r, StringBuilder s){
        if(r != null)
        {
            RecorrerPosorden(r.getLigaI(), s);
            RecorrerPosorden(r.getLigaD(), s);
            s.append(r.getDato()).append(" ");
        }
    }
    
    public int ContarHojas(Nodo r){
        int c;
        
        c = 0;
        
        if(r != null)
        {
            c += ContarHojas(r.getLigaI());
            c += ContarHojas(r.getLigaD());
            
            if(r.getLigaI()==null && r.getLigaD()==null)
                c++;
        } 
        
        return c;
    }
    
    public int ContarPadres(Nodo r){
        int c;
        
        c = 0;
        
        if(r != null)
        {
            c += ContarPadres(r.getLigaI());
            c += ContarPadres(r.getLigaD());
            
            if(r.getLigaI()!=null && r.getLigaD()!=null)
                c++;
        }
        
        return c;
    }
    
    public int ContarRegistrosCon1Hijo(Nodo r){
        int c;
        
        c = 0;
        
        if(r != null)
        {
            c += ContarRegistrosCon1Hijo(r.getLigaI());
            c += ContarRegistrosCon1Hijo(r.getLigaD());
            
            if((r.getLigaI()==null && r.getLigaD()!=null) || (r.getLigaI()!=null && r.getLigaD()==null))
                c++;
        }
        
        return c;
    }

    public Nodo Buscar(/*inicia en raiz*/Nodo r, char d){
        Nodo n = null;
        
        if(r.getDato() < d)
            n = Buscar(r.getLigaD(), d);
        else
            if(r.getDato() > d)
                n = Buscar(r.getLigaI(), d);
            else
                if(r.getDato() == d)
                    return r;
        
        return n;
    }    
    
    public int Nivel(Nodo r, char d){
        int c;
        
        c = 0;
        
        if(r.getDato() < d)
            c = Nivel(r.getLigaD(), d)+1;
        else
            if(r.getDato() > d)
                c = Nivel(r.getLigaI(), d)+1;
            else
                if(r.getDato() == d)
                    return 1;
        
        return c;
    }
    
    public int Altura(Nodo r){
        int ci;
        int cd;
        
        ci = -1;
        cd = -1;
        
        if(r != null)
        {
            ci = Altura(r.getLigaI())+1;
            cd = Altura(r.getLigaD())+1;
        }
       
        return Math.max(ci, cd);
    }
    
    public Nodo PrimosHermanos(Nodo r, Nodo p, Nodo a, char d){
        if(d < r.getDato())
        {
            if(r.getLigaI() == null)
                a = null;
            else
                PrimosHermanos(r.getLigaI(), r, p, d);
        }
        else if(d > r.getDato())
        {
            if(r.getLigaD() == null)
                a = null;
            else
                PrimosHermanos(r.getLigaD(), r, p, d);
        }
        
        if(a != null)
        {
            if(p == a.getLigaD())
                a = a.getLigaI();
            else
                a = a.getLigaD();
        }
        
        return a;
    }
    
    public boolean BuscarDato(Nodo R, char dato) {
        if (R == null)
            return false;

        if (R.getDato() == dato)
            return true;

        if (dato < R.getDato())
            return BuscarDato(R.getLigaI(), dato);
        else
            return BuscarDato(R.getLigaD(), dato);
    }
    
    public void Mostrar(Nodo R, StringBuilder s)
    {   
        if(R!=null)
        {   
            Mostrar(R.getLigaI(), s);
            s.append(R.getDato()).append(" "); 
            Mostrar(R.getLigaD(), s);
        }
    }
    
    public void Hermano(Nodo R, char dato, Nodo P) {
        if (R != null) 
        {
            Hermano(R.getLigaI(), dato, R);

            if (R.getDato() == dato && R == Raiz) 
                JOptionPane.showMessageDialog(null, "No tiene hermanos");
            else if (R.getDato() == dato && R != Raiz) 
            {
                if (P != null) 
                {
                    if (P.getLigaD() != null && P.getLigaD() != R) 
                        JOptionPane.showMessageDialog(null, "Hermano derecho: " + P.getLigaD().getDato());
                    else if (P.getLigaI() != null && P.getLigaI() != R) 
                        JOptionPane.showMessageDialog(null, "Hermano izquierdo: " + P.getLigaI().getDato());
                    else 
                        JOptionPane.showMessageDialog(null, "No tiene hermanos");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "No tiene hermanos");
                }
            }

            Hermano(R.getLigaD(), dato, R);
        }
    }
    
    public void Ancestros(Nodo R, char dato, Nodo P, boolean b, StringBuilder sb) {
        if (R != null && b) 
        {
            if (R == Raiz && R.getDato() == dato) 
            {
                sb.append("No tiene ancestros");
                b = false;
            } 
            else if (R != Raiz && R.getDato() == dato) 
                b = false;

            if (b) 
            {
                sb.append(R.getDato()).append(" ");
                
                if (R.getDato() < dato) 
                    Ancestros(R.getLigaD(), dato, R, b, sb);
                else 
                    Ancestros(R.getLigaI(), dato, R, b, sb);
            }
        }
    }
    
    
    
}
