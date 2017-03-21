package com.maggioni;

import javax.ejb.Remote;

@Remote
public interface BidderAccountCreator {
    
    public void addBillingInfo(BillingInfo billingInfo);
    public void addBiographicalInfo(BiographicalInfo biographicalInfo);
}
