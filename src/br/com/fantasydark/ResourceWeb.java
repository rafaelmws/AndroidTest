package br.com.fantasydark;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResourceWeb {

	private final String listaJogosJson;
	private final String classificacaoJson;
	
	public ResourceWeb(){
		listaJogosJson = "http://globoesporte.globo.com/esporte/sde/classificacao/brasileirao2010/lista_de_jogos_por_rodada.json";
		classificacaoJson = "http://globoesporte.globo.com/esporte/sde/classificacao/brasileirao2010.json";
	}
	
	public Classificacao getClassificacao() throws ClientProtocolException, IOException, JSONException{
		Classificacao classificacao = new Classificacao();
		SimpleGetJson getJson = new SimpleGetJson(classificacaoJson);
		JSONArray jsonClassificacao = getJson.getJsonArray();
		
		return null;
	}
	
	public Campeonato getCampeonato() throws ClientProtocolException, IOException, JSONException{
		Campeonato campeonato = new Campeonato();
		SimpleGetJson getJson = new SimpleGetJson(listaJogosJson);
		
		JSONArray jsonJogos = getJson.getJsonArray();
		JSONObject jsonJogo;
		Jogo jogo;
		
		int rodada_atual = jsonJogos.getJSONArray(0).getInt(0);
		
		campeonato.setRodadaCorrente( rodada_atual );
		
		for (int y=1; y < jsonJogos.length(); y ++ ){
			
			for(int i=0; i < jsonJogos.getJSONArray(y).length(); i ++){
				jogo = new Jogo();
				jsonJogo = jsonJogos.getJSONArray(y).getJSONObject(i);
				int rodada = jsonJogo.getInt("rodada");
				int jogoId = jsonJogo.getInt("jogo_id");
				
				jogo.setId(jogoId);
				jogo.setVisitante_nome( jsonJogo.getString("nome_visitante") );
				jogo.setVisitante_slug( jsonJogo.getString("slug_visitante") );
				
				String placar_visitante = jsonJogo.getString("placar_time_visitante");
				if (placar_visitante == "null"){
					placar_visitante = "";
				}
				jogo.setVisitante_placar( placar_visitante );
				
				jogo.setMandante_nome( jsonJogo.getString("nome_mandante") );
				jogo.setMandante_slug( jsonJogo.getString("slug_mandante") );
				
				String placar_mandante = jsonJogo.getString("placar_time_mandante");
				if (placar_mandante == "null"){
					placar_mandante = "";
				}
				jogo.setMandante_placar( placar_mandante );
				
				campeonato.addJogo(rodada, jogo);
			}
		}
		
		return campeonato;
	}
}
