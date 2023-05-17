
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
    
    public void Mostrar(char c){

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
        Nodo n = new Nodo();
        
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
    
}
