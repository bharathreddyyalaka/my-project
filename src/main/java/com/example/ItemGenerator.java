package com.example;

import com.amazonaws.services.dynamodbv2.document.Item;

import java.util.UUID;

public class ItemGenerator {


    public Item addItem(String[] nextLine){

        String time;
        String lat;
        String lon;
        String ssp126_tx_max_delta_1971_2000_p10;
        String ssp126_tx_max_delta_1971_2000_p50;
        String ssp126_tx_max_delta_1971_2000_p90;
        String ssp126_tx_max_delta_1991_2020_p10;
        String ssp126_tx_max_delta_1991_2020_p50;
        String ssp126_tx_max_delta_1991_2020_p90;
        String ssp126_tx_max_p10;
        String ssp126_tx_max_p50;
        String ssp126_tx_max_p90;
        String ssp245_tx_max_delta_1971_2000_p10;
        String ssp245_tx_max_delta_1971_2000_p50;
        String ssp245_tx_max_delta_1971_2000_p90;
        String ssp245_tx_max_delta_1991_2020_p10;
        String ssp245_tx_max_delta_1991_2020_p50;
        String ssp245_tx_max_delta_1991_2020_p90;
        String ssp245_tx_max_p10;
        String ssp245_tx_max_p50;
        String ssp245_tx_max_p90;
        String ssp585_tx_max_delta_1971_2000_p10;
        String ssp585_tx_max_delta_1971_2000_p50;
        String ssp585_tx_max_delta_1971_2000_p90;
        String ssp585_tx_max_delta_1991_2020_p10;
        String ssp585_tx_max_delta_1991_2020_p50;
        String ssp585_tx_max_delta_1991_2020_p90;
        String ssp585_tx_max_p10;
        String ssp585_tx_max_p50;
        String ssp585_tx_max_p90;

        if (nextLine[0] != null && !nextLine[0].isEmpty()) {
            time = nextLine[0];
        }else {
            time =" ";
        }if (nextLine[1] != null && !nextLine[1].isEmpty()) {
            lat = nextLine[1];
        }else {
            lat =" ";
        }if (nextLine[2] != null && !nextLine[2].isEmpty()) {
            lon = nextLine[2];
        }else {
            lon =" ";
        }if (nextLine[3] != null && !nextLine[3].isEmpty()) {
            ssp126_tx_max_delta_1971_2000_p10 = nextLine[3];
        }else {
            ssp126_tx_max_delta_1971_2000_p10 =" ";
        }if (nextLine[4] != null && !nextLine[4].isEmpty()) {
            ssp126_tx_max_delta_1971_2000_p50 = nextLine[4];
        }else {
            ssp126_tx_max_delta_1971_2000_p50 =" ";
        }if (nextLine[5] != null && !nextLine[5].isEmpty()) {
            ssp126_tx_max_delta_1971_2000_p90 = nextLine[5];
        }else {
            ssp126_tx_max_delta_1971_2000_p90 =" ";
        }if (nextLine[6] != null && !nextLine[6].isEmpty()) {
            ssp126_tx_max_delta_1991_2020_p10 = nextLine[6];
        }else {
            ssp126_tx_max_delta_1991_2020_p10 =" ";
        }if (nextLine[7] != null && !nextLine[7].isEmpty()) {
            ssp126_tx_max_delta_1991_2020_p50 = nextLine[7];
        }else {
            ssp126_tx_max_delta_1991_2020_p50 =" ";
        }if (nextLine[8] != null && !nextLine[8].isEmpty()) {
            ssp126_tx_max_delta_1991_2020_p90 = nextLine[8];
        }else {
            ssp126_tx_max_delta_1991_2020_p90 =" ";
        }if (nextLine[9] != null && !nextLine[9].isEmpty()) {
            ssp126_tx_max_p10 = nextLine[9];
        }else {
            ssp126_tx_max_p10 =" ";
        }if (nextLine[10] != null && !nextLine[10].isEmpty()) {
            ssp126_tx_max_p50 = nextLine[10];
        }else {
            ssp126_tx_max_p50 =" ";
        }if (nextLine[11] != null && !nextLine[11].isEmpty()) {
            ssp126_tx_max_p90 = nextLine[11];
        }else {
            ssp126_tx_max_p90 =" ";
        }if (nextLine[12] != null && !nextLine[12].isEmpty()) {
            ssp245_tx_max_delta_1971_2000_p10 = nextLine[12];
        }else {
            ssp245_tx_max_delta_1971_2000_p10 =" ";
        }if (nextLine[13] != null && !nextLine[13].isEmpty()) {
            ssp245_tx_max_delta_1971_2000_p50 = nextLine[13];
        }else {
            ssp245_tx_max_delta_1971_2000_p50 =" ";
        }if (nextLine[14] != null && !nextLine[14].isEmpty()) {
            ssp245_tx_max_delta_1971_2000_p90 = nextLine[14];
        }else {
            ssp245_tx_max_delta_1971_2000_p90 =" ";
        }if (nextLine[15] != null && !nextLine[15].isEmpty()) {
            ssp245_tx_max_delta_1991_2020_p10 = nextLine[15];
        }else {
            ssp245_tx_max_delta_1991_2020_p10 =" ";
        }if (nextLine[16] != null && !nextLine[16].isEmpty()) {
            ssp245_tx_max_delta_1991_2020_p50 = nextLine[16];
        }else {
            ssp245_tx_max_delta_1991_2020_p50 =" ";
        }if (nextLine[17] != null && !nextLine[17].isEmpty()) {
            ssp245_tx_max_delta_1991_2020_p90 = nextLine[17];
        }else {
            ssp245_tx_max_delta_1991_2020_p90 =" ";
        }if (nextLine[18] != null && !nextLine[18].isEmpty()) {
            ssp245_tx_max_p10 = nextLine[18];
        }else {
            ssp245_tx_max_p10 =" ";
        }if (nextLine[19] != null && !nextLine[19].isEmpty()) {
            ssp245_tx_max_p50 = nextLine[19];
        }else {
            ssp245_tx_max_p50 =" ";
        }if (nextLine[20] != null && !nextLine[20].isEmpty()) {
            ssp245_tx_max_p90 = nextLine[20];
        }else {
            ssp245_tx_max_p90 =" ";
        }if (nextLine[21] != null && !nextLine[21].isEmpty()) {
            ssp585_tx_max_delta_1971_2000_p10 = nextLine[21];
        }else {
            ssp585_tx_max_delta_1971_2000_p10 =" ";
        }if (nextLine[22] != null && !nextLine[22].isEmpty()) {
            ssp585_tx_max_delta_1971_2000_p50 = nextLine[22];
        }else {
            ssp585_tx_max_delta_1971_2000_p50 =" ";
        }if (nextLine[23] != null && !nextLine[23].isEmpty()) {
            ssp585_tx_max_delta_1971_2000_p90 = nextLine[23];
        }else {
            ssp585_tx_max_delta_1971_2000_p90 =" ";
        }if (nextLine[24] != null && !nextLine[24].isEmpty()) {
            ssp585_tx_max_delta_1991_2020_p10 = nextLine[24];
        }else {
            ssp585_tx_max_delta_1991_2020_p10 =" ";
        }if (nextLine[25] != null && !nextLine[25].isEmpty()) {
            ssp585_tx_max_delta_1991_2020_p50 = nextLine[25];
        }else {
            ssp585_tx_max_delta_1991_2020_p50 =" ";
        }if (nextLine[26] != null && !nextLine[26].isEmpty()) {
            ssp585_tx_max_delta_1991_2020_p90 = nextLine[26];
        }else {
            ssp585_tx_max_delta_1991_2020_p90 =" ";
        }if (nextLine[27] != null && !nextLine[27].isEmpty()) {
            ssp585_tx_max_p10 = nextLine[27];
        }else {
            ssp585_tx_max_p10 =" ";
        }if (nextLine[28] != null && !nextLine[28].isEmpty()) {
            ssp585_tx_max_p50 = nextLine[28];
        }else {
            ssp585_tx_max_p50 =" ";
        }if (nextLine[29] != null && !nextLine[29].isEmpty()) {
            ssp585_tx_max_p90 = nextLine[29];
        }else {
            ssp585_tx_max_p90 =" ";
        }

        ItemGenerator itemGenerator=new ItemGenerator();
        String primaryKey = (itemGenerator.generate(time,lat,lon)).toString();

        Item item = new Item();
        item.withPrimaryKey("UserId",primaryKey)
                .withString("time",  time)
                .withString("lat",lat)
                .withString("lon", lon)
                .withString("ssp126_tx_max_delta_1971_2000_p10", ssp126_tx_max_delta_1971_2000_p10)
                .withString("ssp126_tx_max_delta_1971_2000_p50", ssp126_tx_max_delta_1971_2000_p50)
                .withString("ssp126_tx_max_delta_1971_2000_p90", ssp126_tx_max_delta_1971_2000_p90)
                .withString("ssp126_tx_max_delta_1991_2020_p10", ssp126_tx_max_delta_1991_2020_p10)
                .withString("ssp126_tx_max_delta_1991_2020_p50", ssp126_tx_max_delta_1991_2020_p50)
                .withString("ssp126_tx_max_delta_1991_2020_p90", ssp126_tx_max_delta_1991_2020_p90)
                .withString("ssp126_tx_max_p10", ssp126_tx_max_p10)
                .withString("ssp126_tx_max_p50", ssp126_tx_max_p50)
                .withString("ssp126_tx_max_p90", ssp126_tx_max_p90)
                .withString("ssp245_tx_max_delta_1971_2000_p10", ssp245_tx_max_delta_1971_2000_p10)
                .withString("ssp245_tx_max_delta_1971_2000_p50", ssp245_tx_max_delta_1971_2000_p50)
                .withString("ssp245_tx_max_delta_1971_2000_p90", ssp245_tx_max_delta_1971_2000_p90)
                .withString("ssp245_tx_max_delta_1991_2020_p10", ssp245_tx_max_delta_1991_2020_p10)
                .withString("ssp245_tx_max_delta_1991_2020_p50", ssp245_tx_max_delta_1991_2020_p50)
                .withString("ssp245_tx_max_delta_1991_2020_p90", ssp245_tx_max_delta_1991_2020_p90)
                .withString("ssp245_tx_max_p10", ssp245_tx_max_p10)
                .withString("ssp245_tx_max_p50", ssp245_tx_max_p50)
                .withString("ssp245_tx_max_p90", ssp245_tx_max_p90)
                .withString("ssp585_tx_max_delta_1971_2000_p10", ssp585_tx_max_delta_1971_2000_p10)
                .withString("ssp585_tx_max_delta_1971_2000_p50", ssp585_tx_max_delta_1971_2000_p50)
                .withString("ssp585_tx_max_delta_1971_2000_p90", ssp585_tx_max_delta_1971_2000_p90)
                .withString("ssp585_tx_max_delta_1991_2020_p10", ssp585_tx_max_delta_1991_2020_p10)
                .withString("ssp585_tx_max_delta_1991_2020_p50", ssp585_tx_max_delta_1991_2020_p50)
                .withString("ssp585_tx_max_delta_1991_2020_p90", ssp585_tx_max_delta_1991_2020_p90)
                .withString("ssp585_tx_max_p10", ssp585_tx_max_p10)
                .withString("ssp585_tx_max_p50", ssp585_tx_max_p50)
                .withString("ssp585_tx_max_p90", ssp585_tx_max_p90);

        return item;
    }

    public UUID generate(String time, String lat, String lon){

        UUID uuid = UUID.nameUUIDFromBytes((time+lat+lon).getBytes());
        return uuid;
    }
}
