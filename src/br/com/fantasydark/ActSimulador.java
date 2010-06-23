package br.com.fantasydark;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ActSimulador extends Activity {

	private final int LOAD = 0;
	private final int SAVE = 1;

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
		Dialog dialog = new Dialog(this.getApplicationContext());

		dialog.setContentView(R.layout.dialog_salvar_confronto);
		dialog.setTitle("Custom Dialog");

		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Hello, this is a custom dialog!");
		
		dialog.show();
	}

	private void carregar_simulacoes() {
		final CharSequence[] items = {"Simulação 1", "Simulação 2", "Simulação 3"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selecione uma simulação");
		
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	String message = "carregando " + items[item].toString();
		        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		    }
		});
		
		builder.create().show();
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simulador_lista_jogos);
	}

}
