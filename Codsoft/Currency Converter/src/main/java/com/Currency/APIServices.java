package com.currency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class APIServices {

    public double getExchangeRate(String base, String target) {
        try {
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + base;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject rates = json.getJSONObject("rates");

            return rates.getDouble(target);

        } catch (Exception e) {
            System.out.println("Error fetching API");
            return -1;
        }
    }
}