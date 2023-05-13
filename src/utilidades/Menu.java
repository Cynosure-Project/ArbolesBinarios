
package utilidades;

import logica.Arbol;
import utilidades.Vista;
import javax.swing.JOptionPane;
import utilidades.*;
import logica.*;

public class Menu {
    
    public static void MenuPrincipal(){
        int opcion;
        Arbol a;
        Vista V = new Vista();
        Validar v = new Validar();

        do 
        {
            opcion = v.ValidarInt("""
                               Menu principal
                                  
                                1. Crear
                                2. Insertar
                                3. Recorrer
                                4. Contar
                                0. Salir 
                                    """);

            switch(opcion)
            {
                    case 1:
                        V.VistaCrear();
                        break;
                        
                    case 2:
                        V.VistaInsertar();
                        break;
                        
                    case 3:
                        MenuRecorrer();
                        break;
                        
                    case 4:
                        
                        break;

                    case 0:
                        //System.out.println("Gracias por usar nuestros servicios, vuelva");
                        break;

                    default:
                        System.out.println("Opción no Valida");
                        break;
            }
        }
        while(opcion != 0);
    }
    
    public static void MenuRecorrer(){
        int opcion;
        Arbol a;
        Vista V = new Vista();
        Validar v = new Validar();

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
                        
                        break;
                        
                    case 2:
                        
                        break;
                        
                    case 3:
                        
                        break;

                    case 0:
                        System.out.println("Gracias por usar nuestros servicios, vuelva");
                        break;

                    default:
                        System.out.println("Opción no Valida");
                        break;
            }
        }
        while(opcion != 0);
    }
    
    public static void MenuContar(){
        int opcion;
        Arbol a;
        Vista V = new Vista();
        Validar v = new Validar();

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
                        
                        break;
                        
                    case 2:
                        
                        break;
                        
                    case 3:
                        
                        break;

                    case 0:
                        System.out.println("Gracias por usar nuestros servicios, vuelva");
                        break;

                    default:
                        System.out.println("Opción no Valida");
                        break;
            }
        }
        while(opcion != 0);
    }
    
}
