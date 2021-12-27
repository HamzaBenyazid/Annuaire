package com.jee.annuaire;

public class Personne {
    int personneId;
    String nom;
    String prenom;

    public Personne(int personneId,String nom, String prenom) {
        this.personneId = personneId;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getPersonneId() {
        return personneId;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return nom+" "+prenom;
    }
}
