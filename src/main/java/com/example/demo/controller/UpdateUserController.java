package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UpdateUserDAO;
import com.example.demo.model.UserModelIndex;

@Controller
public class UpdateUserController {
    @Autowired
    private UpdateUserDAO updateUserDAO;

    @GetMapping("/update/{id}")
    public String getMethodName(@PathVariable int id, Model model) {
        UserModelIndex user = updateUserDAO.showDetails(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PutMapping("/update/{id}")
    public String updateDatos(@PathVariable int id,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido) {
        UserModelIndex user = new UserModelIndex(id, nombre, apellido);
        updateUserDAO.updateUser(user);

        return "redirect:/";
    }
}
