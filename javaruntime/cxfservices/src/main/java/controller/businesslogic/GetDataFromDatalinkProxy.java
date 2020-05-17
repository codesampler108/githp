package controller.businesslogic;

import java.util.ArrayList;
import java.util.List;

import apachecxf.SoapClient;
import apachecxf.SoapMessage;

public class GetDataFromDatalinkProxy {

	
    public GetDataFromDatalinkProxy() {
		System.out.println("GetDataFromDatalinkProxy in cxfservices");
	}

	public List<String> getData(){
    	System.out.println(this.getClass().getCanonicalName()+" getData executed. cxf module");
        SoapClient client = new SoapClient();
        SoapMessage data1 = client.getData();
        SoapMessage data2 = client.getData();
        String data1Str = data1.getSoapData();
        String data2Str = data2.getSoapData();
        List<String> dataStrings = new ArrayList<>();
        dataStrings.add(data1Str);
        dataStrings.add(data2Str);
        return dataStrings;
    }
}
