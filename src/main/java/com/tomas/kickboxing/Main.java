package com.tomas.kickboxing;

import com.tomas.kickboxing.api.ApiSportsClient;
import com.tomas.kickboxing.model.Fighter;
import com.tomas.kickboxing.service.RankingService;

import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do programa.
 * Demonstra a instanciação de objetos, uso de coleções, tratamento de exceções e interação com outras classes.
 */
public class Main {
    public static void main(String[] args) {
        // Instanciação de objetos (Classes e Objetos)
        Scanner scanner = new Scanner(System.in);
        ApiSportsClient apiClient = new ApiSportsClient();
        RankingService rankingService = new RankingService();
        System.out.println("=== Kickboxing Fighter Ranker ===");
        System.out.print("Digite o nome (ou parte do nome) do lutador: ");
        String search = scanner.nextLine();
        try {
            // Uso de coleção (List) para armazenar múltiplos objetos (Coleções e Estruturas de Dados)
            List<Fighter> fighters = apiClient.getFighters(search);
            if (fighters.isEmpty()) {
                System.out.println("Nenhum lutador encontrado.");
                return;
            }
            // Polimorfismo: rankingService pode trabalhar com diferentes implementações de listas de lutadores
            rankingService.rankFighters(fighters);
            System.out.println("\nRanking:");
            int pos = 1;
            // Uso de laço para iterar sobre coleção de objetos
            for (Fighter f : fighters) {
                // Polimorfismo: método toString() sobrescrito em Fighter
                System.out.printf("%d. %s\n", pos++, f);
            }
        } catch (Exception e) {
            // Tratamento de Exceções: captura e tratamento de erros
            System.out.println("Erro ao buscar lutadores: " + e.getMessage());
        }
    }
}
