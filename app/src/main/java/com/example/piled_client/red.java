package com.example.piled_client;

import java.net.URL;
import android.util.Log;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class red extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = null;
        BufferedReader reader = null;
        String serverResponse = null;

        try {
            URL url = new URL("http://192.168.28.43/red.php");
            HttpURLConnection conn_red = (HttpURLConnection) url.openConnection();
            conn_red.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn_red.setConnectTimeout(5000);
            conn_red.setRequestMethod("GET");
            conn_red.connect();

            int conStatusCode = conn_red.getResponseCode();
            if(conStatusCode == 200){
                sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(conn_red.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
            }
            conn_red.disconnect();
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
