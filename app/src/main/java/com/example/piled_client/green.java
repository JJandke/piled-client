package com.example.piled_client;

import java.net.URL;
import android.util.Log;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class green extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = null;
        BufferedReader reader = null;
        String serverResponse = null;

        try {
            URL url = new URL("http://192.168.28.43/green.php");
            HttpURLConnection conn_green = (HttpURLConnection) url.openConnection();
            conn_green.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn_green.setConnectTimeout(5000);
            conn_green.setRequestMethod("GET");
            conn_green.connect();

            int conStatusCode = conn_green.getResponseCode();
            if(conStatusCode == 200){
                sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(conn_green.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
            }
            conn_green.disconnect();
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
