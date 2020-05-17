package controller.entrypoint;

import java.util.Date;
import java.util.List;

import controller.businesslogic.GetDataFromDatalink;
import controller.model.BusinessObjectRequest;
import controller.model.BusinessObjectResponse;

public class GetDataController implements ServiceController {

    private GetDataFromDatalink datalink=new GetDataFromDatalink();

    @Override
    public BusinessObjectResponse processRequest(BusinessObjectRequest request){
        List<String> businessData = datalink.getData();
        String msg="Execution Time:"+new Date();
        
        BusinessObjectResponse response=new BusinessObjectResponse();
        
        response.setServiceMessage("reqeust processed for :"+request.getData()+" "+ msg);
        response.setMsgs(businessData);
        return response;
    }
}
