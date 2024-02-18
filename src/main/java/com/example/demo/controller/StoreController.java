package com.example.demo.controller;

import com.example.demo.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;


    @GetMapping("/getAllStores")
    public String getAllStores(){
        return "testString";
    }


    @GetMapping("/{storeId}")
    public ResponseEntity<String> getStoreDetails(@PathVariable("storeId") String storeId){
        return new ResponseEntity<>(storeService.getStoreDetails(storeId), HttpStatus.OK);

    }
}
