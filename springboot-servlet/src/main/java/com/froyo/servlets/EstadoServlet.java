package com.froyo.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Froy
 */
@WebServlet(urlPatterns = "/app/estado/*", loadOnStartup = 1)
public class EstadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.getSession();
        PrintWriter out = response.getWriter();
        out.println("<h3>Jalisco</h3>");
        out.println("User: " + request.getServletContext().getAttribute("user"));
        out.println("</br>");
        out.println("Name: " + request.getServletContext().getAttribute("name"));
        out.println("</br>");
        out.println("Dato: " + request.getServletContext().getAttribute("dato"));
    }
}
