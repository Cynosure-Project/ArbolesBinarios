package logica;

import javax.swing.JOptionPane;
import utilidades.Nodo;

/**
 *
 * @author Mariana M
 */
public class AVL extends Arbol {

    public Nodo Raiz;

    public AVL() {
        Raiz = null;
    }

    public void CrearAvl(char[] datos) {
        for (char dato : datos)
        {
            Nodo R=new Nodo(dato);
            
            Raiz = InsertarAVL(R, Raiz);
        }
    }
public Nodo InsertarAVL (Nodo x,Nodo P) {
    if(P==null)
    {
        P=x;
    }
       Nodo nuevoPadre = P;
        if (x.getDato() < P.getDato()) {
            if (P.getLigaI()== null) {
                P.setLigaD(x);
            } else {
                P.setLigaI(InsertarAVL(x, P.getLigaI()));
                if (FB(P.getLigaI()) - FB(P.getLigaD()) == 2) {
                    if (x.getDato() < P.getLigaI().getDato()) {
                        nuevoPadre = RotacionIzquierda(P);
                    } else {
                        nuevoPadre = RotacionDobleIzquierda(P);
                    }
                }
            }

        } else if (x.getDato() > P.getDato()) {
            if (P.getLigaD()== null) {
                P.setLigaD(x);
            } else {
                P.setLigaD(InsertarAVL(x, P.getLigaD()));
                if (FB(P.getLigaD()) - FB(P.getLigaI()) == 2) {
                    if (x.getDato() < P.getLigaD().getDato()) {
                        nuevoPadre = RotacionDerecha(P);
                    } else {
                        nuevoPadre = RotacionDobleDerecha(P);
                    }
                }
            }
        } else {
           // JOptionPane.showMessageDialog(null,"Nodo duplicado");
        }

      
        if (P.getLigaI()== null && P.getLigaD()!= null) {
            P.setFB(P.getLigaD().getFB() + 1);
        } else if (P.getLigaD()== null && P.getLigaI()!= null) {
            P.setFB(P.getLigaI().getFB() + 1);
        } else {
            P.setFB(Math.max(FB(P.getLigaI()), FB(P.getLigaD())) + 1);
        }
        return nuevoPadre;
    }

    
//public Nodo InsertarAVL(Nodo R, char dato) {
//    if (R == null) {
//        return new Nodo(dato);
//    }
//
//    if (dato < R.getDato()) {
//        R.setLigaI(InsertarAVL(R.getLigaI(), dato));
//    } else if (dato > R.getDato()) {
//        R.setLigaD(InsertarAVL(R.getLigaD(), dato));
//    } else {
//        return R;
//    }
//
//    R.setFB(Math.max(FB(R.getLigaI()), FB(R.getLigaD())) + 1);
//    int fb = FB(R);
//
//    if (fb > 1 && dato < R.getLigaI().getDato()) {
//        return RotacionDerecha(R);
//    }
//
//    if (fb < -1 && dato > R.getLigaD().getDato()) {
//        return RotacionIzquierda(R);
//    }
//
//    if (fb > 1 && R.getLigaI() != null && dato > R.getLigaI().getDato()) {
//        return RotacionDobleDerecha(R);
//    }
//
//    if (fb < -1 && R.getLigaD() != null && dato < R.getLigaD().getDato()) {
//        return RotacionDobleIzquierda(R);
//    }
//
//    return R;
//}


    public int Altura(Nodo R) {
        if (R == null)
        {
            return -1;
        }
        int alturaIzquierda = Altura(R.getLigaI());
        int alturaDerecha = Altura(R.getLigaD());
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int FB(Nodo nodo) {
        if (nodo == null)
        {
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

