package br.com.fantasydark;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActSimulador extends Activity {
	
	private final int LOAD = 0;
	private final int SAVE = 1;
	
	private EditText time1_placar = null;
	private Button confirmar = null;
	

	/* Creates the menu items */
	public boolean onCreateOptionsMenu(Menu menu) {
	    menu.add(0, LOAD, 0, "Carregar");
	    menu.add(0, SAVE, 0, "Salvar");
	    return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
	    
		int item_id = item.getItemId();
		
		if (item_id == LOAD){
			carregar_simulacoes();
			return true;
		}
		else if (item_id == SAVE){
			salvar_simulacao();
			return true;
		}
		
	    return false;
	}
	
	private void salvar_simulacao() {
	}

	private void carregar_simulacoes() {
		final CharSequence[] items = {"Simulacao 1", "Simulaco 2", "Simulaco 3"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecione uma simulao");
		
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	String message = "carregando " + items[item].toString();
		        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		    }
		});
		
		builder.create().show();
		
	}
	
	private void populate(){
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simulador_lista_jogos);
		
		this.time1_placar = (EditText) findViewById(R.id.sim_time1_placar);
		this.confirmar = (Button) findViewById(R.id.sim_confirmar) ;
		
		this.confirmar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Classificacao classificacao = Manager.getInstance().getClassificacao();
				ClassificacaoTime time = classificacao.getTime("flamengo");
				
				String pontos_str = time1_placar.getText().toString(); 
				int pontos = Integer.parseInt(pontos_str); 
				time.setPontos(pontos);
				classificacao.addClassificacaoTime(time);
				classificacao.reorder();
				
				String message = "flamengo esta na " + Integer.toString(time.getPosicao());
				Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
			}
		});
		
		
		this.populate();
	}

}
