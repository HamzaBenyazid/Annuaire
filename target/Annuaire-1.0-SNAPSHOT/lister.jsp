<%@ page import="com.jee.annuaire.Personne" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.jee.annuaire.Adresse" %>
<%@ page import="com.jee.annuaire.Facade" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: hamza
  Date: 12/26/21
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Collection<Personne> personnes=new ArrayList<>();
        Collection<Adresse> adresses=new ArrayList<>();
        try {
            Facade facade = new Facade();
            personnes = facade.listePersonnes();
            adresses = facade.listeAdresses();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    %>
    <h3>les personnes</h3>
    <% for( Personne personne : personnes){%>
    <p><%=personne.getNom()+" "+personne.getPrenom()%></p>
    <%}%>
    <h3>les adresses</h3>
    <% for( Adresse adresse : adresses){%>
    <p><%=adresse.getRue()+" "+adresse.getVille()%></p>
    <% } %>
</body>
</html>
