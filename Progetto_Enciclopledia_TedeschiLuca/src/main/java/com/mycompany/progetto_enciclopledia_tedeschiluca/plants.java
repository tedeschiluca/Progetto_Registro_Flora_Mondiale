/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_enciclopledia_tedeschiluca;

/**
 *
 * @author lucat
 */
public class plants {
    
    private String nome;
    private String nome_scentifico;
    private String areaDiCrescita;
    private String caratteristicheGenerali;
    private int anniPianta;
    
    //Costruttore
    
    public plants(String nome, String nome_scentifico, String areaDiCrescita, String caratteristicheGenerali, int anniPianta)
    {
        this.nome = nome;
        this.nome_scentifico = nome_scentifico;
        this.areaDiCrescita = areaDiCrescita;
        this.caratteristicheGenerali = caratteristicheGenerali;
        this.anniPianta = anniPianta;
        
    }
    
    //Getter
    
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
    
    public int anniPianta()
    {
        return anniPianta;
    }
    
    //Setter
    
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
    
    
    
    //utilizzo l'override per rendere più semplice le informazioni sull'oggetto pianta, combinando tutte le informazioni in un'unica stringa
    
   
    public String toString()
    {
        return "Nome:" + nome + "\nNome scientifico: " + nome_scentifico + "\nArea di crescita: " + areaDiCrescita + "\nCaratteristiche generali: " + caratteristicheGenerali + "\nAnni pianta: " + anniPianta;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
