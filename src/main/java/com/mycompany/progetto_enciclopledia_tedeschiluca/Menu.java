/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Studente
 */
    
public class Menu {

    private Scanner scanner;
    private List<Plants> listaPiante;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.listaPiante = new ArrayList<>();
    }

    public void start() {
        int scelta;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi pianta");
            System.out.println("2. Rimuovi pianta");
            System.out.println("3. Visualizza tutte le piante");
            System.out.println("4. Visualizza una pianta in una posizione specifica");
            System.out.println("5. Esporta i dati su un file CSV:");
            System.out.println("6. Importa i dati da un file CSV:");
            
            System.out.println("0. Esci");

            System.out.print("\nScelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); 

            switch (scelta) {
                case 1:
                    aggiungiPianta();
                    break;
                case 2:
                    rimuoviPianta();
                    break;
                case 3:
                    visualizzaTuttePiante();
                    break;
                case 4:
                    visualizzaPiantaPosizione();
                    break;
                case 5:
                    System.out.print("Inserisci il nome del file CSV di destinazione: ");
                    String exportFileName = scanner.nextLine();
                    SalvaSuFile.EsportaSuCsv(listaPiante, exportFileName);
                    break;
                case 6:
                    System.out.print("Inserisci il nome del file CSV di origine: ");
                    String importFileName = scanner.nextLine();
                    listaPiante = SalvaSuFile.ImportaSuCsv(importFileName);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("\nScelta non valida. Riprova.");
                    break;
            }
        } while (scelta != 0);
    }

    private void aggiungiPianta() {
        System.out.println("\nAggiungi una nuova pianta:");
        
        System.out.println("Inserisci il nome della pianta:");
        String nome = scanner.nextLine();
        
        System.out.println("Inserisci il nome scientifico della pianta:");
        String nome_scientifico = scanner.nextLine();
        
        System.out.println("Inserisci l'area di crescita della pianta:");
        String areaDiCrescita = scanner.nextLine();
        
        System.out.println("Inserisci le caratteristiche generali della pianta:");
        String caratteristicheGenerali = scanner.nextLine();
        
        System.out.println("Inserisci gli anni della pianta:");
        int anniPianta = scanner.nextInt();
        scanner.nextLine(); 

        Plants nuovaPianta = new Plants(nome, nome_scientifico, areaDiCrescita, caratteristicheGenerali, anniPianta);
        listaPiante.add(nuovaPianta);
        System.out.println("Pianta aggiunta con successo!");
    }

    private void rimuoviPianta() {
        System.out.println("\nRimuovi una pianta:");
        System.out.println("Inserisci l'indice della pianta da rimuovere:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        if (indice >= 0 && indice < listaPiante.size()) {
            Plants piantaRimossa = listaPiante.remove(indice);
            System.out.println("Pianta rimossa con successo: " + piantaRimossa);
        } else {
            System.out.println("Indice non valido. Nessuna pianta rimossa.");
        }
    }

    private void visualizzaTuttePiante() {
        System.out.println("\nElenco di tutte le piante:");
        for (int i = 0; i < listaPiante.size(); i++) {
            System.out.println("Posizione " + i + ": " + listaPiante.get(i));
        }
    }

    private void visualizzaPiantaPosizione() {
        System.out.println("\nVisualizza una pianta in una posizione specifica:");
        System.out.println("Inserisci l'indice della pianta da visualizzare:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        if (indice >= 0 && indice < listaPiante.size()) {
            System.out.println("Pianta alla posizione " + indice + ": " + listaPiante.get(indice));
        } else {
            System.out.println("Indice non valido. Nessuna pianta visualizzata.");
        }
    }
}
