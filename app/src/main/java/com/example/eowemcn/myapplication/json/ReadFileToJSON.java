package com.example.eowemcn.myapplication.json;

import android.content.res.Resources;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ReadFileToJSON {
    private JSONObject jObject;

    public ReadFileToJSON(Resources resources, int resource) throws IOException, JSONException {

        InputStream is = resources.openRawResource(resource); // Open input stream to hold data
        Writer writer = new StringWriter(); // Create a new String Writer to hold new String
        char[] buffer = new char[1024]; // Set a buffer 1024 chars
        try {
            // Read in the file using an input stream
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                // Write the data read in to our String buffer
                writer.write(buffer, 0, n);
            }
        }catch(UnsupportedEncodingException e){

        } finally {
            is.close(); // Close input stream
        }

        // Get the final String from the StringWriter
        String rawString = writer.toString();

        // Parse raw String to JSON
        jObject = new JSONObject(rawString);
    }

    public JSONObject getJSON() {
        return jObject;
    }
}
