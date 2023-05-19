
package utilidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logica.Arbol;

public class ArbolBinarioGrafico extends JFrame {
    
    private JPanel ventana;
    private Arbol a;
    
    public ArbolBinarioGrafico(Arbol a){
        this.a = a;
    }
    
    /*public int drawTree(Graphics g, Nodo x, int x0, int x1, int y){

        int m = (x0 + x1) / 2;
        g.setColor(Color.WHITE);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = x.getDato() + "";
        g.drawString(t, m+20, y+30);
        
        if (x.getLigaI() != null) 
        {
            int x2 = drawTree(g, x.getLigaI(),x0,m,y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (x.getLigaD() != null) 
        {
            int x2 = drawTree(g, x.getLigaD(),m,x1,y+50);
            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth(); // Ancho del componente
        drawTree(g, a.getRaiz(), 0, width, 100);
    }*/
    
    public int drawTree(Graphics g, Nodo x, int x0, int x1, int y) {
        int nodeWidth = 50; // Ancho del nodo
        int m = (x0 + x1 - nodeWidth) / 2; // Coordenada x del nodo actual
        int nodeCenterX = m + nodeWidth / 2; // Coordenada x del centro del nodo
        int nodeTopY = y; // Coordenada y del tope del nodo
        int nodeBottomY = y + 40; // Coordenada y del fondo del nodo

        g.setColor(Color.WHITE);
        g.fillOval(m, y, nodeWidth, 40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String t = x.getDato() + "";
        int stringWidth = g.getFontMetrics().stringWidth(t);
        g.drawString(t, nodeCenterX - stringWidth / 2, nodeTopY + 25);

        if (x.getLigaI() != null) {
            int childX = drawTree(g, x.getLigaI(), x0, m, y + 50);
            int childCenterX = childX + nodeWidth / 2; // Coordenada x del centro del hijo
            int childY = y + 90; // Coordenada y del hijo
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        if (x.getLigaD() != null) {
            int childX = drawTree(g, x.getLigaD(), m + nodeWidth, x1, y + 50);
            int childCenterX = childX + nodeWidth / 2; // Coordenada x del centro del hijo
            int childY = y + 90; // Coordenada y del hijo
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth(); // Ancho del componente
        drawTree(g, a.getRaiz(), 0, width, 100);
    }
    
    /*public int countNodes(Nodo x) {
        if (x == null) {
            return 0;
        } else {
            return countNodes(x.getLigaI()) + 1 + countNodes(x.getLigaD());
        }
    }

    public int drawTree(Graphics g, Nodo x, int x0, int x1, int y) {
        int nodeWidth = 50; // Ancho del nodo
        int horizontalMargin = 20; // Margen horizontal adicional para evitar el corte de nodos
        int treeWidth = countNodes(x) * (nodeWidth + horizontalMargin); // Ancho total del árbol
        int m = (x0 + x1 - treeWidth) / 2; // Coordenada x del nodo actual
        int nodeCenterX = m + nodeWidth / 2; // Coordenada x del centro del nodo
        int nodeTopY = y; // Coordenada y del tope del nodo
        int nodeBottomY = y + 40; // Coordenada y del fondo del nodo

        g.setColor(Color.WHITE);
        g.fillOval(m, y, nodeWidth, 40);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String t = x.getDato() + "";
        int stringWidth = g.getFontMetrics().stringWidth(t);
        g.drawString(t, nodeCenterX - stringWidth / 2, nodeTopY + 25);

        if (x.getLigaI() != null) {
            int childX = drawTree(g, x.getLigaI(), x0, m - horizontalMargin, y + 50);
            int childCenterX = childX + nodeWidth / 2; // Coordenada x del centro del hijo
            int childY = y + 90; // Coordenada y del hijo
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        if (x.getLigaD() != null) {
            int childX = drawTree(g, x.getLigaD(), m + nodeWidth + horizontalMargin, x1, y + 50);
            int childCenterX = childX + nodeWidth / 2; // Coordenada x del centro del hijo
            int childY = y + 90; // Coordenada y del hijo
            g.drawLine(nodeCenterX, nodeBottomY, childCenterX, childY);
        }

        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getWidth(); // Ancho del componente
        drawTree(g, a.getRaiz(), 0, width, 100);
    }*/
    
}
