package br.com.fantasydark;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Simulador2010 extends TabActivity 
{
    public static final String TAG = "Simulador";
    		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {    	

    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.abas);

    	TabHost mTabHost = getTabHost();

    	mTabHost.addTab(mTabHost.newTabSpec("tab_tabela")
    			.setIndicator("tabela")
    			.setContent(new Intent(this, TabelaClassificacao.class)));
        
    	mTabHost.addTab(mTabHost.newTabSpec("tab_jogos")
        		.setIndicator("jogos")
    			.setContent(new Intent(this, ListaDeJogos.class)));
        
        mTabHost.addTab(mTabHost.newTabSpec("tab_simulador")
        		.setIndicator("simulador")
        		.setContent(new Intent(this, SimulacotAct.class)));
        
        mTabHost.setCurrentTab(0);

    }
        
}
