package com.example;


import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.model.JSONInput;


import java.util.UUID;

public class App {

    public String handleRequest(CustomerDetails customerDetails) {

        Service service = new Service();
        UUID uuid = service.generateKeyForDB(customerDetails);
        DBOperations dbOperations = new DBOperations();
        String response = dbOperations.saveData(uuid,customerDetails);
        System.out.println("updated");

        return response;
    }


}
