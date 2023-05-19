
package utilidades;

import logica.Arbol;
import utilidades.Vista;
import javax.swing.JOptionPane;
import utilidades.*;
import logica.*;

public class Menu {
    
    public static Vista V = new Vista();
    public static Validar v = new Validar();
   
    public static void MenuPrincipal(){
        int opcion;
        V.VistaCrear();
        
        do 
        {
            opcion = v.ValidarInt("""
                               Menu principal
                                  
                                1. Mostrar Árbol
                                2. Insertar
                                3. Recorrer
                                4. Contar
                                5. Mostrar   
                                0. Salir 
                                    """);

            switch(opcion)
            {
                    case 1:
                        V.VistaMostrar();
                        break;
                        
                    case 2:
                        V.VistaInsertar();
                        break;
                        
                    case 3:
                        MenuRecorrer();
                        break;
                        
                    case 4:
                        MenuContar();
                        break;
                    case 5:
                        MenuMostrar();
                        break;
                        
                    case 0:
                        JOptionPane.showMessageDialog(null, "Gracias por probar nuestro proyecto","Salir",3);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, ingresa otra opción","Opción invalida",0);
                        break;
            }
        }
        while(opcion != 0);
    }
    
    public static void MenuRecorrer(){
        int opcion;
        
        do 
        {
            opcion = v.ValidarInt("""
                               Menu recorrer
                                  
                                1. Inorden
                                2. Preorden
                                3. Posorden
                                0. Salir 
                                    """);

            switch(opcion)
            {
                    case 1:
                        V.VistaInorden();
                        break;
                        
                    case 2:
                        V.VistaPreorden();
                        break;
                        
                    case 3:
                        V.VistaPosorden();
                        break;

                    case 0:
    
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, ingresa otra opción","Opción invalida",0);
                        break;
            }
        }
        while(opcion != 0);
    }
    
    public static void MenuContar(){
        int opcion;
        
        do 
        {
            opcion = v.ValidarInt("""
                                            Menu contar
                                  
                                1. Contar hojas
                                2. Contar padres
                                3. Contar registros con un solo hijo
                                0. Salir 
                                    """);

            switch(opcion)
            {
                    case 1:
                        V.VistaContarHojas();
                        break;
                        
                    case 2:
                        V.VistaContarPadres();
                        break;
                        
                    case 3:
                        V.VistaRegistroscon1Hijo();
                        break;
                        
                    case 0:
    
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, ingresa otra opción","Opción invalida",0);
                        break;
            }
        }
        while(opcion != 0);
    }
    
    public static void MenuMostrar(){
        int opcion;
        
        do 
        {
            opcion = v.ValidarInt("""
                               Menu Mostrar
                                  
                        1. Mostrar Altura de nodo
                        2. Mostrar nivel de nodo
                        3. Mostrar hermano de un nodo
                        4. Mostrar Ancestros de un nodo
                        5. Mostrar Primos hermanos de un nodo
                        6. Mostrar arbol graficamente
                        0. Salir 
                                    """);

            switch(opcion)
            {
                    case 1:
                        V.VistaAltura();
                        break;
                        
                    case 2:
                        V.VistaNivel();
                        break;
                        
                    case 3:
                        V.VistaHermanos();
                        break;
                        
                    case 4:
                        V.VistaAncestros();
                        break;
                        
                    case 5: 
                        V.VistaPrimosHermanos();
                        
                    case 6:
                        V.VistaGrafica();
                        break;

                    case 0:
    
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta, ingresa otra opción","Opción invalida",0);
                        break;
            }
        }
        while(opcion != 0);
    }
    
}
