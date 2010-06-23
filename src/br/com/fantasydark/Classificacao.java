package br.com.fantasydark;

import java.util.ArrayList;

public class Classificacao {
	
	ArrayList<ClassificacaoTime> classificacaoTimes;
	
	public Classificacao(){
		this.classificacaoTimes = new ArrayList<ClassificacaoTime>();
	}
	
	public void reorder(){
		//Buble Sort
		for (int index = this.classificacaoTimes.size() -1; index < 0; index ++){
			
			int anterior = index - 1;
			if (anterior > 0){
				ClassificacaoTime classificacaoTimeAnterior = this.classificacaoTimes.get(anterior);
				ClassificacaoTime classificacaoTime = this.classificacaoTimes.get(index);
				
				String novo_nome = classificacaoTime.getTime_nome() + " -+- ";
				classificacaoTime.setTime_nome(novo_nome);
				
				if (classificacaoTime.getPontos() > classificacaoTimeAnterior.getPontos()){
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
		
		this.reorder();
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
