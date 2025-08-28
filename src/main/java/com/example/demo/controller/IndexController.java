package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.IndexDAO;

import com.example.demo.model.UserModelIndex;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@Tag(name = "Users", description = "Crud users")
public class IndexController {

    @Autowired
    private IndexDAO indexDAO;

    // read /api/users Get
    @GetMapping("/api/users")
    @Operation(summary = "show all user", description = "filtred by rol, equipo, cargo")
    public List<UserModelIndex> getAllUsers(
            @RequestParam(required = false) Integer rol,
            @RequestParam(required = false) Integer equipo,
            @RequestParam(required = false) Integer cargo) {
        return indexDAO.getAllUsers(rol, equipo, cargo);
    }

    // read /api/users{id} Get
    @GetMapping("/api/users/{id}")
    @Operation(summary = "show one user", description = "you can put id to show info about user")
    public UserModelIndex getOneUser(@PathVariable int id) {
        return indexDAO.getOneUser(id);
    }

    // create /api/users Post   
    @PostMapping("/api/users")
    @Operation(summary = "create user", description = "you can put info to create user")
    public UserModelIndex createOneUser(@RequestBody UserModelIndex user) {
        return indexDAO.createOneUser(user);
    }

    // update /api/users/{id} Put
    @PutMapping("/api/users/{id}")
    @Operation(summary = "update user", description = "you can put info to update user")
    public UserModelIndex updateOneUser(@PathVariable int id,
            @RequestBody UserModelIndex user) {
        user.setId_usuario(id);
        return indexDAO.updateOneUser(user);
    }

    // delete /api/users/{id} Delete
    @DeleteMapping("/api/users/{id}")
    @Operation(summary = "delete user", description = "you can put id to delete user")
    public UserModelIndex deleteOneUser(@PathVariable int id) {
        return indexDAO.deleteOneUser(id);
    }

}
