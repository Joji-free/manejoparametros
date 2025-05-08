package com.anderson.parametros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/manejoparametros/url-get")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //Cpturamos los datos del index.html
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Manejo parametros GET</title>");
        out.println("</head>");
        out.println("<body>");
        if (saludo != null && nombre != null) {
            out.println("<h2>El saludo enviado es : " + saludo + " "+ nombre +"</h2>");
        } else if (saludo != null) {
            out.println("El saludo enviado es : " + saludo);
        }else if (nombre != null) {
            out.println("<h2>Hola mi nombre es : " + nombre +"</h2>");
        }else{
            out.println("<h2>No se pasaron ni el saludo ni el nombre</h2>");
        }

        //Validamos que el codigo sea un numero
        try{
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h2>El codigo es: " + codigo +"</h2>");
        }catch(NumberFormatException e){
            out.println("<h3>El codigo enviado es, null</h3>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
