package com.example;

import java.util.UUID;

public class Service {

    UUID generateKeyForDB(CustomerDetails customerDetails){
        String last_name = customerDetails.getLast_name();
        long phone_number = customerDetails.getPhone_number();
        String primaryKey = last_name+phone_number;
        UUID uuid = UUID.nameUUIDFromBytes(primaryKey.getBytes());
        System.out.println(uuid);

        return uuid;
    }

}
