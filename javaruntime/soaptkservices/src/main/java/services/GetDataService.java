package services;


import javax.jws.WebMethod;
import javax.jws.WebService;

import controller.entrypoint.GetDataController;
import controller.entrypoint.ServiceController;
import controller.model.BusinessObjectRequest;
import controller.model.BusinessObjectResponse;

// http://localhost:8080/services//getdataservice?wsdl

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

    private ResponseVO mapResponse(BusinessObjectResponse bo) {
        ResponseVO responseVO=new ResponseVO();
        responseVO.setOutput(bo.getServiceMessage());
        responseVO.setMessages(bo.getMsgs());
        return responseVO;
    }

    private BusinessObjectRequest mapRequest(RequestVO requestVO) {
        BusinessObjectRequest request=new BusinessObjectRequest();
        request.setData(requestVO.getFirstName()+" "+requestVO.getLastName());
        return request;
    }
}
