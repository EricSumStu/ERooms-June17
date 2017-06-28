package com.example.eowemcn.myapplication.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.models.Room;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class PutRoomStatusTask extends AsyncTask<Object, Object, String> {
        private ProgressDialog pDialog;
        private Context context;

        public PutRoomStatusTask(Context context){
            this.context = context;
        }

    @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Putting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(Object... params) {
            try{
                Room room = (Room) params[0];
                String u = context.getResources().getString(R.string.URL) + "/" + room.getId() + "/";
                URL url = new URL(u); // here is your URL path

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", room.getId());
                jsonObject.put("name", room.getName());
                jsonObject.put("zone", String.valueOf(room.getZone().getIntValue()));
                jsonObject.put("capacity", room.getCapacity());
                jsonObject.put("availability", room.isAvailable());


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod("PUT");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonObject.toString());

                writer.flush();
                writer.close();
                os.close();

                String msg = conn.getResponseMessage();
                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(
                            new InputStreamReader(
                                    conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute(String result) {
            pDialog.dismiss();
            Log.e("response", result);
            // refresh any list
        }
    }