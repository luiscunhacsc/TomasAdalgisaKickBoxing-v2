package com.tomas.kickboxing;

import com.tomas.kickboxing.api.ApiSportsClient;
import com.tomas.kickboxing.model.Fighter;
import com.tomas.kickboxing.service.RankingService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiSportsClient apiClient = new ApiSportsClient();
        RankingService rankingService = new RankingService();
        System.out.println("=== Kickboxing Fighter Ranker ===");
        System.out.print("Digite o nome (ou parte do nome) do lutador: ");
        String search = scanner.nextLine();
        try {
            List<Fighter> fighters = apiClient.getFighters(search);
            if (fighters.isEmpty()) {
                System.out.println("Nenhum lutador encontrado.");
                return;
            }
            rankingService.rankFighters(fighters);
            System.out.println("\nRanking:");
            int pos = 1;
            for (Fighter f : fighters) {
                System.out.printf("%d. %s\n", pos++, f);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar lutadores: " + e.getMessage());
        }
    }
}
