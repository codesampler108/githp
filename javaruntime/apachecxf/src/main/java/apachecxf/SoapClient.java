package apachecxf;

import java.util.Date;

public class SoapClient {

	public SoapMessage getData() {
		return new SoapMessage("soap msg created at :"+new Date());
	}
}
