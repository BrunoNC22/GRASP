package app;

import java.io.FileNotFoundException;
import java.util.List;

import entities.Item;
import entities.Mochila;
import utilities.ArchiveReader;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		Mochila mochila = new Mochila(50);
		
		Item banana = new Item(3, 7);
		Item beringela = new Item(5, 9);
		Item abacaxi = new Item(2, 6);
		Item queijo = new Item(1, 7);
		
		Item teste1 = new Item(8, 7);
		Item teste2 = new Item(3, 9);
		Item teste3 = new Item(3, 7);
		
		Item[] itens = {banana, beringela, abacaxi, queijo, teste1, teste2, teste3};
		
		for (Item tempItem : itens) {
			mochila.addItem(tempItem);
		}
		
		for (Item tempItem : mochila.getItens()) {
			System.out.println("peso: " + Integer.toString(tempItem.getPeso()) + " valor: " + Float.toString(tempItem.getValor()));
		}
		
		System.out.println("------------------");
		ArchiveReader ar = new ArchiveReader("C:\\Users\\the_b\\OneDrive\\Documentos\\Meu notebook\\PO\\T2\\PMB.txt");
		
		Mochila mochilinha = ar.createMochila();
		
		List<Item> itensList = ar.crateItens();
		
		for (Item tempItem : itensList) {
			mochilinha.addItem(tempItem);
		}
		
		for (Item tempItem : mochilinha.getItens()) {
			System.out.println("peso: " + Integer.toString(tempItem.getPeso()) + " valor: " + Float.toString(tempItem.getValor()));
		}
	}
	

}
