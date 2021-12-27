package com.jee.annuaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Annuaire1/AjoutAdresse")
public class AjoutAdresseServlet extends HttpServlet {
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
        String rue = req.getParameter("rue");
        String ville = req.getParameter("ville");
        System.out.println(rue+" "+ville);
        try {
            facade.ajoutAdresse(rue,ville);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Annuaire1/AjoutAdresse");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("/ajoutadresse.html");
        rq.forward(req,resp);
    }
}
