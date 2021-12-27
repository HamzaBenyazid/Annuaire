package com.jee.annuaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Associer")
public class AssocierServet extends HttpServlet {
    Facade facade;

    @Override
    public void init() throws ServletException {
        try {
            facade = new Facade();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/associer.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int personId = Integer.parseInt(req.getParameter("personne"));
        int adresseId = Integer.parseInt(req.getParameter("adresse"));
        System.out.println(personId+" "+adresseId);
        try {
            facade.associer(personId,adresseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Associer");
    }
}
