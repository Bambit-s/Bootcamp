package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.IndexDAO;

import com.example.demo.model.UserModelIndex;
import org.springframework.ui.Model;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class IndexController {

    @Autowired
    private IndexDAO indexDAO;

    // @GetMapping("/")
    // public String index(Model model) {
    //     List<UserModelIndex> users = indexDAO.getAllUsers();
    //     model.addAttribute("users", users);
    //     model.addAttribute("pageTitle", "Main");
    //     return "index";
    // }
    @GetMapping("/api/users")
    public List<UserModelIndex> getAllUsers() {
        return indexDAO.getAllUsers();
    }
    
}
