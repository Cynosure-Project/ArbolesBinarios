
package utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logica.AVL;
import logica.Arbol;

public class ArbolBinarioGrafico extends JFrame {
    
    private JPanel ventana;
    private Arbol a;
    private AVL AVL;
    
    public ArbolBinarioGrafico(Arbol a){
        this.a = a;
    }

    ArbolBinarioGrafico(AVL AVL) {
        this.AVL=AVL; 
    }
    
    public int drawTree(Graphics g, Nodo x, int x0, int x1, int y) {
        int nodeWidth = 50; // Ancho del nodo
        int m = (x0 + x1 - nodeWidth) / 2; 
        int nodeCenterX = m + nodeWidth / 2; 
        int nodeTopY = y; 
        int nodeBottomY = y + 40; 

        g.setColor(Color.WHITE);
        g.fillOval(m, y, nodeWidth, 40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String t = x.getDato() + "";
        int stringWidth = g.getFontMetrics().stringWidth(t);
        g.drawString(t, nodeCenterX - stringWidth / 2, nodeTopY + 25);

        if (x.getLigaI() != null) {
            int childX = drawTree(g, x.getLigaI(), x0, m, y + 50);
            int childCenterX = childX + nodeWidth / 2; 
            int childY = y + 90; 
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        if (x.getLigaD() != null) {
            int childX = drawTree(g, x.getLigaD(), m + nodeWidth, x1, y + 50);
            int childCenterX = childX + nodeWidth / 2; 
            int childY = y + 90; 
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth(); 
        drawTree(g, a.getRaiz(), 0, width, 100);
    }


    
}
    

