package entities;

import java.util.HashSet;
import java.util.Set;

public class Mochila {
	private int capacidade;
	
	private float valorTotal;
	
	private float pesoAtual;
	
	private Set<Item> itens;

	public Mochila(int capacidade) {
		this.valorTotal = 0;
		this.pesoAtual = 0;
		this.capacidade = capacidade;
		this.itens = new HashSet<>();
	}
	
	public Mochila() {
		this.valorTotal = 0;
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
	
	public float getValorTotal() {
		return this.valorTotal;
	}

	public void addItem(Item item) {
		if (this.pesoAtual + item.getPeso() > this.capacidade) {
			throw new IllegalArgumentException("Capacidade excedida!!");
		}
		if (item.isAlocado()) {
			throw new RuntimeException("O item ja está alocado!!");
		}
		this.itens.add(item);
		item.setAlocado(true);
		this.valorTotal += item.getValor();
		this.pesoAtual += item.getPeso();
	}
	
}
