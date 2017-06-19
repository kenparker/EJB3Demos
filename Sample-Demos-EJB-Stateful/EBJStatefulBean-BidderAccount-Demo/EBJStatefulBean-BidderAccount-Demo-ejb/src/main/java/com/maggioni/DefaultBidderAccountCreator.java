package com.maggioni;

import com.maggioni.model.BiographicalInfo;
import com.maggioni.model.BillingInfo;
import javax.ejb.Stateful;

@Stateful (name = "BidderAccountCreator")
public class DefaultBidderAccountCreator implements BidderAccountCreator{

    @Override
    public String addBillingInfo(BillingInfo billingInfo) {
       return "BillingInfo added";
    }

    @Override
    public String addBiographicalInfo(BiographicalInfo biographicalInfo) {
        return "BiographicalInfo added";
    }
   
}
