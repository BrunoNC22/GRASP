package entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
		return Collections.unmodifiableSet(this.itens);
	}
	
	public float getValorTotal() {
		return this.valorTotal;
	}

	public void addItem(Item item) {
		if (this.pesoAtual + item.getPeso() > this.capacidade) {
			throw new RuntimeException("Capacidade excedida!!");
		}
		if (item.isAlocado()) {
			throw new RuntimeException("O item ja está alocado!!");
		}
		this.itens.add(item);
		item.setAlocado(true);
		this.valorTotal += item.getValor();
		this.pesoAtual += item.getPeso();
	}
	
	public void setItens(List<Item> itens) {
		for (Item item : itens) {
			this.addItem(item);
		}
	}
	
	public float getPesoAtual() {
		return this.pesoAtual;
	}
}
