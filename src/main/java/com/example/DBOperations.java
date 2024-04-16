package com.example;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableWriteItems;

import java.util.UUID;

public class DBOperations{


    public String saveData(UUID primaryKey, CustomerDetails customerDetails){

        CreateClient client = new CreateClient();
        Table table = client.getTable();
        // used to create an object of data to store in db
        String abc ="hello";
        TableWriteItems tableWriteItems = new TableWriteItems(table.getTableName());
        Item item = new Item();
        item.withPrimaryKey("uuid",primaryKey.toString()).withString("Details", customerDetails.getFirst_name());
        table.putItem(item);
        Item response = table.getItem("uuid",primaryKey.toString());
        return response.toString();


    }


}
