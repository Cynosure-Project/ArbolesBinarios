
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
            else if(x.getDato() == p.getDato())
            {
                b = true;
            }
        }
        
        if(b)
            Crear(v, i+1, Raiz);
    }
 
    public void contar(Nodo R, int c)
    {
        if(R!=null)
        {
            contar(R.getLigaI(), c);
            contar(R.getLigaD(),c);
            if(R.getLigaI()==null && R.getLigaD()==null)
            {
             contar(R,c++);

            }
        }
        
    }
     public void Insertar(Nodo R, char dato) {
        if (R == null)
        {
            Nodo x = new Nodo(dato);
        } else
        {
            if (dato < R.getDato())
            {
                if(R.getLigaI()==null)
                {
                    R.setLigaI(R);
                }else
                {
                      if(R.getLigaD()==null)
                    {
                        R.setLigaD(R);
                    }else
                      {
                          Insertar(R.getLigaI(), dato);
                      }
                    
                }      

            }else
            {
                if(dato>R.getDato())
                {
                    Insertar(R.getLigaD(), dato);
                }else
                {
                  
                   JOptionPane.showMessageDialog(null, "El dato ya existe en el árbol","Dato duplicado",2); 
                }
            }
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
    
    public int NivelNodo(Nodo R, char dato, int nivel)
    {
        if (R!=null)
        {
            if (R.getDato() < dato) {
                nivel = NivelNodo(R.getLigaD(), dato, nivel++);
            } else {
                nivel = NivelNodo(R.getLigaI(), dato, nivel++);
            }
             if (R == Raiz && R.getDato() == dato) {
                return 1;
            } else if (R != Raiz && R.getDato() == dato) {
                return nivel;
            }
        }
        return nivel;
    }
        
    public void MostrarArbol(Nodo R, StringBuilder s)
    {   
        if(R!=null)
        {   
            
             MostrarArbol(R.getLigaI(), s);
            s.append(R.getDato()).append(" "); 
           
               
            
            MostrarArbol(R.getLigaD(), s);
        }
    }
    
    public void Ancestros(Nodo R, char dato, Nodo P, boolean b) {
        if (R != null && b) {
            if (R == Raiz && R.getDato() == dato) {
                JOptionPane.showMessageDialog(null, "No tiene ancestros");
                b = false;
            } else if (R != Raiz && R.getDato() == dato) {
                b = false;
            }

            if (b) {
                JOptionPane.showMessageDialog(null, "Su ancestro"+ R.getDato());
                if (R.getDato() < dato) {
                    Ancestros(R.getLigaD(), dato, R, b);
                } else {
                    Ancestros(R.getLigaI(), dato, R, b);
                }
            }

        }
    
    }
     public void Hermano(Nodo R, char dato, Nodo P) {
        if (R != null) 
        {
           Hermano(R.getLigaI(), dato, R);
                if (R.getDato() == dato && R == Raiz) 
                {
                    JOptionPane.showMessageDialog(null, "No tiene hermanos");
                } else if (R.getDato() == dato && R != Raiz) {
                    
                    if (P.getLigaI().getDato() != R.getDato()) 
                    {
                       JOptionPane.showMessageDialog(null,"Hermano izquierdo:" + P.getLigaI().getDato());
                    } else 
                    {
                        JOptionPane.showMessageDialog(null,"Hermano derecho:" + P.getLigaD().getDato());
                    }
                }

                Hermano(R.getLigaD(), dato, R);

        }
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

}
