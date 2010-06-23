package br.com.fantasydark;

public class ClassificacaoTime {
	private String time_nome;
	private String time_slug;
	private int posicao;
	private int pontos;
	
	public void setTime_nome(String time_nome) {
		this.time_nome = time_nome;
	}
	public String getTime_nome() {
		return time_nome;
	}
	public void setTime_slug(String time_slug) {
		this.time_slug = time_slug;
	}
	public String getTime_slug() {
		return time_slug;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getPontos() {
		return pontos;
	}
}
