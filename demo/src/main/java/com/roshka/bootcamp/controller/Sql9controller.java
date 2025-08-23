package com.roshka.bootcamp.controller;

import com.roshka.bootcamp.dao.Sql9dao;
import com.roshka.bootcamp.model.Sql9model;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/sql9")
public class Sql9controller extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Sql9dao clienteDAO = new Sql9dao(connection);
            List<Sql9model> clientes = clienteDAO.obtenerTopClientes();

            req.setAttribute("clientes", clientes);
            req.getRequestDispatcher("/WEB-INF/views/Sql9view.jsp").forward(req, res);

        } catch (Exception e) {
            throw new RuntimeException("Error processing request", e);
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
