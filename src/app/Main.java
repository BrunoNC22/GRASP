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
		Path path = Paths.get(System.getProperty("user.dir"), "mock.txt");
		
		ArchiveReader ar = new ArchiveReader(path.toString());
		
		List<Item> items = ar.crateItens();
		
		for (Item item : items) {
			System.out.println("valor: " + item.getValor() + " peso: " + item.getPeso());
		}

		
		Mochila mochila = ar.createMochila();
		
		
        int iterations = 10000;

        List<Item> bestSolution = graspMochila(items, mochila.getCapacidade(), iterations);

        int totalValue = 0;
        int totalWeight = 0;
        for (Item item : bestSolution) {
            totalValue += item.getValor();
            totalWeight += item.getPeso();
            System.out.println("Item - Value: " + item.getValor() + ", Weight: " + item.getPeso());
        }
        System.out.println("Valor total: " + totalValue);
        System.out.println("Peso total: " + totalWeight);
    }

    public static List<Item> graspMochila(List<Item> items, int maxWeight, int iterations) {
        List<Item> bestSolution = new ArrayList<>();
        int bestValue = 0;

        for (int i = 0; i < iterations; i++) {
            List<Item> solution = greedyRandomizedConstruction(items, maxWeight);
            int solutionValue = calculateTotalValue(solution);

            if (solutionValue > bestValue && calculateTotalWeight(solution) <= maxWeight) {
                bestSolution = new ArrayList<>(solution);
                bestValue = solutionValue;
            }
        }

        return bestSolution;
    }

    public static List<Item> greedyRandomizedConstruction(List<Item> items, int maxWeight) {
        List<Item> solution = new ArrayList<>();
        List<Item> remainingItems = new ArrayList<>(items);

        while (!remainingItems.isEmpty()) {
            double alpha = 0.5; // Adjustable parameter
            double randomValue = Math.random();

            List<Item> candidateList = new ArrayList<>();
            for (Item item : remainingItems) {
                if ((double) item.getValor() / item.getPeso() >= alpha) {
                    candidateList.add(item);
                }
            }

            if (candidateList.isEmpty()) {
                break;
            }

            int randomIndex = (int) (Math.random() * candidateList.size());
            Item selected = candidateList.get(randomIndex);
            
            if (calculateTotalWeight(solution) + selected.getPeso() > maxWeight) {
            	break;
            }
            
            solution.add(selected);
            
            remainingItems.remove(selected);
        }
        
        return solution;
    }

    public static int calculateTotalValue(List<Item> items) {
        int totalValue = 0;
        for (Item item : items) {
            totalValue += item.getValor();
        }
        return totalValue;
    }

    public static int calculateTotalWeight(List<Item> items) {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getPeso();
        }
        return totalWeight;
    
	}
	

}
