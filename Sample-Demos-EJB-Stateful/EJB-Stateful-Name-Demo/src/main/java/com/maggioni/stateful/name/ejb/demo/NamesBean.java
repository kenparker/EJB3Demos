package com.maggioni.stateful.name.ejb.demo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class NamesBean {
    
    private List<String> names;
    
    @PostConstruct
    private void initialize() {
        names = new ArrayList<>();
    }
    
    public void addName(String name) {
        names.add(name);
    }
    
    public List<String> getNames() {
        return names;
    }
}
