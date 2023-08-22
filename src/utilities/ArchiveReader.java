package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Item;
import entities.Mochila;

public class ArchiveReader {
	
	private String caminhoDoArquivo;
	
	public ArchiveReader(String caminhoDoArquivo){
		this.caminhoDoArquivo = caminhoDoArquivo;
	}
	
	public Mochila createMochila() throws FileNotFoundException {
		Mochila mochila = new Mochila();
		
		File arquivo = new File(this.caminhoDoArquivo);

        try {
        	Scanner scanner = new Scanner(arquivo);
        	mochila.setCapacidade(Integer.parseInt(scanner.nextLine()));
        	scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mochila;
	}
	
	public List<Item> crateItens() throws FileNotFoundException {
		List<Item> itens = new ArrayList<Item>();
		File arquivo = new File(this.caminhoDoArquivo);
        try {
            Scanner scanner = new Scanner(arquivo);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
            	String[] linha = scanner.nextLine().split(" ");
            	float valor = Float.parseFloat(linha[1]);
            	int peso = Integer.parseInt(linha[0]);
            	Item item = new Item(peso, valor);
            	itens.add(item);	
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itens;
	}

}
