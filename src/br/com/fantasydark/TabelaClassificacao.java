package br.com.fantasydark;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TabelaClassificacao extends Activity {

	final String classificacaoJson = "http://globoesporte.globo.com/esporte/sde/classificacao/brasileirao2010.json";
	private SimpleGetJson simpleGetJson;
	private ListView mLv;
	
	public ArrayList<HashMap<String,String>> getClassificacaoJson() throws Exception{
		
		JSONArray array = this.simpleGetJson.getJsonArray();
		ArrayList<HashMap<String,String>> itens = new ArrayList<HashMap<String,String>>();
		
		for (int i=0; i < array.length(); i++){
			JSONObject obj = new JSONObject(array.getString(i));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("nome", obj.getString("nome_popular"));
			map.put("ordem", obj.getString("ordem"));
			map.put("pontos",obj.getString("pontos") + "pt");
			itens.add(map);
		}
		return itens;
	}

	public void populate() throws Exception {
		ArrayList<HashMap<String, String>> mylist = this.getClassificacaoJson();
		SimpleAdapter mSchedule = new SimpleAdapter(this, mylist, R.layout.classificacao_time,
		            new String[] {"ordem", "nome", "pontos"}, new int[] {R.id.posicao, R.id.time, R.id.pontos});
		
		mLv.setAdapter(mSchedule);
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabela_classificacao);
    	
		this.simpleGetJson = new SimpleGetJson(this.classificacaoJson);
		mLv = (ListView) findViewById(R.id.ListaClassificacao);
		try {
			populate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
