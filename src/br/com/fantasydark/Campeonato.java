package br.com.fantasydark;

import java.util.ArrayList;
import java.util.HashMap;

public class Campeonato {

	private int rodadaAtual;
	private int rodadaCorrente;
	private int rodadaFinal;
	private HashMap<Integer, ArrayList<Jogo>> jogos;

	public Campeonato() {
		this.jogos = new HashMap<Integer, ArrayList<Jogo>>();
	}

	public int getRodadaAtual() {
		return rodadaAtual;
	}

	public void setRodadaCorrente(int rodadaCorrente) {
		this.rodadaCorrente = rodadaCorrente;
	}

	public int getRodadaCorrente() {
		return this.rodadaCorrente;
	}
	
	public int getRoadadaFinal(){
		return this.rodadaFinal;
	}

	public ArrayList<Jogo> getJogos(int rodada) throws Exception {
		if (!this.jogos.containsKey(rodada)) {
			throw new Exception("rodada " + Integer.toString(rodada)
					+ " nao encontrada entre as rodadas ["
					+ this.jogos.keySet().toString() + "]");
		}

		return this.jogos.get(rodada);

	}

	public void addJogo(Integer rodada, Jogo jogo) {
		if (!this.jogos.containsKey(rodada)) {
			this.jogos.put(rodada, new ArrayList<Jogo>());
		}

		this.jogos.get(rodada).add(jogo);
		
		if (rodada > this.rodadaFinal){
			this.rodadaFinal = rodada;
		}
	}

	public ArrayList<HashMap<String, String>> getJogosArray(int rodada)
			throws Exception {
		ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
		ArrayList<Jogo> jogos = this.getJogos(rodada);

		for (int i = 0; i < jogos.size(); i++) {
			Jogo jogo = jogos.get(i);
			lista.add(jogo.toHash());
		}

		return lista;
	}

}
