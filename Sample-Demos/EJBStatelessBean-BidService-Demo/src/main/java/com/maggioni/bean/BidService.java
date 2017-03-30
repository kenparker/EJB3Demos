package com.maggioni.bean;

import com.maggioni.model.Bid;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class BidService {

    @PostConstruct
    public void init() {

    }

    public void addBid(Bid bid) {
    }

    public Bid getBid(Long id) {
        return new Bid(id,"hello "+id);
    }
    
    public void cancelBid(Bid bid) {
    }

    public List<Bid> getBids() {
        return null;
    }

    @PreDestroy
    public void cleanUp() {
    }
}
