package com.example;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.JSONInput;
//import com.amazonaws.services.s3.model.S3Event;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.slf4j.*;
import software.amazon.awssdk.arns.Arn;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.UUID;

public class App implements RequestHandler<S3Event,String> {

//    public String handleRequest(CustomerDetails customerDetails) {
//
//        Service service = new Service();
//        UUID uuid = service.generateKeyForDB(customerDetails);
//        DBOperations dbOperations = new DBOperations();
//        String response = dbOperations.saveData(uuid,customerDetails);
//        System.out.println("updated");
//
//        return response;
//    }

   // private static final Logger logger = LoggerFactory.getLogger(App.class);
    @Override
    public String handleRequest(S3Event s3Event, Context context) {


       try {
            S3EventNotification.S3EventNotificationRecord record = s3Event.getRecords().get(0);
            String srcBucket = record.getS3().getBucket().getName();
            String srcKey = record.getS3().getObject().getUrlDecodedKey();



            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
            try {
                S3Object s3Object = s3Client.getObject(new GetObjectRequest(srcBucket, srcKey));
                S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
           /* HeadObjectResponse headObject = getHeadObject(s3Client, srcBucket, srcKey);

            GetObjectRequest getObjectRequest = new GetObjectRequest(srcBucket,srcKey);
            GetObjectResponse response = s3Client.getObject(getObjectRequest);*/

                // logger.info("Successfully retrieved " + srcBucket + "/" + srcKey + " of type " + headObject.contentType());
                //System.out.println(srcBucket+"--"+srcKey+"--"+headObject.contentType());
//-------------------- after getting object writing to a file=---------------------------------
                /*FileOutputStream fos = new FileOutputStream(new File(srcKey));
                byte[] read_buf = new byte[1024];
                int read_len = 0;
                while ((read_len = s3ObjectInputStream.read(read_buf)) > 0) {
                    fos.write(read_buf, 0, read_len);
                }
                s3ObjectInputStream.close();
                fos.close();
            }*/
                String table_name = System.getenv("TERRAFORM_TABLE");
                //code to create a client to use dynamo db in java project
                AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
                DynamoDB dynamoDB = new DynamoDB(client);
                // Here we get instance of table to perform db operations
                Table table = dynamoDB.getTable(table_name);
                TableWriteItems tableWriteItems = new TableWriteItems(table.getTableName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(s3ObjectInputStream));
                String line = null;
                List<Item> itemList = new ArrayList<Item>();
                String[] row =null;
                while ((line = reader.readLine()) != null) {
                    row = line.split(",");
                    /*for (String value : row) {
                        System.out.print(value + "   ");
                    }
                    System.out.println();*/
                    ItemGenerator itemGenerator = new ItemGenerator();
                    itemList.add(itemGenerator.addItem(row));
                }


                for(List<Item> list: Lists.partition(itemList,25)) {
                    tableWriteItems.withItemsToPut(list);
                    BatchWriteItemOutcome outcome = dynamoDB.batchWriteItem(tableWriteItems);
                }
            }

                catch (Exception e){
                    System.err.println(e.getMessage());
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Ok";
    }

   /* private HeadObjectResponse getHeadObject(S3Client s3Client, String bucket, String key) {
        HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        return s3Client.headObject(headObjectRequest);
    }*/

   /* public ResponseInputStream<GetObjectResponse> getObject(HeadObjectResponse getObjectRequest)
            throws NoSuchKeyException,
            InvalidObjectStateException,
            AwsServiceException,
            SdkClientException,
            S3Exception{

    }*/
}
