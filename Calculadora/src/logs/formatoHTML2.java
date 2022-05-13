package logs;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class formatoHTML2 extends Formatter {

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		String [] array= record.getMessage().split("\\|");
		return "<tr>\r\n"
				+ "				<td>"+array[0].split(":")[1]+"</td>\r\n"
				+ "				<td>"+array[1].split(":")[2]+"</td>\r\n"
				+ "				<td>"+array[2].split(":")[3]+"</td>\r\n"
				+ "				<td>"+array[3].split(":")[4]+"</td>\r\n"
				+ "			</tr>";
	}
	
	 public String getHead(Handler h) {
	        return "<html>\r\n"
	        		+ "	<head>\r\n"
	        		+ "		<link rel=\"stylesheet\" href=\"style.css\">\r\n"
	        		+ "	</head>\r\n"
	        		+ "	<body>\r\n"
	        		+ "		<table>\r\n"
	        		+ "			<tr>\r\n"
	        		+ "				<th>Operación</th>\r\n"
	        		+ "				<th>Operando 1</th>				\r\n"
	        		+ "				<th>Operando 2</th>\r\n"
	        		+ "				<th>Resultado</th>\r\n"
	        		+ "			</tr>\r\n";
	    }

	 public String getTail(Handler h) {
	        return "</table>\r\n"
	        		+ "	</body>\r\n"
	        		+ "</html>";
	    }

}
