package br.com.fantasydark;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class Manager {
	
	private Campeonato campeonato = null;
	private static Manager instance = null;
	
	private Manager() throws ClientProtocolException, IOException, JSONException {
		ResourceWeb resourceWeb = new ResourceWeb();
		this.campeonato =  resourceWeb.getCampeonato();
	}
	
	public static Manager getInstance() throws ClientProtocolException, IOException, JSONException {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public Campeonato getCampetonato() {
		return this.campeonato;
	}
	
}
