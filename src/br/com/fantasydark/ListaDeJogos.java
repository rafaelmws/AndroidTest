package br.com.fantasydark;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ListaDeJogos extends Activity {

	final String urlListaDeJogos = "";
	private TextView txtRodadaAtual;
	private Button btnRodadaProxima;
	private Button btnRodadaAnterior;
	private Campeonato campeonato;
	
	private OnClickListener rodadaProximaOnClickListener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			campeonato.setRodadaCorrente(6);
			populate();
		}
	};
	
	private OnClickListener rodadaAnteriorClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			campeonato.setRodadaCorrente(4);
			populate();
		}
	};
	
	private void populate(){
		String rodada = Integer.toString(campeonato.getRodadaCorrente());
		txtRodadaAtual.setText(rodada + " rodada");
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_de_jogos);
		
		this.campeonato = new Campeonato();
		this.campeonato.setRodadaCorrente(5);
		
		this.txtRodadaAtual = (TextView) findViewById(R.id.rodada_atual);
		this.btnRodadaAnterior = (Button) findViewById(R.id.rodada_anterior);
		this.btnRodadaProxima = (Button) findViewById(R.id.rodada_proxima);
		
		this.btnRodadaProxima.setOnClickListener(rodadaProximaOnClickListener);
		this.btnRodadaAnterior.setOnClickListener(rodadaAnteriorClickListener);
	}
		
}
