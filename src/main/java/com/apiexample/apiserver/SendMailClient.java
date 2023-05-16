package com.apiexample.apiserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendMailClient {
    public static void main(String[] args) {
        try {

            String toIds = "";
            String subject = "Test Email";
            String body = "Test body";

            URL url = new URL("http://localhost:8080/sendMail?to=" + URLEncoder.encode(toIds)
                    + "&subject=" + URLEncoder.encode(subject)
                    + "&body=" + URLEncoder.encode(body));//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}
