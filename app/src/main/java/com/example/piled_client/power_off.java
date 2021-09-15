package com.example.piled_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;

class power_off extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = null;
        BufferedReader reader = null;
        String serverResponse = null;

        try {
            URL url = new URL("http://192.168.28.43/poweroff.php");
            HttpURLConnection powerOff = (HttpURLConnection) url.openConnection();
            powerOff.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            powerOff.setConnectTimeout(5000);
            powerOff.setRequestMethod("GET");
            powerOff.connect();

            int conStatusCode = powerOff.getResponseCode();
            if(conStatusCode == 200){
                sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(powerOff.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
            }
            powerOff.disconnect();
            if (sb != null){
                serverResponse = sb.toString();
            }

        }
        catch (Exception ex) {
            Log.e("Error:", " " + ex);
        }
        finally {
            if (reader != null){
                try {
                    reader.close();
                }
                catch (Exception ex){
                    Log.e("Error:", " " + ex);
                }
            }
        }
        return serverResponse;
    }
}
