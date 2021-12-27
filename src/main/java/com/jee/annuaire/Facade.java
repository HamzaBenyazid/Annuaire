package com.jee.annuaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class Facade {

    Connection conn ;
    public Facade() throws SQLException, ClassNotFoundException {
        conn =Facade.initializeDatabase();
    }

    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/annuaire";
        String user = "admin";
        String password = "12345678";
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println("Database connected .");
        return conn;
    }
    public void ajoutPersonne(String nom, String prenom) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into personne values(Default ,?,?)");
        stmt.setString(1,nom);
        stmt.setString(2,prenom);
        stmt.executeUpdate();
    }
    public void ajoutAdresse(String rue, String ville) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into adresse values(Default ,?,?)");
        stmt.setString(1,rue);
        stmt.setString(2,ville);
        stmt.executeUpdate();
    }
    public Collection<Personne> listePersonnes() throws SQLException {
        Collection<Personne> personnes = new ArrayList<Personne>();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from personne");
        while(rs.next()){
            personnes.add(new Personne(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"))
            );
        }
        System.out.println(personnes);
        return personnes;
    }
    public Collection<Adresse> listeAdresses() throws SQLException {
        Collection<Adresse> adresses = new ArrayList<Adresse>();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from adresse");
        while(rs.next()){
            adresses.add(new Adresse(
                    rs.getInt("id"),
                    rs.getString("rue"),
                    rs.getString("ville"))
            );
        }
        System.out.println(adresses);
        return adresses;
    }
    public void associer(int personneId, int adresseId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into posseder values(?,?)");
        stmt.setInt(1,personneId);
        stmt.setInt(2,adresseId);
        stmt.executeUpdate();

    }
}
