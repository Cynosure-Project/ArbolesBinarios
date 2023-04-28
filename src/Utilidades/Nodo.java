
package Utilidades;

public class Nodo {
    
    private int Dato;
    private Nodo LigaI, LigaD;
    
    public Nodo () {
        LigaI = null;
        Dato = 0;
        LigaD = null;
    }
    
    public Nodo (int d) {
        LigaI = null;
        Dato = d;
        LigaD = null;
    }
    
    public int getDato() {
        return Dato;
    }
    
    public void setDato(int d) {
        Dato = d;
    }
    
    public Nodo getLigaI() {
        return LigaI;
    }
    
    public void setLigaI(Nodo L) {
        LigaI = L;
    }
    
    public Nodo getLigaD() {
        return LigaD;
    }
    
    public void setLigaD(Nodo L) {
        LigaD = L;
    } 
}
