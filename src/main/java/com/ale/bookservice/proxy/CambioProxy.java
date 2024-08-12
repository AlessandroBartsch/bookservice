package com.ale.bookservice.proxy;

import com.ale.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cambioservice")
public interface CambioProxy {

    @GetMapping(value = "/cambioservice/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );

}
