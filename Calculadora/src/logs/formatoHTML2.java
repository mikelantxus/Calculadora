package logs;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class formatoHTML2 extends Formatter {

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		String [] array= record.getMessage().split("\\|");
		return "<P> \n"+array[3].split(":")[1]+"\n </P> \n";
	}
	
	 public String getHead(Handler h) {
	        return "<HTML>\n <BODY> \n";
	    }

	 public String getTail(Handler h) {
	        return "</BODY>\n </HTML> \n";
	    }

}
