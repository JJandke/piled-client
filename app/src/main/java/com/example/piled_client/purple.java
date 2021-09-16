package com.example.piled_client;

import java.net.URL;
import android.util.Log;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class purple extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = null;
        BufferedReader reader = null;
        String serverResponse = null;

        try {
            URL url = new URL("http://192.168.28.43/purple.php");
            HttpURLConnection conn_purple = (HttpURLConnection) url.openConnection();
            conn_purple.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn_purple.setConnectTimeout(5000);
            conn_purple.setRequestMethod("GET");
            conn_purple.connect();

            int conStatusCode = conn_purple.getResponseCode();
            if(conStatusCode == 200){
                sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(conn_purple.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
            }
            conn_purple.disconnect();
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
