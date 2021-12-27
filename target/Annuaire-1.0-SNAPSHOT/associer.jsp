<%@ page import="com.jee.annuaire.Facade" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.jee.annuaire.Adresse" %>
<%@ page import="com.jee.annuaire.Personne" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hamza
  Date: 12/26/21
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/Associer" method="post">
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
        <h3>Choisir la personne</h3>
        <% for( Personne personne : personnes){%>
        <input type="radio" id="personne-<%=personne.getPersonneId()%>" name="personne" value="<%=personne.getPersonneId()%>">
        <label for="personne-<%=personne.getPersonneId()%>"><%=personne.getNom()+" "+personne.getPrenom()%></label><br>
        <%}%>
        <h3>Choisir l'adresse</h3>
        <% for( Adresse adresse : adresses){%>
        <input type="radio" id="adresse-<%=adresse.getAdresseId()%>" name="adresse" value="<%=adresse.getAdresseId()%>">
        <label for="adresse-<%=adresse.getAdresseId()%>"><%=adresse.getRue()+" "+adresse.getVille()%></label><br>
        <% } %>
        <input type="submit" value="OK">

    </form>
</body>
</html>
