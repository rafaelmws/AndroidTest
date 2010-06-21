package br.com.fantasydark;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SimulacotAct extends Activity {

	private ListView listJogos;
	private TextView txtRodadaAtual;
	private Button btnRodadaProxima;
	private Button btnRodadaAnterior;

	private Campeonato campeonato;

	private void populate() throws Exception {
		int rodada = this.campeonato.getRodadaCorrente();

		ArrayList<HashMap<String, String>> mylist = this.campeonato
				.getJogosArray(rodada);
		SimpleAdapter mSchedule = new SimpleAdapter(this, mylist,
				R.layout.jogo,
				new String[] { "mandante_nome", "mandante_placar",
						"visitante_placar", "visitante_nome" }, new int[] {
						R.id.simulador_mandante_time, R.id.simulador_mandante_placar,
						R.id.simulador_visitante_placar, R.id.simulador_visitante_time });

		listJogos.setAdapter(mSchedule);
		this.txtRodadaAtual.setText(Integer.toString(rodada) + " rodada ");

		this.btnRodadaAnterior.setEnabled(true);
		this.btnRodadaProxima.setEnabled(true);
		if (rodada == 1) {
			this.btnRodadaAnterior.setEnabled(false);
		}

		if (rodada == this.campeonato.getRoadadaFinal()) {
			this.btnRodadaProxima.setEnabled(false);
		}

	}

	private void populate_erro(String erro) {

		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("erro", erro);
		mylist.add(hash);

		SimpleAdapter mSchedule = new SimpleAdapter(this, mylist,
				R.layout.jogo, new String[] { "erro" },
				new int[] { R.id.simulador_mandante_time });

		listJogos.setAdapter(mSchedule);
	}

	private void proximaRodada() {
		int rodada_corrente = this.campeonato.getRodadaCorrente();
		rodada_corrente += 1;
		this.campeonato.setRodadaCorrente(rodada_corrente);
		try {
			populate();
		} catch (Exception e) {
			populate_erro(e.getMessage());
		}

	}

	private void rodadaAnterior() {
		int rodada_corrente = this.campeonato.getRodadaCorrente();
		rodada_corrente -= 1;
		this.campeonato.setRodadaCorrente(rodada_corrente);
		try {
			populate();
		} catch (Exception e) {
			populate_erro(e.getMessage());
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_de_jogos);

		this.listJogos = (ListView) findViewById(R.id.simulador_lista_jogos);
		this.btnRodadaAnterior = (Button) findViewById(R.id.simulador_rodada_anterior);
		this.btnRodadaProxima = (Button) findViewById(R.id.simulador_rodada_proxima);
		this.txtRodadaAtual = (TextView) findViewById(R.id.simulador_rodada_atual);

		try {
			this.campeonato = Manager.getInstance().getCampetonato();
			this.populate();

		} catch (Exception e) {
			this.populate_erro(e.getMessage());
		}

		this.btnRodadaAnterior.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				rodadaAnterior();
			}
		});

		this.btnRodadaProxima.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				proximaRodada();
			}
		});

	}

}
