package com.froyo.springbootsoapexample.endpoint;

import com.froyo.spring_boot_soap_example.GetUserRequest;
import com.froyo.spring_boot_soap_example.GetUserResponse;
import com.froyo.springbootsoapexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@AllArgsConstructor
@Endpoint
public class UserEndpoint {

    private final UserService userService;


    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
