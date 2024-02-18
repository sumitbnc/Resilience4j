package com.example.demo.controller;

import com.example.demo.services.StoreService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@Slf4j
public class StoreController {

    public static final String STORE_RATE_LIMITER = "storeRateLimiter";

    @Autowired
    StoreService storeService;


    @GetMapping("/getAllStores")
    public String getAllStores(){
        return "testString";
    }


    @GetMapping("/{storeId}")
    @RateLimiter(name = STORE_RATE_LIMITER, fallbackMethod = "defaultResponseInCaseOfOverheadApiCalls")
    public ResponseEntity<String> getStoreDetails(@PathVariable("storeId") String storeId){
        return new ResponseEntity<>(storeService.getStoreDetails(storeId), HttpStatus.OK);

    }

    public ResponseEntity<String> defaultResponseInCaseOfOverheadApiCalls(String storeId, RequestNotPermitted requestNotPermitted) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Response.tooManyRequests(TOO_MANY_REQUESTS)", HttpStatus.TOO_MANY_REQUESTS);
        log.error("Too Many Request Occured for notification : {} ", storeId, requestNotPermitted);
        return responseEntity;
    }
}
