package com.iesemilidarder.projectzero.web;

import com.iesemilidarder.projectzero.core.ReadDB;
import com.iesemilidarder.projectzero.core.Restaurantes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowRestaurantsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        request.getParameter("id");

        Restaurantes rst = null;

        out.println("id = " + request.getParameter("id"));

        ReadDB readDB = new ReadDB();
        readDB.readRestaurantes( request.getParameter("id"));
    }
    }