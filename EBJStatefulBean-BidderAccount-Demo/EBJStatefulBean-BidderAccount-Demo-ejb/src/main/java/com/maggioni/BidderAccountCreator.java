package com.maggioni;

import com.maggioni.model.BiographicalInfo;
import com.maggioni.model.BillingInfo;
import javax.ejb.Remote;

@Remote
public interface BidderAccountCreator {
    
    public void addBillingInfo(BillingInfo billingInfo);
    public void addBiographicalInfo(BiographicalInfo biographicalInfo);
}
