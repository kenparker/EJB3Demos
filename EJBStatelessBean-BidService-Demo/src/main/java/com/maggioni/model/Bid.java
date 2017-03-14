package com.maggioni.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Bid {
    private Long id;
    private String item;

    public Bid(Long id, String item) {
        this.id = id;
        this.item = item;
    }
    
    
    
}
