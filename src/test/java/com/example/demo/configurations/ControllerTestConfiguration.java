package com.example.demo.configurations;

import com.example.demo.services.StoreService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
public class ControllerTestConfiguration {

    @Bean
    public StoreService getStoreService(){
        return new StoreService();
    }
}
