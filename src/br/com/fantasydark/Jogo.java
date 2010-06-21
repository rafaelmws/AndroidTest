package br.com.fantasydark;

import java.util.HashMap;

public class Jogo {

	private String visitante_nome;
	private String visitante_slug;
	private String visitante_placar;

	private String mandante_nome;
	private String mandante_slug;
	private String  mandante_placar;

	private int rodada;
	private int id;
	
	public void setVisitante_nome(String visitante_nome) {
		this.visitante_nome = visitante_nome;
	}

	public String getVisitante_nome() {
		return visitante_nome;
	}

	public void setVisitante_slug(String visitante_slug) {
		this.visitante_slug = visitante_slug;
	}

	public String getVisitante_slug() {
		return visitante_slug;
	}

	public void setVisitante_placar(String visitante_placar) {
		this.visitante_placar = visitante_placar;
	}

	public String getVisitante_placar() {
		return visitante_placar;
	}

	public void setMandante_nome(String mandante_nome) {
		this.mandante_nome = mandante_nome;
	}

	public String getMandante_nome() {
		return mandante_nome;
	}

	public void setMandante_slug(String mandante_slug) {
		this.mandante_slug = mandante_slug;
	}

	public String getMandante_slug() {
		return mandante_slug;
	}

	public void setMandante_placar(String mandante_placar) {
		this.mandante_placar = mandante_placar;
	}

	public String getMandante_placar() {
		return mandante_placar;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public int getRodada() {
		return rodada;
	}

	public HashMap<String, String> toHash(){
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("mandante_nome", this.mandante_nome);
		hash.put("mandante_placar", this.mandante_placar);
		hash.put("mandante_slug", this.mandante_slug);
		
		hash.put("visitante_nome", this.visitante_nome);
		hash.put("visitante_slug", this.visitante_slug);
		hash.put("visitante_placar", this.visitante_placar);
		
		return hash;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
