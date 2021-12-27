package com.jee.annuaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Annuaire1/AjoutPersonne")
public class AjoutPersonneServlet extends HttpServlet {
    Facade facade;

    @Override
    public void init() {
        try {
            facade = new Facade();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        System.out.println(nom+" "+prenom);
        try {
            facade.ajoutPersonne(nom,prenom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Annuaire1/AjoutPersonne");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("/ajoutpersonne.html");
        rq.forward(req,resp);
    }
}
