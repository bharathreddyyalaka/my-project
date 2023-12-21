package com.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class CreateClient {

    public Table getTable(){
        //this is how to create an environmental variable(which we can specify in lambda env variable) to use it everywhere
        String table_name = System.getenv("DDB_TABLE");
        //code to create a client to use dynamo db in java project
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);
        // Here we get instance of table to perform db operations
        Table table = dynamoDB.getTable(table_name);
        return table;
    }
}
