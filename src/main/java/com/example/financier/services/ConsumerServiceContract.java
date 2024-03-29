package com.example.financier.services;

import com.example.financier.payload.response.ConsumerDtos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("https://consumer-app-for-money-turn.herokuapp.com")
public interface ConsumerServiceContract {

    @GetMapping("/api/v2/consumerApp/getAllCosts")
    List<ConsumerDtos> getAllCosts();

}
