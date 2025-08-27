package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dao.RegistraitionDAO;
import com.example.demo.model.RegistrationModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistraitionController {

    @GetMapping("/registration")
    public String showRegistraition(org.springframework.ui.Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String RegistrationUser(@ModelAttribute("user") RegistrationModel user) {       

        RegistraitionDAO reg = new RegistraitionDAO();
        reg.registration(user.getNombre(),user.getApellido(),user.getNumeroSedula(),user.getCorreo(),user.getIdRol(),user.getFechaIngreso(),user.getContasena(),user.getTelefono(),user.getEquipo(),user.getCargo(),user.getFechaDeNacimento(),user.getDiasVacacionesRestante(),user.getRequiereCambioContrasena());

        
        return "redirect:/";
    }
    
}
