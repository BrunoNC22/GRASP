package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha1 = bufferedReader.readLine();
            
            mochila.setCapacidade(Integer.parseInt(linha1));

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return mochila;
	}
	
	public List<Item> crateItens() throws FileNotFoundException {
		List<Item> itens = new ArrayList<Item>();
	
		
		File arquivo = new File(this.caminhoDoArquivo);

        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = bufferedReader.readLine();
            
            int qtdItens = Integer.parseInt(bufferedReader.readLine());
 
            String[] linhas;
            
            for (int cont = 0; cont < qtdItens; cont++) {
            	linhas = bufferedReader.readLine().split(" ");
            	int peso = Integer.parseInt(linhas[0]);
            	float valor = Float.parseFloat(linhas[1]);
            	Item item = new Item(peso, valor);
            	itens.add(item);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itens;
	}

}
