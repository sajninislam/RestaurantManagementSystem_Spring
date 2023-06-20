//package com.example.Api.controller;
//
//import com.example.Api.model.ProductInformation;
//import com.example.Api.service.ProductInformationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/courier")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
//
//
//public class ProductInformatiomController {
//
//    @Autowired
//    ProductInformationService p_service;
//
//    @PostMapping("/Postcourier")
//    public void newPost(@RequestBody ProductInformation product, @RequestParam(value = "userName") String username) {
//        p_service.saveProduct(product, username);
//    }
//
//    @GetMapping("/getCourierList")
//    public List<ProductInformation> getAll(@RequestParam(value = "orderStatus", required = false) String orderStatus, @RequestParam(value = "userName", required = false) String username ){
//        return p_service.getAlls(orderStatus,username);
//    }
//
//    @PutMapping("/Update")
//    public void update(@RequestBody ProductInformation product, @RequestParam(value = "userName") String username){
//        p_service.saveProduct(product, username);
//    }
//
//
//
//    @DeleteMapping("/{id}")
//    public void deletedProduct(@PathVariable("id") Long id){
//        p_service.deleteProduct(id);
//
//    }
//
//
//}
