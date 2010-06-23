package br.com.fantasydark;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ActTabelaClassificacao extends Activity {

	private ListView mLv;
	private Classificacao classificacao = null;

	public ArrayList<HashMap<String, String>> getClassificacaoJson()
			throws Exception {

		ArrayList<HashMap<String, String>> itens = new ArrayList<HashMap<String,String>>();
		this.classificacao.reorder();
		
		for (int i = 0; i < this.classificacao.getClassificacao().size(); i++) {

			ClassificacaoTime classificacaoTime = this.classificacao
					.getClassificacao().get(i);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("nome", classificacaoTime.getTime_nome() );
			map.put("ordem", Integer.toString(i + 1) );
			map.put("pontos", classificacaoTime.getPontos() + "pt");
			
			itens .add(map);
		}
		return itens;
	}

	public void populate() throws Exception {
		ArrayList<HashMap<String, String>> mylist = this.getClassificacaoJson();
		SimpleAdapter mSchedule = new SimpleAdapter(this, mylist,
				R.layout.classificacao_time, new String[] { "ordem", "nome",
						"pontos" }, new int[] { R.id.posicao, R.id.time,
						R.id.pontos });

		mLv.setAdapter(mSchedule);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabela_classificacao);

		this.mLv = (ListView) findViewById(R.id.ListaClassificacao);

		try {
			this.classificacao = Manager.getInstance().getClassificacao();
			ClassificacaoTime flamengo =  this.classificacao.getTime("flamengo");
			flamengo.setPontos(50);
			
			this.classificacao.addClassificacaoTime(flamengo);
			this.classificacao.reorder();
			
			populate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
