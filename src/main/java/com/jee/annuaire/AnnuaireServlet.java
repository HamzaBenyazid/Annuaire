package com.jee.annuaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Annuaire1/")
public class AnnuaireServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher rq = req.getRequestDispatcher("/index.html");
        rq.forward(req,resp);
    }
}
