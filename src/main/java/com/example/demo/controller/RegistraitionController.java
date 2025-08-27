package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dao.RegistraitionDAO;
import com.example.demo.model.RegistrationModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistraitionController {

    // @Autowired
    // private RegistraitionDAO registraitionDAO;

    @GetMapping("/registration")
    public String showRegistraition(org.springframework.ui.Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String RegistrationUser(@ModelAttribute("user") RegistrationModel user) {       
        
        System.out.println(user.getNombre());
        System.out.println(user.getApellido());
        System.out.println(user.getNumeroSedula());
        System.out.println(user.getCorreo());
        System.out.println(user.getIdRol());
        System.out.println(user.getFechaIngreso());
        System.out.println(user.getAntiguedad());
        System.out.println(user.getDiasVacaciones());
        System.out.println(user.getEstado());
        System.out.println(user.getContasena());
        System.out.println(user.getTelefono());
        System.out.println(user.getEquipo());
        System.out.println(user.getCargo());
        System.out.println(user.getFechaDeNacimento());
        System.out.println(user.getDiasVacacionesRestante());
        System.out.println(user.getDiasVacacionesRestante());
        System.out.println(user.getRequiereCambioContrasena());
        


        RegistraitionDAO reg = new RegistraitionDAO();
        reg.registration(user.getNombre(),user.getApellido(),user.getNumeroSedula(),user.getCorreo(),user.getIdRol(),user.getFechaIngreso(),user.getContasena(),user.getTelefono(),user.getEquipo(),user.getCargo(),user.getFechaDeNacimento(),user.getDiasVacacionesRestante(),user.getRequiereCambioContrasena());

        
        return "index";
    }
    
}
