package com.ale.bookservice.controller;

import com.ale.bookservice.model.Book;
import com.ale.bookservice.proxy.CambioProxy;
import com.ale.bookservice.repository.BookRepository;
import com.ale.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("bookservice")
public class BookController {

    @Autowired
    private Environment environment;

    private String lara = "";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var book = new Book();
        var bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()){
            throw new RuntimeException("Book not Found");
        } else book = bookOptional.get();

        var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);

        book.setEnvironment(environment.getProperty("local.server.port") + "FEIGN");
        book.setPrice(cambio.getConvertedValeu());
        return book;
    }


/*
Como era a requisição usando restTemplate, agora irei usar feign
 @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var book = new Book();
        var bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()){
            throw new RuntimeException("Book not Found");
        } else book = bookOptional.get();

        var params = new HashMap<String, String>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().getForEntity(
                "http://localhost:8001/cambio-service/{amount}/{from}/{to}",
                Cambio.class,
                params);

        var cambio = response.getBody();

        book.setEnvironment(environment.getProperty("local.server.port"));
        book.setPrice(cambio.getConvertedValeu());
        return book;
    }

 */

}
