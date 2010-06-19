package br.com.fantasydark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleGetJson {

	private final String uri;
	
	public SimpleGetJson(String uri){
		this.uri = uri;
	}
	
	public JSONObject getJsonObject() throws ClientProtocolException, IOException, JSONException{
		String result = this.getStringResult();
		return new JSONObject(result);
	}
	
	public JSONArray getJsonArray() throws ClientProtocolException, IOException, JSONException{
		String result = this.getStringResult();
		return new JSONArray(result);

	}
	
	private String getStringResult() throws ClientProtocolException, IOException{
		HttpClient mHttpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(this.uri);
		HttpResponse response = mHttpClient.execute(request);
		HttpEntity entity = response.getEntity();
		InputStream instream = entity.getContent();
		return convertStreamToString(instream);

	}
	
	private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

	
}
