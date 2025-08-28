// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.dao.DeleteUserDAO;
// import com.example.demo.dao.IndexDAO;
// import com.example.demo.model.UserModelIndex;

// // @Controller
// // public class DeleteUserController {

// //     @DeleteMapping("/usuario/delete/{id}")
// //     public String DeleteUser(@PathVariable int id) {
// //         DeleteUserDAO del = new DeleteUserDAO();
// //         del.deleteUser(id);
// //         return "redirect:/";
// //     }

// // }
// @RestController
// public class DeleteUserController {

//     @Autowired
//     private DeleteUserDAO deleteUserDAO;

//     @DeleteMapping("/usuario/delete/{id}")
//     public boolean DeleteUser(@PathVariable int id) {
//         return deleteUserDAO.deleteUser(id);
//     }

// }

