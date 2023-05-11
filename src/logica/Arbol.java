
package logica;

import arbolesbinarios.*;
import javax.swing.JOptionPane;
import utilidades.Nodo;

public class Arbol {
    
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
    
    public Arbol Crear(String s){
        char[] v;
        Arbol a = new Arbol();
        int i;
        Nodo x, p = new Nodo();
        
        v = s.toCharArray();
        
        for(i=0; i<v.length; i++)
        {
            x = new Nodo();
            x.setDato(v[i]);
            
            if(i == 0)
            {
                Raiz = x;
            }
            else
            {
                if(x.getDato() < p.getDato())
                {
                    p.setLigaI(x);
                }
                else
                {
                    if(x.getDato() > p.getDato())
                    {
                        p.setLigaD(x);
                    }
                }
            } 
        }
        
        return a;
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
    
    public void RecorrerInorden(Nodo r){
        if(r != null)
        {
            RecorrerInorden(r.getLigaI());
            Mostrar(r.getDato());
            RecorrerInorden(r.getLigaD());
        }
    }
    
    public void RecorrerPreorden(Nodo r){
        if(r != null)
        {
            Mostrar(r.getDato());
            RecorrerInorden(r.getLigaI());
            RecorrerInorden(r.getLigaD());
        }
    }
    
    public void RecorrerPosorden(Nodo r){
        if(r != null)
        {
            RecorrerInorden(r.getLigaI());
            RecorrerInorden(r.getLigaD());
            Mostrar(r.getDato());
        }
    }
    
    public void Mostrar(Nodo r, int space, int height){
        // Caso base
        if (r == null) {
            return;
        }
 
        // aumentar la distancia entre niveles
        space += height;
 
        // imprime el hijo derecho primero
        Mostrar(r.getLigaD(), space, height);
        System.out.println();
 
        // imprime el nodo actual después de rellenar con espacios
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }
 
        System.out.print(r.getDato());
 
        // imprime el hijo izquierdo
        System.out.println();
        Mostrar(r.getLigaI(), space, height);
    }
    
    public void Mostrar(char c){
        JOptionPane.showMessageDialog(null, " |" + c + "| ");
    }
    
    public int ContarHojas(Nodo r, int c){
        if(r != null)
        {
            RecorrerInorden(r.getLigaI());
            RecorrerInorden(r.getLigaD());
            
            if(r.getLigaI()==null && r.getLigaD()==null)
                c++;
        }
        
        return c; //que pasa con el return aca?
    }
    
    public int ContarPadres(Nodo r, int c){
        if(r != null)
        {
            RecorrerInorden(r.getLigaI());
            RecorrerInorden(r.getLigaD());
            
            if(r.getLigaI()!=null && r.getLigaD()!=null)
                c++;
        }
        
        return c;
    }
    
    public int ContarRegistrosCon1Hijo(Nodo r, int c){//nombre epico?
        if(r != null)
        {
            RecorrerInorden(r.getLigaI());
            RecorrerInorden(r.getLigaD());
            
            if((r.getLigaI()==null && r.getLigaD()!=null) || (r.getLigaI()!=null && r.getLigaD()==null))
                c++;
        }
        
        return c;
    }
    
    
    
}
