/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author Mariana M
 */
public class AVL {
    private NodoAVL raiz;

    public AVL() {
        raiz = null;
    }
    
     public int FB(NodoAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.getFB();
        }
    }
     
    public NodoAVL RotacionIzquierda(NodoAVL P) {
        NodoAVL Q = P.getLI();
        P.setLI(Q.getLD());
        Q.setLD(P);
        P.setFB(Math.max(FB(P.getLI()), FB(P.getLD())) + 1);
        Q.setFB(Math.max(FB(Q.getLI()), FB(Q.getLD())) + 1);
        return Q;
    }

    public NodoAVL RotacionDerecha(NodoAVL P) {
        NodoAVL Q = P.getLD();
        P.setLD(Q.getLI());
        Q.setLD(P);
        P.setFB(Math.max(FB(P.getLI()), FB(P.getLD())) + 1);
        Q.setFB(Math.max(FB(Q.getLI()), FB(Q.getLD())) + 1);
        return Q;
    }

    public NodoAVL RotacionDobleIzquierda(NodoAVL P) {
        NodoAVL R;
        P.setLI(RotacionDerecha(P.getLI()));
        R = RotacionIzquierda(P);
        return R;
    }

    public NodoAVL RotacionDobleDerecha(NodoAVL P) {
        NodoAVL R;
        P.setLD(RotacionDerecha(P.getLD()));
        R = RotacionDerecha(P);
        return R;
    }

}
