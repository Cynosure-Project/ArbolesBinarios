
package utilidades;

/**
 *
 * @author Mariana M
 */
public class NodoAVL {

    int FB;
    char dato;
    NodoAVL LI;
    NodoAVL LD;

    public NodoAVL(char dato) {
        this.dato = dato;
        this.FB = 0;
        this.LI = null;
        this.LD = null;
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoAVL getLI() {
        return LI;
    }

    public void setLI(NodoAVL LI) {
        this.LI = LI;
    }

    public NodoAVL getLD() {
        return LD;
    }

    public void setLD(NodoAVL LD) {
        this.LD = LD;
    }

    

}
