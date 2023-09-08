package com.Vip.Sp.Provider.Services;

import com.Vip.Sp.Customer.UserRequest.DAOs.RequestJpa;
import com.Vip.Sp.Customer.UserRequest.Entity.RequestModel;
import com.Vip.Sp.Image.Entity.ImageModel;
import com.Vip.Sp.Provider.Models.RequestAccept;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class RequestAcceptService {


    @Autowired
    private RequestJpa requestJpa;
    public void updateAcceptsInOrder(Long orderId, RequestAccept newAccepts) throws IOException {
        RequestModel requestData = requestJpa.findById(orderId).orElse(null);

        if (requestData !=null) {
            Set<RequestAccept> acceptDetails = uploadData(newAccepts);
            requestData.setAcceptDetails(acceptDetails);


            requestJpa.save(requestData);
        } else {
            throw new EntityNotFoundException("Order with ID " + orderId + " not found");
        }
    }

    public Set<RequestAccept> uploadData(RequestAccept acceptData) throws IOException {
        Set<RequestAccept> acceptModel=new HashSet<>();
     RequestAccept requestAccept =new RequestAccept(
             acceptData.getCustomerId(),
             acceptData.getProviderId(),
             acceptData.getStatus(),
             acceptData.getAcceptDate(),
             acceptData.getServiceStartDate(),
             acceptData.getServiceEndDate(),
             acceptData.getCustomerConfirmation(),
             acceptData.getPaidStatus()
     );
     acceptModel.add(requestAccept);
        return acceptModel;
    }

    public void updateCustomerApproval(Long requestId , String approvalStatus) throws IOException {

        RequestModel requestData = requestJpa.findById(requestId).orElse(null);
        if (requestData !=null) {
            requestData.updateAcceptDetailsStatus(approvalStatus);
            requestJpa.save(requestData);
        } else {
            throw new EntityNotFoundException("Order with ID  not found");
        }

    }


}
