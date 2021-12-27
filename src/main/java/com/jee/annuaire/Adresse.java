package com.jee.annuaire;

public class Adresse {
    int adresseId;
    String rue;
    String ville;

    public Adresse(int adresseId, String rue, String ville) {
        this.adresseId = adresseId;
        this.rue = rue;
        this.ville = ville;
    }

    public int getAdresseId() {
        return adresseId;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return rue+" "+ville;
    }
}
