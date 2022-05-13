package principal;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import logs.filtroLogSoloNull;
import logs.formatoHTML2;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
	private static final LogManager logManager = LogManager.getLogManager();
	 private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	 static{
			try {
				logManager.readConfiguration(new FileInputStream("./logs/configLog.properties"));
			} catch (IOException exception) {
				LOGGER.log(Level.SEVERE, "Error al cargar la configuración",exception);
			}
		}
	
    public static void main(String[] args) {
    	configurarLog();
    	
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
       
        /*
        Handler FileHandler=null;
        Handler consoleHandler =null;
        
               
        
        
        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(FileHandler);
        
        consoleHandler.setLevel(Level.WARNING);
        FileHandler.setLevel(Level.FINE);
        LOGGER.setLevel(Level.FINE);
        */
        
        
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
        	 LOGGER.log(Level.WARNING, "Operación arimetica no valida");
         }
        }   while (menu.repetir());       
    }

    
	private static void configurarLog() {

		//LOGGER.setUseParentHandlers(false);
        
        Handler FileHandler=null;
        //Handler consoleHandler =new ConsoleHandler();
        
        /*try {
        FileHandler  = new FileHandler("./logs/logOperaciones.html");
        
        }catch(IOException exception) {
            LOGGER.log(Level.SEVERE, "Ocurrió un error en fileHandler");
         }
        
        FileHandler.setFormatter(new formatoHTML());*/
        
        try {
            FileHandler  = new FileHandler("./logs/resultadosNulos.html");
            
            }catch(IOException exception) {
                LOGGER.log(Level.SEVERE, "Nivel de log cambiado a WARNING");
             }
            
            FileHandler.setFormatter(new formatoHTML2());
        
        /*LOGGER.addHandler(FileHandler);
        
        consoleHandler.setLevel(Level.WARNING);
        FileHandler.setLevel(Level.FINE);
        FileHandler.setFilter(new filtroLogSoloMultiplicar());
        LOGGER.setLevel(Level.FINE);*/
        
        LOGGER.addHandler(FileHandler);
        
        FileHandler.setLevel(Level.FINE);
        FileHandler.setFilter(new filtroLogSoloNull());
        //LOGGER.setLevel(Level.FINE);
        
		
	}
	
}