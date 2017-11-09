/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isetjb.projet12onetomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
/**
 *
 * @author MALEK
 */
@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    
     @Column(name = "mat", length = 255, nullable = true)
    private String mat;

    @Column(name = "coleur", length = 255, nullable = true)
    private String coleur;
    
     @OneToMany(cascade = CascadeType.ALL)
    private List<Contrat> contrats = new ArrayList<>();
     
     // Bidirectionnel mode :
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "voitures")
    private List<Etiquette> etiquettes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getColeur() {
        return coleur;
    }

    public void setColeur(String coleur) {
        this.coleur = coleur;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public List<Etiquette> getEtiquettes() {
        return etiquettes;
    }

    public void setEtiquettes(List<Etiquette> etiquettes) {
        this.etiquettes = etiquettes;
    }

    
}
