/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class PlantsTest {

    @Test
    public void testAggiungiPianta() {
        List<Plants> listaPiante = new ArrayList<>();
        Plants pianta = new Plants("Pianta1", "Scientifico1", "Area1", "Caratteristiche1", 5);
        
        // Aggiungi la pianta alla lista
        listaPiante.add(pianta);
        
        // Verifica che la lista contenga la pianta aggiunta
        assertEquals(1, listaPiante.size());
        assertEquals("Pianta1", listaPiante.get(0).getNome());
    }

    @Test
    public void testRimuoviPianta() {
        List<Plants> listaPiante = new ArrayList<>();
        Plants pianta = new Plants("Pianta1", "Scientifico1", "Area1", "Caratteristiche1", 5);
        listaPiante.add(pianta);
        
        // Rimuovi la pianta dalla lista
        listaPiante.remove(0);
        
        // Verifica che la lista sia vuota dopo la rimozione
        assertTrue(listaPiante.isEmpty());
    }

    @Test
    public void testVisualizzaTuttePiante() {
        List<Plants> listaPiante = new ArrayList<>();
        Plants pianta1 = new Plants("Pianta1", "Scientifico1", "Area1", "Caratteristiche1", 5);
        Plants pianta2 = new Plants("Pianta2", "Scientifico2", "Area2", "Caratteristiche2", 3);
        Plants pianta3 = new Plants("Pianta3", "Scientifico3", "Area3", "Caratteristiche3", 7);
        
        listaPiante.add(pianta1);
        listaPiante.add(pianta2);
        listaPiante.add(pianta3);
        
        // Verifica che la lista contenga tutte le piante aggiunte
        assertEquals(3, listaPiante.size());
        assertEquals("Pianta1", listaPiante.get(0).getNome());
        assertEquals("Pianta2", listaPiante.get(1).getNome());
        assertEquals("Pianta3", listaPiante.get(2).getNome());
    }

    // Aggiungi altri test per gli altri metodi della classe Plants
}
