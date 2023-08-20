package entities;

import java.util.HashSet;
import java.util.Set;

public class Mochila {
	private int capacidade;
	
	private float pesoAtual;
	
	private Set<Item> itens;

	public Mochila(int capacidade) {
		this.pesoAtual = 0;
		this.capacidade = capacidade;
		this.itens = new HashSet<>();
	}
	
	public Mochila() {
		this.pesoAtual = 0;
		this.itens = new HashSet<>();
		
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void addItem(Item item) {
		if (this.pesoAtual + item.getPeso() > this.capacidade) {
			throw new IllegalArgumentException("Capacidade excedida!!");
		}
		this.itens.add(item);
		this.pesoAtual += item.getPeso();
	}
	
	
	
	
}
