package com.iesemilidarder.projectzero.core;

import com.iesemilidarder.projectzero.core.ReadDB;
import com.iesemilidarder.projectzero.core.Restaurantes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Servlet;

/*
Aqui creamos el servlet ShowRestaurantsServlet con su clase y donde le decimos que lo que venga por Post lo redirija por Get
 */

public class ShowRestaurantsServlet extends HttpServlet implements Servlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
    Con la id de los resturantes se redirigira a la pagina mostrar.jsp y  aparecera el restaurante de la id elegida
     */
        Restaurantes restaurante = null;
        String id = request.getParameter("id");
        restaurante = ReadDB.readRestaurant(id);

        request.setAttribute("restaurante", restaurante);
        request.getRequestDispatcher("mostrar.jsp").forward( request, response );
    }
}