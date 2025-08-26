package com.roshka.bootcamp.controller;

import com.roshka.bootcamp.dao.facturadao;
import com.roshka.bootcamp.model.facturamodel;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/factura")
public class facturacontroller extends HttpServlet {
    private Connection connection;

    public void init(ServletConfig config) throws ServletException {
        try {
            ServletContext context = config.getServletContext();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    context.getInitParameter("dbUrl"),
                    context.getInitParameter("dbUser"),
                    context.getInitParameter("dbPassword"));
        } catch (Exception e) {
            throw new ServletException("Error initializing database connection", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/factura.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            res.sendRedirect(req.getContextPath() + "/loginpage");
            return;
        }

        int user_id = (int) session.getAttribute("userId");
        
        java.sql.Date fecha_emision = java.sql.Date.valueOf(req.getParameter("fecha_emision"));

        java.sql.Date fecha_vencimiento = java.sql.Date.valueOf(req.getParameter("fecha_vencimiento"));

        int factura_tipo = Integer.parseInt(req.getParameter("factura_tipo_id"));

        int moneda = Integer.parseInt(req.getParameter("moneda_id"));

        int producto = Integer.parseInt(req.getParameter("producto_id"));

        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        
        try {
            facturadao facturaDAO = new facturadao(connection);
            facturamodel factura = facturaDAO.postfactura(user_id, fecha_emision, fecha_vencimiento, factura_tipo, moneda, producto, cantidad);

            if (factura != null) {
                req.getRequestDispatcher("/WEB-INF/views/factura.jsp").forward(req, res);
            } else {
                req.setAttribute("error", "factura no encontrado");
                req.getRequestDispatcher("/WEB-INF/views/factura.jsp").forward(req, res);
            }

        } catch (Exception e) {
            throw new ServletException("Error checking factura", e);
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