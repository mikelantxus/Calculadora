package principal;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora{
    public static void main(String[] args) {    	
        int resultado = 0;
        String operacion = "";
        int[] operandos = new int [2];
        
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
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
        }catch(ArithmeticException a) {
        	System.out.println ("Operación aritmética no válida" + a.getMessage());
         }
        }   while (menu.repetir());
    }
}