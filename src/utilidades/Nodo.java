
package utilidades;

public class Nodo {
    
    private char Dato;
    private Nodo LigaI, LigaD;
    
    public Nodo () {
        LigaI = null;
        Dato = '\0';
        LigaD = null;
    }
    
    public Nodo (char d) {
        LigaI = null;
        Dato = d;
        LigaD = null;
    }
    
    public char getDato() {
        return Dato;
    }
    
    public void setDato(char d) {
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
