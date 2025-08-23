package com.roshka.bootcamp.controller;

import com.roshka.bootcamp.dao.Sql6dao;
import com.roshka.bootcamp.model.Sql6model;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@WebServlet("/sql6")
public class Sql6controller extends HttpServlet {
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
            Sql6dao clienteDAO = new Sql6dao(connection);
            List<Sql6model> clientes = clienteDAO.obtenerTopClientes();

            req.setAttribute("clientes", clientes);
            req.getRequestDispatcher("/WEB-INF/views/Sql6view.jsp").forward(req, res);

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
