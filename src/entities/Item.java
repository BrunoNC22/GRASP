package entities;

public class Item {
	
	int peso;
	
	float valor;
	
	boolean alocado;

	public Item(int peso, float valor) {
		this.peso = peso;
		this.valor = valor;
		this.alocado = false;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isAlocado() {
		return alocado;
	}

	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}
	
	
	
	

}
