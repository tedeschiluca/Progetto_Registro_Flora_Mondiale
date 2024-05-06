/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Object ListaPiante;

    

    private Scanner scanner;
    private List<Plants> listaPiante;
    private Plants plants;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.listaPiante = new ArrayList<>();
        this.plants = new Plants("", "", "", "", 0); //i parametri sono vuoti perchè verranno inseriti dall'utente
    }
    
    
    //Creato per la classe Test
    
    public static Object getListaPiante() {
       return ListaPiante;
    }

    public void start() {
    int scelta = 0;
    do {
        System.out.println("\nMenu:");
        System.out.println("1. Aggiungi pianta");
        System.out.println("2. Rimuovi pianta");
        System.out.println("3. Visualizza tutte le piante");
        System.out.println("4. Visualizza una pianta in una posizione specifica");
        System.out.println("5. Esporta i dati su un file CSV:");
        System.out.println("6. Importa i dati da un file CSV:");
        System.out.println("7. Ordina piante per nome (ord. Alfabetico)");
        System.out.println("8. Serializza dati");
        System.out.println("9. Deserializza dati");
        System.out.println("0. Esci");

        System.out.print("\nScelta: ");
        String input = scanner.nextLine(); // Leggi l'input come stringa
        try {
            scelta = Integer.parseInt(input); // Converte la stringa in un intero
        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Inserisci un numero.");
            continue; // Salta il resto del ciclo e torna all'inizio
        }

        switch (scelta) {
            case 1:
                plants.aggiungiPianta(scanner, listaPiante);
                break;
            case 2:
                plants.rimuoviPianta(listaPiante, scanner);
                break;
            case 3:
                plants.visualizzaTuttePiante(listaPiante);
                break;
            case 4:
                plants.visualizzaPiantaPosizione(listaPiante, scanner);
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
            case 7:
                plants.ordinaPiantePerNome(listaPiante);
                System.out.println("Piante ordinate per nome.");
                break;
            case 8:
                plants.serializza(input);
                break;
            case 9:
                plants.deserializza(input);
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

   







    

}


