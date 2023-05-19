
package logica;
import utilidades.Nodo;

/**
 *
 * @author Mariana M
 */
public class AVL {
    
    public Nodo Raiz;

    public AVL() {
        Raiz = null;
    }

    public void CrearAvl(char[] datos) {
        for (char dato : datos) {
            Raiz = Insertar(Raiz, dato);
        }
    }

    public Nodo Insertar(Nodo R, char dato) {
    if (R == null) {
        return new Nodo(dato);
    }

    if (dato < R.getDato()) {
        R.setLigaI(Insertar(R.getLigaI(), dato));
    } else if (dato > R.getDato()) {
        R.setLigaD(Insertar(R.getLigaD(), dato));
    } else {
        
        return R;
    }
    R.setFB(Math.max(FB(R.getLigaI()), FB(R.getLigaD())) + 1);

    int fb = FB(R);

    if (fb > 1 && dato < R.getLigaI().getDato()) {
        return RotacionDerecha(R);
    }

    if (fb < -1 && dato > R.getLigaD().getDato()) {
        return RotacionIzquierda(R);
    }

    if (fb > 1 && dato > R.getLigaI().getDato()) {
        return RotacionDobleDerecha(R);
    }

    if (fb < -1 && dato < R.getLigaD().getDato()) {
        return RotacionDobleIzquierda(R);
    }

    return R;
}
    public int Altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzquierda = Altura(nodo.getLigaI());
        int alturaDerecha = Altura(nodo.getLigaD());
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int FB(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzquierda = Altura(nodo.getLigaI());
        int alturaDerecha = Altura(nodo.getLigaD());
        return alturaIzquierda - alturaDerecha;
    }

    public Nodo RotacionIzquierda(Nodo P) {
        Nodo Q = P.getLigaI();
        P.setLigaI(Q.getLigaD());
        Q.setLigaD(P);
        P.setFB(Math.max(FB(P.getLigaI()), FB(P.getLigaD())) + 1);
        Q.setFB(Math.max(FB(Q.getLigaI()), FB(Q.getLigaD())) + 1);
        return Q;
    }

public Nodo RotacionDerecha(Nodo P) {
        Nodo Q = P.getLigaD();
        P.setLigaD(Q.getLigaI());
        Q.setLigaI(P);
        P.setFB(Math.max(FB(P.getLigaI()), FB(P.getLigaD())) + 1);
        Q.setFB(Math.max(FB(Q.getLigaI()), FB(Q.getLigaD())) + 1);
        return Q;
    }
public Nodo RotacionDobleIzquierda(Nodo P) {
        P.setLigaI(RotacionDerecha(P.getLigaI()));
        return RotacionIzquierda(P);
    }

    public Nodo RotacionDobleDerecha(Nodo P) {
        P.setLigaD(RotacionIzquierda(P.getLigaD()));
        return RotacionDerecha(P);
    }

    
}

