package services;


import javax.jws.WebMethod;
import javax.jws.WebService;

import controller.entrypoint.GetDataController;
import controller.entrypoint.ServiceController;
import controller.model.BusinessObjectRequest;
import controller.model.BusinessObjectResponse;

// http://localhost:8080/cxfservices/getdataservice?wsdl

@WebService
public class GetDataService {

    private ServiceController service=new GetDataController();

    @WebMethod(action="getData")
    public ResponseVO getData(RequestVO requestVO) {
        //mapper
        BusinessObjectRequest request = mapRequest(requestVO);
        // controller
        BusinessObjectResponse businessObjectResponse = service.processRequest(request);
        // mapper
        ResponseVO responseVO = mapResponse(businessObjectResponse);

        return responseVO;
    }

    private BusinessObjectRequest mapRequest(RequestVO requestVO) {
    	BusinessObjectRequest request=new BusinessObjectRequest();
    	request.setData(requestVO.getFirstName()+" "+requestVO.getLastName());
    	return request;
    }
    
    private ResponseVO mapResponse(BusinessObjectResponse response) {
        ResponseVO responseVO=new ResponseVO();
        responseVO.setOutput(response.getServiceMessage());
        responseVO.setMessages(response.getMsgs());
        return responseVO;
    }

}
