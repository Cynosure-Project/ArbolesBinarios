package utilidades;

public class Nodo {
    
    private char Dato;
    private int FB;
    private Nodo LigaI, LigaD;
    
    public Nodo () {
        LigaI = null;
        Dato = '\0';
        LigaD = null;
        FB=0;
        
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
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