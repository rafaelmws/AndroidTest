package br.com.fantasydark;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.Activity;

public class Manager {
	
	private Campeonato campeonato = null;
	private Classificacao classificacao = null;
	private Activity currentActivity = null;
	private static Manager instance = null;
	
	private Manager() throws ClientProtocolException, IOException, JSONException {
		ResourceWeb resourceWeb = new ResourceWeb();
		this.campeonato =  resourceWeb.getCampeonato();
		this.classificacao = resourceWeb.getClassificacao();
	}
	
	public static Manager getInstance() {
		if (instance == null) {
			try {
				instance = new Manager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public Campeonato getCampetonato() {
		return this.campeonato;
	}
	
	public Classificacao getClassificacao(){
		return this.classificacao;
	}

	public void setCurrentActivity(Activity currentActivity) {
		this.currentActivity = currentActivity;
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}
	
}
