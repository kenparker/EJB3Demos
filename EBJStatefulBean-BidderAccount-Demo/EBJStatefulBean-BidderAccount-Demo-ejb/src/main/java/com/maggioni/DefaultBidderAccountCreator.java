package com.maggioni;

import com.maggioni.model.BillingInfo;
import com.maggioni.model.BiographicalInfo;
import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.Stateful;

@Stateful(name = "BidderAccountCreator")
public class DefaultBidderAccountCreator implements BidderAccountCreator{

    @PostConstruct
    @PostActivate
    public void setUp() {
        
    }
    
    @Override
    public void addBillingInfo(BillingInfo billingInfo) {
        
    }

    @Override
    public void addBiographicalInfo(BiographicalInfo biographicalInfo) {
        
    }
   
}
