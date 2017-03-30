package com.maggioni;

import com.maggioni.model.BiographicalInfo;
import com.maggioni.model.BillingInfo;
import javax.ejb.Remote;

@Remote
public interface BidderAccountCreator {
    
    public String addBillingInfo(BillingInfo billingInfo);
    public String addBiographicalInfo(BiographicalInfo biographicalInfo);
}
