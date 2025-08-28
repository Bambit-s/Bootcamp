package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
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
    // List<UserModelIndex> users = indexDAO.getAllUsers();
    // model.addAttribute("users", users);
    // model.addAttribute("pageTitle", "Main");
    // return "index";
    // }

    // read /api/users Get
    @GetMapping("/api/users")
    public List<UserModelIndex> getAllUsers() {
        return indexDAO.getAllUsers();
    }

    // read /api/users{id} Get
    @GetMapping("/api/users/{id}")
    public UserModelIndex getOneUser(@PathVariable int id) {
        return indexDAO.getOneUser(id);
    }

    // create /api/users Post
    @PostMapping("/api/users")
    public UserModelIndex createOneUser(@RequestBody UserModelIndex user) {
        return indexDAO.createOneUser(user);
    }

    // update /api/users/{id} Put
    @PutMapping("/api/users/{id}")
    public UserModelIndex updateOneUser(@PathVariable int id,
            @RequestBody UserModelIndex user) {
        user.setId_usuario(id);
        return indexDAO.updateOneUser(user);
    }

    // delete /api/users/{id} Delete
    @DeleteMapping("/api/users/{id}")
    public UserModelIndex deleteOneUser(@PathVariable int id) {
        return indexDAO.deleteOneUser(id);
    }

}
