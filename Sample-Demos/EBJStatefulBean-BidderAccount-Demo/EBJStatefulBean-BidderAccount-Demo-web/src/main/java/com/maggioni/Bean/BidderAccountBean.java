package com.maggioni.Bean;

import com.maggioni.DefaultBidderAccountCreator;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("bidder")
@SessionScoped
public class BidderAccountBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private DefaultBidderAccountCreator bidderAccountCreator;
    
    public String getBillingInfo() {
        return bidderAccountCreator.addBillingInfo(null);
    }
    
    public String getBibliographicalInfo() {
        return bidderAccountCreator.addBiographicalInfo(null);
    }
}
