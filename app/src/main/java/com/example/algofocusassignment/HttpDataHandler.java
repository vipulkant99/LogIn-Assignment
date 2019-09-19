package com.example.algofocusassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpDataHandler {

    public HttpDataHandler() {
    }

    public String getData(String requestUrl){
        URL url;
        String response = "";
        try{
            url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setReadTimeout(15000);
            con.setConnectTimeout(15000);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            con.setDoOutput(true);
            int responsecode = con.getResponseCode();
            if(responsecode == HttpURLConnection.HTTP_OK){
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line=br.readLine())!=null){
                    response+=line;
                }
            }
            else
                response = "";
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  response;
    }
}
