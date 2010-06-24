package br.com.fantasydark;

import java.util.ArrayList;

public class Classificacao {
	
	ArrayList<ClassificacaoTime> classificacaoTimes;
	
	public Classificacao(){
		this.classificacaoTimes = new ArrayList<ClassificacaoTime>();
	}
	
	public void reorder(){
		
		int total = this.classificacaoTimes.size();
		int inicio = total -1;
		//Buble Sort
		for (int index = inicio; index >= 0; index --){
			
			int anterior = index - 1;
			if (anterior >= 0){
				ClassificacaoTime classificacaoTimeAnterior = this.classificacaoTimes.get(anterior);
				ClassificacaoTime classificacaoTime = this.classificacaoTimes.get(index);
				
				if (classificacaoTime.getPontos() > classificacaoTimeAnterior.getPontos()){
					classificacaoTime.setPosicao(anterior + 1);
					classificacaoTimeAnterior.setPosicao(index + 1);
					this.classificacaoTimes.set(anterior, classificacaoTime);
					this.classificacaoTimes.set(index, classificacaoTimeAnterior);
				}
			}
		}
		
	}
	
	public ArrayList<ClassificacaoTime> getClassificacao(){
		return this.classificacaoTimes;
	}
	
	public void addClassificacaoTime(ClassificacaoTime classificacaoTime){
		
		ClassificacaoTime classificacaoExistente = this.getTime(classificacaoTime.getTime_slug());
		if (classificacaoExistente == null){
			this.classificacaoTimes.add(classificacaoTime);
		}
		else{
			int index = this.classificacaoTimes.indexOf(classificacaoExistente);
			this.classificacaoTimes.set(index, classificacaoTime);
		}
		
	}
	
	public ClassificacaoTime getTime(String slug_time){
		for(int i = 0; i < this.classificacaoTimes.size(); i ++){
			if (this.classificacaoTimes.get(i).getTime_slug().equals(slug_time)){
				return this.classificacaoTimes.get(i);
			}
		}
		return null;
	}
	
}
