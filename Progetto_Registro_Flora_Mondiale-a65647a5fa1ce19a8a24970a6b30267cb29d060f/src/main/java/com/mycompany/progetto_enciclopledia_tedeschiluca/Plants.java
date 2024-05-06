/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Plants implements Serializable {
    
    private String nome;
    private String nome_scentifico;
    private String areaDiCrescita;
    private String caratteristicheGenerali;
    private int anniPianta;
    private Scanner scanner;
    private List<Plants> listaPiante;
    
    public Plants(String nome, String nome_scentifico, String areaDiCrescita, String caratteristicheGenerali, int anniPianta)
    {
        this.nome = nome;
        this.nome_scentifico = nome_scentifico;
        this.areaDiCrescita = areaDiCrescita;
        this.caratteristicheGenerali = caratteristicheGenerali;
        this.anniPianta = anniPianta;
        this.scanner = new Scanner(System.in);
        this.listaPiante = new ArrayList<>();
    }

    public String getNome()
    {
        return nome;
    }

    public String getNomeScientifico()
    {
        return nome_scentifico;
    }

    public String getAreaDiCrescita()
    {
        return areaDiCrescita;
    }

    public String getCaratteristicheGenerali()
    {
        return caratteristicheGenerali;
    }

    public int getAnniPianta()
    {
        return anniPianta;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setNomeScientifico(String nome_scentifico)
    {
        this.nome_scentifico = nome_scentifico;
    }

    public void setAreaDiCrescita(String areaDiCrescita)
    {
        this.areaDiCrescita = areaDiCrescita;
    }

    public void setCaratteristicheGenerali(String caratteristicheGenerali)
    {
        this.caratteristicheGenerali = caratteristicheGenerali;
    }

    public void setAnniPianta(int anniPianta)
    {
        this.anniPianta = anniPianta;
    }

    public String toString()
    {
        return "Nome:" + nome + "\nNome scientifico: " + nome_scentifico + "\nArea di crescita: " + areaDiCrescita + "\nCaratteristiche generali: " + caratteristicheGenerali + "\nAnni pianta: " + anniPianta;
    }

    public void aggiungiPianta(Scanner scanner, List<Plants> listaPiante) {
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

    public void rimuoviPianta(List<Plants> listaPiante, Scanner scanner) {
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

    public void visualizzaTuttePiante(List<Plants> listaPiante) {
        System.out.println("\nElenco di tutte le piante:");
        for (int i = 0; i < listaPiante.size(); i++) {
            System.out.println("Posizione " + i + ": " + listaPiante.get(i));
        }
    }

    public void visualizzaPiantaPosizione(List<Plants> listaPiante, Scanner scanner) {
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

    public static void ordinaPiantePerNome(List<Plants> piante) {
        Collections.sort(piante, (p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
    }
    
    
     public void serializza(String nomeFile) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            out.writeObject(this);
            System.out.println("Serializzazione completata con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la serializzazione: " + e.getMessage());
        }
    }

     
     public static Plants deserializza(String nomeFile) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile))) {
            Plants pianta = (Plants) in.readObject();
            System.out.println("Deserializzazione completata con successo.");
            return pianta;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la deserializzazione: " + e.getMessage());
            return null;
        }
    }
    
    
}


    
    
    
    
    
    
    
    
    
    

