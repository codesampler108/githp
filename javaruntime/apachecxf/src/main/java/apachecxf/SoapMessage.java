package apachecxf;

public class SoapMessage {
	
	private String soapData;

	public SoapMessage(String string) {
		this.soapData=string;
	}

	public String getSoapData() {
		return soapData;
	}

	public void setSoapData(String soapData) {
		this.soapData = soapData;
	}
	
}
