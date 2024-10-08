package com.ale.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("bookservice")
public class FooBarController {

    private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/foo-bar")
//    @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker( name = "foo-bar", fallbackMethod = "fallbackMethod")
    @RateLimiter( name = "default")
    @Bulkhead( name = "default")
    public String fooBar() {
        logger.info("Request to foo-bar is received!");
//        var response = new RestTemplate()
//                .getForEntity("http://localhost:8080/foo-bar", String.class);
        return "Foo-Bar";
//        return response.getBody();
    }

    public String fallbackMethod(Exception ex) {
        return "fallbackMethod foo-bar!!!";
    }

}
