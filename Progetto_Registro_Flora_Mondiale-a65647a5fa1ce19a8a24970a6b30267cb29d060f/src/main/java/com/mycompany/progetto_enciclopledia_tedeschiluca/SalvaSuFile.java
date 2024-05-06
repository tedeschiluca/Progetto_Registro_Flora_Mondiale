/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;


import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucat
 */
public class SalvaSuFile {
    
    public static void EsportaSuCsv(List<Plants> plants, String fileName) {
        
        LocalDateTime now = LocalDateTime.now();
        String oraEsportazione = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nome, Nome Scientifico, Area di Crescita, Caratteristiche Generali, Anni della Pianta");
            sb.append("\n");

            for (Plants plant : plants) {
                sb.append(plant.getNome()).append(",");
                sb.append(plant.getNomeScientifico()).append(",");
                sb.append(plant.getAreaDiCrescita()).append(",");
                sb.append(plant.getCaratteristicheGenerali()).append(",");
                sb.append(plant.getAnniPianta());
                sb.append("\n");
            }

            writer.write(sb.toString());
            System.out.println("Dati esportati con successo su " + fileName);
            System.out.println("Dati esportati su file CSV '" + fileName + "' all'ora: " + oraEsportazione);
        } catch (FileNotFoundException e) {
            System.out.println("Errore: file non trovato");
        }
    }

    public static List<Plants> ImportaSuCsv(String fileName) {
        
        LocalDateTime now = LocalDateTime.now();
        String oraImportazione = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        List<Plants> plants = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine(); // Skip header
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] attributes = line.split(",");
                Plants plant = new Plants(attributes[0], attributes[1], attributes[2], attributes[3], Integer.parseInt(attributes[4]));
                plants.add(plant);
            }
            System.out.println("Dati importati con successo da " + fileName);
            System.out.println("Dati importati dal file CSV '" + fileName + "' all'ora: " + oraImportazione);
        } catch (FileNotFoundException e) {
            System.out.println("Errore: file non trovato");
        }
        return plants;
    }
}
    

