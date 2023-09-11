package app;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entities.Item;
import entities.Mochila;
import utilities.ArchiveReader;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {

		String nomeDoArquivo = "mock.txt";
		Path path = Paths.get(System.getProperty("user.dir"), nomeDoArquivo);
		ArchiveReader ar = new ArchiveReader(path.toString());
		List<Item> items = ar.crateItens();
		Mochila mochila = ar.createMochila();
        int iteracoes = 20;
        mochila.setItens(graspMochila(items, mochila.getCapacidade(), iteracoes));
        for (Item item : mochila.getItens()) {
            System.out.println("Item - Valor: " + item.getValor() + ", Peso: " + item.getPeso());
        }
        System.out.println("Valor total: " + mochila.getValorTotal());
        System.out.println("Peso total: " + mochila.getPesoAtual());
    }

    public static List<Item> graspMochila(List<Item> items, int pesoMaximo, int iteracoes) {
        List<Item> melhorSolucao = new ArrayList<>();
        int melhorValor = 0;

        for (int i = 0; i < iteracoes; i++) {
            List<Item> solucao = construcaoAleatoriaGulosa(items, pesoMaximo);
            int valorDaSolucao = calcularValorTotal(solucao);
            int pesoDaSolucao = calcularPesoTotal(solucao);

            if (valorDaSolucao > melhorValor && pesoDaSolucao <= pesoMaximo) {
                melhorSolucao = new ArrayList<>(solucao);
                melhorValor = valorDaSolucao;
            }
        }
        return melhorSolucao;
    }

    public static List<Item> construcaoAleatoriaGulosa(List<Item> items, int maxWeight) {
    	List<Item> solucao = new ArrayList<>();
        List<Item> itensRestates = new ArrayList<>(items);
        while (!itensRestates.isEmpty()) {
            double alpha = 0.5; // Parametro ajustavel
            List<Item> listaCandidata = new ArrayList<>();
            for (Item item : itensRestates) {
                if ((double) item.getValor() / item.getPeso() >= alpha) {
                    listaCandidata.add(item);
                }
            }
            if (listaCandidata.isEmpty()) {
                break;
            }
            int indexAleatorio = (int) (Math.random() * listaCandidata.size());
            Item itemAleatoriamenteSelecionado = listaCandidata.get(indexAleatorio);
            
            if (!(calcularPesoTotal(solucao) + itemAleatoriamenteSelecionado.getPeso() > maxWeight)) {
            	solucao.add(itemAleatoriamenteSelecionado);
            }
            itensRestates.remove(itemAleatoriamenteSelecionado);
        }
        return solucao;
    }

    public static int calcularValorTotal(List<Item> items) {
        int valorTotal = 0;
        for (Item item : items) {
            valorTotal += item.getValor();
        }
        return valorTotal;
    }

    public static int calcularPesoTotal(List<Item> items) {
        int pesoTotal = 0;
        for (Item item : items) {
            pesoTotal += item.getPeso();
        }
        return pesoTotal;
	}
}
