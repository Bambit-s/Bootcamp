package com.roshka.bootcamp.controller;

import com.roshka.bootcamp.dao.loginpagedao;
import com.roshka.bootcamp.model.loginpagemodel;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

//
public class loginpagecontroller extends HttpServlet {
    private Connection connection;

    public void init(ServletConfig config) {
        try {
            ServletContext context = config.getServletContext();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    context.getInitParameter("dbUrl"),
                    context.getInitParameter("dbUser"),
                    context.getInitParameter("dbPassword"));
        } catch (Exception e) {
            throw new RuntimeException("Error initializing database connection", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String nro_cedula = req.getParameter("nro_cedula");
        String telefono = req.getParameter("telefono");

        try {
            loginpagedao IndexDAO = new loginpagedao(connection);
            loginpagemodel user = IndexDAO.loginuser(nombre, apellido, nro_cedula, telefono);
            // System.out.println(user.getApellido());
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, res);
            } else {
                // req.setAttribute("error", "Usuario no encontrado");
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, res);
            }

        } catch (Exception e) {
            throw new ServletException("Error checking user", e);
        }
    }

    public void destroy() {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception ignored) {
        }
    }
}
