package com.Vip.Sp.Customer.UserRequest.Controllers;

import com.Vip.Sp.Customer.UserRequest.Entity.RequestModel;
import com.Vip.Sp.Customer.UserRequest.Services.RequestService;
import com.Vip.Sp.Image.Entity.ImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping(value = {"/addRequest"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public RequestModel addRequest(@RequestPart("request") RequestModel request,
                                   @RequestPart("image")MultipartFile[] files) throws Exception{

        try {
          Set<ImageModel>images= uploadImage(files);

            request.setImages(images);

            requestService.addRequest(request);
        }catch (Exception e){
            return null;

        }
        return request;
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels=new HashSet<>();
        for (MultipartFile file:multipartFiles){
            ImageModel imageModel=new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
}