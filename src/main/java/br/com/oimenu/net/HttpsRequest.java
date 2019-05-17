package br.com.oimenu.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;


public class HttpsRequest {
	protected static String apiUrl = "https://developers.oimenu.com.br";
	protected static String apiVersion = "v1";
	
	public static String getResult(String token, String method, String api, Object postObject) {
		URL url = null;
		InputStream is = null;
		String json;
		try {
			
			url = new URL(apiUrl + "/api/" + apiVersion + "/" + api);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod(method);
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
	
			con.setRequestProperty("Authorization", "Bearer " + token);
			
			if ((method.equals("PUT") || method.equals("POST")) && postObject != null ) {
		          con.setRequestProperty("Content-Type", "application/json");
		          con.setDoOutput(true);
		
		          String parametro;
		          if (postObject.getClass().equals(String.class)) {
		        	 parametro = String.valueOf(postObject);
		          } else {
		        	  Gson gson = new Gson();
		        	  parametro = gson.toJson(postObject);
		          }
		          

		          byte[] postData = parametro.getBytes(StandardCharsets.UTF_8);
		          con.setRequestProperty("Content-Length", Integer.toString(postData.length));
		          DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		          wr.write(postData);
			}
			
			con.connect();
			if (con.getResponseCode() != 200)
				is = con.getErrorStream();
			else
				is = con.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 10240);

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            
            json = builder.toString();
		} catch (Exception e) {
			//e.printStackTrace();
			json = "{\"success\":\"false\",\"message\":\""+e.getLocalizedMessage()+"\"}";
		}
		
		return json;
		
	}
    
}