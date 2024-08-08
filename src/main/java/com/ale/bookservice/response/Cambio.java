package com.ale.bookservice.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.lang.Double;
import java.util.Objects;

public class Cambio implements Serializable {

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValeu;
    private String environment;

    public Cambio() {}

    public Cambio(Long id, String from, String to, Double conversionFactor, Double convertedValeu, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValeu = convertedValeu;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValeu() {
        return convertedValeu;
    }

    public void setConvertedValeu(Double convertedValeu) {
        this.convertedValeu = convertedValeu;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cambio cambio)) return false;
        return Objects.equals(getId(), cambio.getId()) && Objects.equals(getFrom(), cambio.getFrom()) && Objects.equals(getTo(), cambio.getTo()) && Objects.equals(getConversionFactor(), cambio.getConversionFactor()) && Objects.equals(getConvertedValeu(), cambio.getConvertedValeu()) && Objects.equals(getEnvironment(), cambio.getEnvironment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getConversionFactor(), getConvertedValeu(), getEnvironment());
    }
}
