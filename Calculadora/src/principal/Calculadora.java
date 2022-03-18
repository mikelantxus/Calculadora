package principal;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import logs.LogConsolaMasFichero;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	 private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	
    public static void main(String[] args) {
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
       
        Handler FileHandler=null;
        Handler consoleHandler =null;
        
        try {
        consoleHandler = new ConsoleHandler();
        FileHandler  = new FileHandler("./logs/operaciones.log");
        
        }catch(IOException exception) {
            LOGGER.log(Level.SEVERE, "Nivel de log cambiado a WARNING");
         }
        
        
        
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(FileHandler);
        
        consoleHandler.setLevel(Level.WARNING);
        FileHandler.setLevel(Level.FINE);
        LOGGER.setLevel(Level.FINE);
        
        
        
        do{
        	
        	 /*
             * @author mikelantxus
        	 * @param operandos
        	 * @param operacion
        	 * @return Pide numeros y despues te sale las distintas operaciones
        	 * 
        	 */
        	
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            
            /*
             * @author mikelantxus
        	 * @return Aqui el programa te devuelve el resultado de la operacion dependendiendo de la elección del usuario
        	 * 
        	 */
           
           try {
            if (operacion.equalsIgnoreCase("+")){
                resultado = operaciones.sumar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("-")){
                resultado = operaciones.restar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("*")){
                resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("/")){
                resultado = operaciones.dividir(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else if (operacion.equalsIgnoreCase("%")){
                resultado = operaciones.resto(operandos[0], operandos[1]);
                System.out.println ("Resultado: " + resultado);
            } else {
            	
            	 /*
                 * @author mikelantxus
            	 * @return Cuando el usuario introduce una operacion distinta saldra este mensaje
            	 * 
            	 */
           
            	System.out.println ("Operación no válida");
            }
            LOGGER.log(Level.FINE, "Operacion: " + operacion + " operando 1 " + operandos[0] + "operando 2 " + operandos[1] + "resultado: " + resultado);
        }catch(ArithmeticException a) {
        	 LOGGER.log(Level.WARNING, "Division entre cero");
         }
        }   while (menu.repetir());
    }
}