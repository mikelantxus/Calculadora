package operaciones;
public class Operaciones{
	
	/*
	 * @author mikelantxus
	 * @param valor1
	 * @param valor2
	 * @return Devuelve la suma entre el valor1 y valor2
	 * 
	 */
	
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    /*
     * @author mikelantxus
	 * @param valor1
	 * @param valor2
	 * @return Devuelve la resta entre el valor1 y valor2
	 * 
	 */
    
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    /*
     * @author mikelantxus
	 * @param valor1
	 * @param valor2
	 * @return Devuelve la multiplicacion entre el valor1 y valor2
	 * 
	 */
    
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /*
     * @author mikelantxus
	 * @param valor1
	 * @param valor2
	 * @return Devuelve la division entre el valor1 y valor2
	 * 
	 */
    
    public int dividir (int valor1, int valor2 ) {
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    /*
     * @author mikelantxus
	 * @param valor1
	 * @param valor2
	 * @return Devuelve el resto entre el valor1 y valor2
	 * 
	 */
    
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}