package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IndexDAO;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        IndexDAO show = new IndexDAO();
        show.getAllUsers();
        return "hello";
    }
}
