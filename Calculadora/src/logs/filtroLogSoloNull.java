package logs;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class filtroLogSoloNull implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		boolean crearLog=false;
		
		if(record.getMessage()!=null && record.getMessage() != null) {
			String [] array= record.getMessage().split(" ");
			String resultado=array[array.length -1];
			
			if ("0".equals(resultado)) {
				crearLog=true;
			}
			
			
		} 
		return crearLog;
	}

}
