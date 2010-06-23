package br.com.fantasydark;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class ActBrasileirao2010 extends TabActivity 
{
    public static final String TAG = "Simulador";
    		    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {    	

    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.abas);

    	TabHost mTabHost = getTabHost();

    	mTabHost.addTab(mTabHost.newTabSpec("tab_tabela")
    			.setIndicator("tabela")
    			.setContent(new Intent(this, ActTabelaClassificacao.class)));
        
    	mTabHost.addTab(mTabHost.newTabSpec("tab_jogos")
        		.setIndicator("jogos")
    			.setContent(new Intent(this, ActListaDeJogos.class)));
        
        mTabHost.addTab(mTabHost.newTabSpec("tab_simulador")
        		.setIndicator("simulador")
        		.setContent(new Intent(this, ActSimulador.class)));
        
        mTabHost.setCurrentTab(0);

    }
        
}
