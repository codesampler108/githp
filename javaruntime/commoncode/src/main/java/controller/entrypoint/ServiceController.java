package controller.entrypoint;

import controller.model.BusinessObjectRequest;
import controller.model.BusinessObjectResponse;

public interface ServiceController {
   BusinessObjectResponse processRequest(BusinessObjectRequest request);
}
