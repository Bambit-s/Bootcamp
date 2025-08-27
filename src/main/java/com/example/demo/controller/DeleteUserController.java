package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.DeleteUserDAO;

@Controller
public class DeleteUserController {

    @DeleteMapping("/usuario/delete/{id}")
    public String DeleteUser(@PathVariable int id) {
        DeleteUserDAO del = new DeleteUserDAO();
        del.deleteUser(id);
        return "redirect:/";
    }

}
